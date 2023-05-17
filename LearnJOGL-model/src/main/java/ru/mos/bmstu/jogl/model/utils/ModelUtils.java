package ru.mos.bmstu.jogl.model.utils;

import ru.mos.bmstu.jogl.model.model.Coordinate3D;
import ru.mos.bmstu.jogl.model.model.Edge3D;
import ru.mos.bmstu.jogl.model.model.ModelObject;
import ru.mos.bmstu.jogl.model.model.Polygon3D;
import java.util.ArrayList;
import java.util.List;

public class ModelUtils {


    public static void addNewPolygon(ModelObject modelObject, Polygon3D polygon) {
        List<Edge3D> edgesPolygon = polygon.getEdges();
        createPolygonFromEdges(modelObject, edgesPolygon);
    }

    public static boolean isEdgesClosed(List<Edge3D> edges) {
        Coordinate3D startCoordinate = null;
        Coordinate3D lastCoordinate = null;
        Coordinate3D currentCoordinate;
        for (int i = 0; i < edges.size(); i++) {
            Edge3D edge = edges.get(i);
            if (i == 0) {
                startCoordinate = edge.getStartCord();
                lastCoordinate = edge.getEndCord();
                continue;
            }
            currentCoordinate = edge.getStartCord();
            if (currentCoordinate.equals(lastCoordinate)) {
                lastCoordinate = edge.getEndCord();
            } else {
                return false;
            }
            if (i == edges.size() - 1) {
                return lastCoordinate.equals(startCoordinate);
            }
        }
        return true;
    }

    public static void createPolygonFromEdges(ModelObject modelObject, List<Edge3D> edges) {
        List<Coordinate3D> vertexesModel = modelObject.getVertexes();
        List<Edge3D> edgesModel = modelObject.getEdges();
        int firstIndexVertex = vertexesModel.size();
        for (int i = 0; i < edges.size(); i++) {
            Edge3D edge = edges.get(i);
            vertexesModel.add(new Coordinate3D(edge.getStartCord()));
            if (i == edges.size() - 1) {
                vertexesModel.add(new Coordinate3D(edge.getEndCord()));
            }
        }
        int lastIndexVertex = vertexesModel.size();
        int firstIndexEdge = edgesModel.size();
        for (int i = firstIndexVertex; i < lastIndexVertex - 1; i++) {
            edgesModel.add(new Edge3D(vertexesModel.get(i), vertexesModel.get(i + 1)));
        }
        int lastIndexEdge = edgesModel.size();
        List<Edge3D> newEdgeList = new ArrayList<>();
        for (int i = firstIndexEdge; i < lastIndexEdge; i++) {
            newEdgeList.add(edgesModel.get(i));
        }
        modelObject.getPolygons().add(new Polygon3D(newEdgeList));
    }
}
