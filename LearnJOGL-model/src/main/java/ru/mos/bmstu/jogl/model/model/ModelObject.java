package ru.mos.bmstu.jogl.model.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ModelObject {
    @Setter
    protected Coordinate3D centralCord;
    protected List<Coordinate3D> vertexes = new ArrayList<>();
    protected List<Edge3D> edges = new ArrayList<>();
    protected List<Polygon3D> polygons = new ArrayList<>();
    protected List<Plan> plans = new ArrayList<>();

    public ModelObject(Coordinate3D centralCord) {
        this.centralCord = centralCord;
    }

    public ModelObject(float x, float y, float z) {
        this(new Coordinate3D(x, y, z));
    }

    public ModelObject(ModelObject modelObject) {
        this.centralCord = modelObject.getCentralCord();
        this.vertexes = modelObject.getVertexes();
        this.edges = modelObject.getEdges();
        this.polygons = modelObject.getPolygons();
        this.plans = modelObject.getPlans();
    }
}
