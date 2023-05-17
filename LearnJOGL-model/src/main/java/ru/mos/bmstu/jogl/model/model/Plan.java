package ru.mos.bmstu.jogl.model.model;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Plan extends Plane {
    protected List<Coordinate2D> vertexes = new ArrayList<>();
    protected List<Edge2D> edges = new ArrayList<>();
    protected List<Polygon2D> polygons = new ArrayList<>();

    public Plan(Coordinate3D centralCord) {
        super(centralCord);
    }
}
