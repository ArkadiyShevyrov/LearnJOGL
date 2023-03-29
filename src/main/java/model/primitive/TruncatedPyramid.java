package model.primitive;

import lombok.Getter;
import lombok.Setter;
import model.Coordinate;
import model.Edge;
import model.ModelObject;
import model.Polygon;

@Getter
public class TruncatedPyramid extends ModelObject {
    private float edgeLength;
    private float offsetOxy;

    public TruncatedPyramid(float x, float y, float z, float edgeLength) {
        super(x, y, z);
        this.edgeLength = edgeLength;
        this.offsetOxy = edgeLength / 4;
        init();
    }

    @Override
    protected void init() {
        initVertexes();
        initEdges();
        initPolygons();
    }

    @Override
    protected void initVertexes() {
        float y = centralCord.getY();
        float x = centralCord.getX();
        float z = centralCord.getZ();
        float edgeRadius = edgeLength / 2;
        this.vertexes.add(new Coordinate(x - edgeRadius, y - edgeRadius, z - edgeRadius));
        this.vertexes.add(new Coordinate(x + edgeRadius, y - edgeRadius, z - edgeRadius));
        this.vertexes.add(new Coordinate(x + edgeRadius, y + edgeRadius, z - edgeRadius));
        this.vertexes.add(new Coordinate(x - edgeRadius, y + edgeRadius, z - edgeRadius));

        float offset = (float) Math.sqrt(Math.pow(edgeRadius,2)-Math.pow(offsetOxy,2));
        this.vertexes.add(new Coordinate(x - edgeRadius + offsetOxy, y - edgeRadius + offsetOxy, z + edgeRadius-offset));
        this.vertexes.add(new Coordinate(x + edgeRadius - offsetOxy, y - edgeRadius + offsetOxy, z + edgeRadius-offset));
        this.vertexes.add(new Coordinate(x + edgeRadius - offsetOxy, y + edgeRadius - offsetOxy, z + edgeRadius-offset));
        this.vertexes.add(new Coordinate(x - edgeRadius + offsetOxy, y + edgeRadius - offsetOxy, z + edgeRadius-offset));
    }

    @Override
    protected void initEdges() {
        this.edges.add(new Edge(vertexes.get(0), vertexes.get(1)));
        this.edges.add(new Edge(vertexes.get(1), vertexes.get(2)));
        this.edges.add(new Edge(vertexes.get(2), vertexes.get(3)));
        this.edges.add(new Edge(vertexes.get(3), vertexes.get(0)));

        this.edges.add(new Edge(vertexes.get(0), vertexes.get(4)));
        this.edges.add(new Edge(vertexes.get(1), vertexes.get(5)));
        this.edges.add(new Edge(vertexes.get(2), vertexes.get(6)));
        this.edges.add(new Edge(vertexes.get(3), vertexes.get(7)));

        this.edges.add(new Edge(vertexes.get(4), vertexes.get(5)));
        this.edges.add(new Edge(vertexes.get(5), vertexes.get(6)));
        this.edges.add(new Edge(vertexes.get(6), vertexes.get(7)));
        this.edges.add(new Edge(vertexes.get(7), vertexes.get(4)));
    }

    @Override
    protected void initPolygons() {
        this.polygons.add(new Polygon(vertexes.get(0), vertexes.get(1), vertexes.get(2), vertexes.get(3)));

        this.polygons.add(new Polygon(vertexes.get(0), vertexes.get(1), vertexes.get(5), vertexes.get(4)));
        this.polygons.add(new Polygon(vertexes.get(1), vertexes.get(2), vertexes.get(6), vertexes.get(5)));
        this.polygons.add(new Polygon(vertexes.get(2), vertexes.get(3), vertexes.get(7), vertexes.get(6)));
        this.polygons.add(new Polygon(vertexes.get(3), vertexes.get(0), vertexes.get(4), vertexes.get(7)));

        this.polygons.add(new Polygon(vertexes.get(4), vertexes.get(5), vertexes.get(6), vertexes.get(7)));
    }

    public void setEdgeLength(float edgeLength) {
        this.edgeLength = edgeLength;
        init();
    }

    public void setOffsetOxy(float offsetOxy) {
        this.offsetOxy = offsetOxy;
        init();
    }
}
