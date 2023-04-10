package ru.mos.bmstu.jojl.model.model;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class ModelObject {
    protected Coordinate centralCord;
    protected List<Coordinate> vertexes = new ArrayList<>();
    protected List<Edge> edges = new ArrayList<>();
    protected List<Polygon> polygons = new ArrayList<>();

    public ModelObject(Coordinate centralCord) {
        this.centralCord = centralCord;
    }

    public ModelObject(float x, float y, float z) {
        this(new Coordinate(x, y, z));
    }

    abstract protected void init();

    abstract protected void initVertexes();

    abstract protected void initEdges();

    abstract protected void initPolygons();
}
