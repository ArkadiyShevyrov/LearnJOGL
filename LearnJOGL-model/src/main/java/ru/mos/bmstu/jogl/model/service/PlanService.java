package ru.mos.bmstu.jogl.model.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.*;
import ru.mos.bmstu.jogl.model.utils.ConverterND;
import ru.mos.bmstu.jogl.model.utils.ModelUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlanService {
    @Getter
    private PlanEnum planEnum;
    private Plan currentPlane;
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
        }
    }

    private void endCurrentEnum() {
        if (planEnum == null) {
            return;
        }
        switch (planEnum) {
            case NEW_POLYGON -> {
//                ModelUtils.addNewPolygon(currentPlane, currentPolygon);
            }
        }
    }

    public ModelObject getCurrentModelObject() {
        if (planEnum == null) {
            return null;
        }
        ModelObject modelObject = new ModelObject(0, 0, 0);
        switch (planEnum) {
            case NEW_POLYGON -> {
                if (currentPolygon != null) {
                    ModelUtils.addNewPolygon(modelObject, ConverterND.convertTo3D(currentPolygon));
                }
            }
        }
        return modelObject;
    }

    public void clearAll() {
        currentPolygon = new Polygon2D();
    }

    public enum PlanEnum {
        NONE,
        NEW_POLYGON,
    }
}
