package model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cube {
    private Coordinate centralCord;
    private List<Coordinate> vertexes = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();

    private float edgeLength;

    public Cube(Coordinate centralCord, float edgeLength) {
        this.centralCord = centralCord;
        this.edgeLength = edgeLength;
        init();
    }

    public Cube(float x, float y, float z, float edgeLength) {
        this(new Coordinate(x, y, z), edgeLength);
    }

    public Cube(float x, float y, float z) {
        this(x, y, z, 1.0f);
    }

    private void init() {
        float y = centralCord.getY();
        float x = centralCord.getX();
        float z = centralCord.getZ();
        float edgeRadius = edgeLength / 2;
        initVertexes(y, x, z, edgeRadius);
        initEdges();
    }

    private void initVertexes(float y, float x, float z, float edgeRadius) {
        this.vertexes.add(new Coordinate(x - edgeRadius, y - edgeRadius, z + edgeRadius));
        this.vertexes.add(new Coordinate(x + edgeRadius, y - edgeRadius, z + edgeRadius));
        this.vertexes.add(new Coordinate(x + edgeRadius, y + edgeRadius, z + edgeRadius));
        this.vertexes.add(new Coordinate(x - edgeRadius, y + edgeRadius, z + edgeRadius));

        this.vertexes.add(new Coordinate(x - edgeRadius, y - edgeRadius, z - edgeRadius));
        this.vertexes.add(new Coordinate(x + edgeRadius, y - edgeRadius, z - edgeRadius));
        this.vertexes.add(new Coordinate(x + edgeRadius, y + edgeRadius, z - edgeRadius));
        this.vertexes.add(new Coordinate(x - edgeRadius, y + edgeRadius, z - edgeRadius));
    }

    private void initEdges() {
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
}
