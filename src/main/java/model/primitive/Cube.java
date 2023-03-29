package model.primitive;

import lombok.Getter;
import model.Coordinate;
import model.Edge;
import model.ModelObject;
import model.Polygon;

@Getter
public class Cube extends ModelObject {
    private float edgeLength;

    public Cube(float x, float y, float z, float edgeLength) {
        super(x, y, z);
        this.edgeLength = edgeLength;
        init();
    }

    @Override
    protected void init() {
        initVertexes();
        initEdges();
        initPolygons();
    }

    protected void updateVertexes() {
        float y = centralCord.getY();
        float x = centralCord.getX();
        float z = centralCord.getZ();
        float edgeRadius = edgeLength / 2;
        this.vertexes.set(0, new Coordinate(x - edgeRadius, y - edgeRadius, z - edgeRadius));
        this.vertexes.set(1, new Coordinate(x + edgeRadius, y - edgeRadius, z - edgeRadius));
        this.vertexes.set(2, new Coordinate(x + edgeRadius, y + edgeRadius, z - edgeRadius));
        this.vertexes.set(3, new Coordinate(x - edgeRadius, y + edgeRadius, z - edgeRadius));

        this.vertexes.set(4, new Coordinate(x - edgeRadius, y - edgeRadius, z + edgeRadius));
        this.vertexes.set(5, new Coordinate(x + edgeRadius, y - edgeRadius, z + edgeRadius));
        this.vertexes.set(6, new Coordinate(x + edgeRadius, y + edgeRadius, z + edgeRadius));
        this.vertexes.set(7, new Coordinate(x - edgeRadius, y + edgeRadius, z + edgeRadius));
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

        this.vertexes.add(new Coordinate(x - edgeRadius, y - edgeRadius, z + edgeRadius));
        this.vertexes.add(new Coordinate(x + edgeRadius, y - edgeRadius, z + edgeRadius));
        this.vertexes.add(new Coordinate(x + edgeRadius, y + edgeRadius, z + edgeRadius));
        this.vertexes.add(new Coordinate(x - edgeRadius, y + edgeRadius, z + edgeRadius));
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

    protected void updEdges() {
        this.edges.set(0, new Edge(vertexes.get(0), vertexes.get(1)));
        this.edges.set(1, new Edge(vertexes.get(1), vertexes.get(2)));
        this.edges.set(2, new Edge(vertexes.get(2), vertexes.get(3)));
        this.edges.set(3, new Edge(vertexes.get(3), vertexes.get(0)));

        this.edges.set(4, new Edge(vertexes.get(0), vertexes.get(4)));
        this.edges.set(5, new Edge(vertexes.get(1), vertexes.get(5)));
        this.edges.set(6, new Edge(vertexes.get(2), vertexes.get(6)));
        this.edges.set(7, new Edge(vertexes.get(3), vertexes.get(7)));

        this.edges.set(8, new Edge(vertexes.get(4), vertexes.get(5)));
        this.edges.set(9, new Edge(vertexes.get(5), vertexes.get(6)));
        this.edges.set(10, new Edge(vertexes.get(6), vertexes.get(7)));
        this.edges.set(11, new Edge(vertexes.get(7), vertexes.get(4)));
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

    protected void updPolygons() {
        this.polygons.set(0, new Polygon(vertexes.get(0), vertexes.get(1), vertexes.get(2), vertexes.get(3)));

        this.polygons.set(1, new Polygon(vertexes.get(0), vertexes.get(1), vertexes.get(5), vertexes.get(4)));
        this.polygons.set(2, new Polygon(vertexes.get(1), vertexes.get(2), vertexes.get(6), vertexes.get(5)));
        this.polygons.set(3, new Polygon(vertexes.get(2), vertexes.get(3), vertexes.get(7), vertexes.get(6)));
        this.polygons.set(4, new Polygon(vertexes.get(3), vertexes.get(0), vertexes.get(4), vertexes.get(7)));

        this.polygons.set(5, new Polygon(vertexes.get(4), vertexes.get(5), vertexes.get(6), vertexes.get(7)));
    }

    public void setEdgeLength(float edgeLength) {
        this.edgeLength = edgeLength;
        updateVertexes();
        updEdges();
        updPolygons();
    }
}
