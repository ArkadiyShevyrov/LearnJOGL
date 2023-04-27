package ru.mos.bmstu.jogl.model.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ModelObject {
    @Setter
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

    public ModelObject(ModelObject modelObject) {
        this.centralCord = modelObject.getCentralCord();
        this.vertexes = modelObject.getVertexes();
        this.edges = modelObject.getEdges();
        this.polygons = modelObject.getPolygons();
    }

    protected void init(){};

    protected void initVertexes(){};

    protected void initEdges(){};

    protected void initPolygons(){};
}
