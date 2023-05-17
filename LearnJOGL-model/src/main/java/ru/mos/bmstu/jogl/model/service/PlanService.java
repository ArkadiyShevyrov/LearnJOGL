package ru.mos.bmstu.jogl.model.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.*;
import ru.mos.bmstu.jogl.model.utils.ConverterND;
import ru.mos.bmstu.jogl.model.utils.ModelUtils;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlanService {
    @Getter
    private PlanEnum planEnum = PlanEnum.NEW_POLYGON;
    private Plan currentPlane;
    private Polygon2D currentPolygon;
    private Edge2D currentEdge;
    private Coordinate2D currentVertex;

    public void click(float x, float y) {
        switch (planEnum) {
            case NEW_POLYGON -> addVertexToPolygon(x, y);
        }
    }

    private void addVertexToPolygon(float x, float y) {
        Coordinate2D newCoordinate = new Coordinate2D(x, y);
        if (currentVertex == null) {
            currentVertex = newCoordinate;
            return;
        }
        if (currentEdge == null) {
            currentEdge = new Edge2D(currentVertex, newCoordinate);
            return;
        }
        if (currentPolygon == null) {
            currentPolygon = new Polygon2D(currentEdge,
                    new Edge2D(currentEdge.getEndCord(), newCoordinate),
                    new Edge2D(newCoordinate, currentEdge.getStartCord()));
            return;
        }
        List<Edge2D> edges = currentPolygon.getEdges();
        Coordinate2D startCord = edges.get(0).getStartCord();
        Edge2D lastEdge = edges.get(edges.size() - 1);
        lastEdge.setEndCord(newCoordinate);
        edges.add(new Edge2D(newCoordinate, startCord));
    }

    public void setPlanEnum(PlanEnum planEnum) {
        this.planEnum = planEnum;
        switch (planEnum) {
            case NEW_POLYGON -> {
                currentPolygon = null;
                currentEdge = null;
                currentVertex = null;
            }
        }
    }

    public ModelObject getCurrentModelObject() {
        ModelObject modelObject = new ModelObject(0,0,0);
        switch (planEnum) {
            case NEW_POLYGON -> {
                if (currentPolygon != null) {
                    ModelUtils.addNewPolygon(modelObject, ConverterND.convertTo3D(currentPolygon));
                }
            }
        }
        return modelObject;
    }

    public enum PlanEnum {
        NEW_POLYGON,
    }
}
