package ru.mos.bmstu.jogl.model.utils;

import ru.mos.bmstu.jogl.model.model.*;
import java.util.ArrayList;
import java.util.List;

public class PlanUtils {
    public static void addNewPolygon(Plan plan, Polygon2D polygon) {
        List<Edge2D> edgesPolygon = polygon.getEdges();
        createPolygonFromEdges(plan, edgesPolygon);
    }

    public static void createPolygonFromEdges(Plan plan, List<Edge2D> edges) {
        List<Coordinate2D> vertexesModel = plan.getVertexes();
        List<Edge2D> edgesModel = plan.getEdges();
        int firstIndexVertex = vertexesModel.size();
        for (int i = 0; i < edges.size(); i++) {
            Edge2D edge = edges.get(i);
            vertexesModel.add(new Coordinate2D(edge.getStartCord()));
            if (i == edges.size() - 1) {
                vertexesModel.add(new Coordinate2D(edge.getEndCord()));
            }
        }
        int lastIndexVertex = vertexesModel.size();
        int firstIndexEdge = edgesModel.size();
        for (int i = firstIndexVertex; i < lastIndexVertex - 1; i++) {
            edgesModel.add(new Edge2D(vertexesModel.get(i), vertexesModel.get(i + 1)));
        }
        int lastIndexEdge = edgesModel.size();
        List<Edge2D> newEdgeList = new ArrayList<>();
        for (int i = firstIndexEdge; i < lastIndexEdge; i++) {
            newEdgeList.add(edgesModel.get(i));
        }
        plan.getPolygons().add(new Polygon2D(newEdgeList));
    }

    public static ModelObject convertToModel(Plan currentPlane) {
        ModelObject modelObject = new ModelObject(currentPlane.getCentralCord());

        for (Polygon2D polygon2D : currentPlane.getPolygons()) {
            Polygon3D polygon3D = ConverterND.convertTo3D(polygon2D);
            ModelUtils.addNewPolygon(modelObject, polygon3D);
        }
        return modelObject;
    }
}
