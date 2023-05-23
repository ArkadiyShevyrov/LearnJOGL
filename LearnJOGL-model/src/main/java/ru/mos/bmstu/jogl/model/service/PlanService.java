package ru.mos.bmstu.jogl.model.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.*;
import ru.mos.bmstu.jogl.model.utils.ConverterND;
import ru.mos.bmstu.jogl.model.utils.Intersection;
import ru.mos.bmstu.jogl.model.utils.ModelUtils;
import ru.mos.bmstu.jogl.model.utils.PlanUtils;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlanService {
    private Plan currentPlane = new Plan(new Coordinate3D(0, 0, 0));
    @Getter
    private PlanEnum planEnum;
    private Polygon2D currentPolygon;

    public void click(float x, float y) {
        if (planEnum == null) {
            return;
        }
        switch (planEnum) {
            case NEW_POLYGON -> addVertexToPolygon(x, y);
        }
    }

    private void addVertexToPolygon(float x, float y) {
        Coordinate2D newCoordinate = new Coordinate2D(x, y);
        int countVertexes = currentPolygon.getVertexes().size();
        if (countVertexes == 0) {
            Edge2D newEdge = new Edge2D();
            newEdge.setStartCord(newCoordinate);
            newEdge.setEndCord(newCoordinate);
            currentPolygon.getEdges().add(newEdge);
        } else {
            Edge2D lastEdge = currentPolygon.getEdges().get(currentPolygon.getEdges().size() - 1);
            Edge2D newEdge = new Edge2D();
            newEdge.setStartCord(newCoordinate);
            newEdge.setEndCord(lastEdge.getEndCord());
            lastEdge.setEndCord(newCoordinate);
            currentPolygon.getEdges().add(newEdge);
        }
    }

    public void setPlanEnum(PlanEnum planEnum) {
        endCurrentEnum();
        this.planEnum = planEnum;
        switch (planEnum) {
            case NEW_POLYGON -> {
                currentPolygon = new Polygon2D();
            }
            case INTERSECTION_OF_POLYGONS -> {
                intersectionPolygons();
            }
        }
    }

    private void intersectionPolygons() {
        List<Polygon2D> polygons = currentPlane.getPolygons();
        if (polygons.size() == 1) {
            return;
        }
        if (polygons.size() == 2) {
            List<Coordinate2D> intersection = Intersection.intersection(polygons.get(0), polygons.get(1));
            List<Edge2D> edgesFromVertexes = PlanUtils.createEdgesFromVertexes(intersection);
            Polygon2D polygon = new Polygon2D(edgesFromVertexes);
            currentPlane = new Plan(currentPlane.getCentralCord());
            PlanUtils.addNewPolygon(currentPlane, polygon);
        }
    }

    private void endCurrentEnum() {
        if (planEnum == null) {
            return;
        }
        switch (planEnum) {
            case NEW_POLYGON -> PlanUtils.addNewPolygon(currentPlane, currentPolygon);
        }
    }

    public ModelObject getCurrentModelObject() {
        if (planEnum == null) {
            return null;
        }
        switch (planEnum) {
            case NEW_POLYGON -> {
                ModelObject modelObject = new ModelObject(0, 0, 0);
                ModelUtils.addNewPolygon(modelObject, ConverterND.convertTo3D(currentPolygon));
                return modelObject;
            }
            default -> {
                return PlanUtils.convertToModel(currentPlane);
            }
        }
    }

    public enum PlanEnum {
        NONE,
        NEW_POLYGON,
        INTERSECTION_OF_POLYGONS,
    }
}
