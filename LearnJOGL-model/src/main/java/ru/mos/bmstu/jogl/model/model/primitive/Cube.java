//package ru.mos.bmstu.jogl.model.model.primitive;
//
//import lombok.Getter;
//import ru.mos.bmstu.jogl.model.model.Coordinate3D;
//import ru.mos.bmstu.jogl.model.model.Edge3D;
//import ru.mos.bmstu.jogl.model.model.ModelObject;
//import ru.mos.bmstu.jogl.model.model.Polygon3D;
//
//@Getter
//public class Cube extends ModelObject {
//    private float edgeLength;
//
//    public Cube(float x, float y, float z, float edgeLength) {
//        super(x, y, z);
//        this.edgeLength = edgeLength;
//        init();
//    }
//
//    @Override
//    protected void init() {
//        initVertexes();
//        initEdges();
//        initPolygons();
//    }
//
//    protected void update() {
//        float y = 0;
//        float x = 0;
//        float z = 0;
//        float edgeRadius = edgeLength / 2;
//        this.vertexes.set(0, new Coordinate3D(x - edgeRadius, y - edgeRadius, z - edgeRadius));
//        this.vertexes.set(1, new Coordinate3D(x + edgeRadius, y - edgeRadius, z - edgeRadius));
//        this.vertexes.set(2, new Coordinate3D(x + edgeRadius, y + edgeRadius, z - edgeRadius));
//        this.vertexes.set(3, new Coordinate3D(x - edgeRadius, y + edgeRadius, z - edgeRadius));
//
//        this.vertexes.set(4, new Coordinate3D(x - edgeRadius, y - edgeRadius, z + edgeRadius));
//        this.vertexes.set(5, new Coordinate3D(x + edgeRadius, y - edgeRadius, z + edgeRadius));
//        this.vertexes.set(6, new Coordinate3D(x + edgeRadius, y + edgeRadius, z + edgeRadius));
//        this.vertexes.set(7, new Coordinate3D(x - edgeRadius, y + edgeRadius, z + edgeRadius));
//    }
//
//    @Override
//    protected void initVertexes() {
//        float y = 0;
//        float x = 0;
//        float z = 0;
//        float edgeRadius = edgeLength / 2;
//        this.vertexes.add(new Coordinate3D(x - edgeRadius, y - edgeRadius, z - edgeRadius));
//        this.vertexes.add(new Coordinate3D(x + edgeRadius, y - edgeRadius, z - edgeRadius));
//        this.vertexes.add(new Coordinate3D(x + edgeRadius, y + edgeRadius, z - edgeRadius));
//        this.vertexes.add(new Coordinate3D(x - edgeRadius, y + edgeRadius, z - edgeRadius));
//
//        this.vertexes.add(new Coordinate3D(x - edgeRadius, y - edgeRadius, z + edgeRadius));
//        this.vertexes.add(new Coordinate3D(x + edgeRadius, y - edgeRadius, z + edgeRadius));
//        this.vertexes.add(new Coordinate3D(x + edgeRadius, y + edgeRadius, z + edgeRadius));
//        this.vertexes.add(new Coordinate3D(x - edgeRadius, y + edgeRadius, z + edgeRadius));
//    }
//
//    @Override
//    protected void initEdges() {
//        this.edges.add(new Edge3D(vertexes.get(0), vertexes.get(1)));
//        this.edges.add(new Edge3D(vertexes.get(1), vertexes.get(2)));
//        this.edges.add(new Edge3D(vertexes.get(2), vertexes.get(3)));
//        this.edges.add(new Edge3D(vertexes.get(3), vertexes.get(0)));
//
//        this.edges.add(new Edge3D(vertexes.get(0), vertexes.get(4)));
//        this.edges.add(new Edge3D(vertexes.get(1), vertexes.get(5)));
//        this.edges.add(new Edge3D(vertexes.get(2), vertexes.get(6)));
//        this.edges.add(new Edge3D(vertexes.get(3), vertexes.get(7)));
//
//        this.edges.add(new Edge3D(vertexes.get(4), vertexes.get(5)));
//        this.edges.add(new Edge3D(vertexes.get(5), vertexes.get(6)));
//        this.edges.add(new Edge3D(vertexes.get(6), vertexes.get(7)));
//        this.edges.add(new Edge3D(vertexes.get(7), vertexes.get(4)));
//    }
//
//    @Override
//    protected void initPolygons() {
//        this.polygons.add(new Polygon3D(vertexes.get(0), vertexes.get(1), vertexes.get(2), vertexes.get(3)));
//
//        this.polygons.add(new Polygon3D(vertexes.get(0), vertexes.get(1), vertexes.get(5), vertexes.get(4)));
//        this.polygons.add(new Polygon3D(vertexes.get(1), vertexes.get(2), vertexes.get(6), vertexes.get(5)));
//        this.polygons.add(new Polygon3D(vertexes.get(2), vertexes.get(3), vertexes.get(7), vertexes.get(6)));
//        this.polygons.add(new Polygon3D(vertexes.get(3), vertexes.get(0), vertexes.get(4), vertexes.get(7)));
//
//        this.polygons.add(new Polygon3D(vertexes.get(4), vertexes.get(5), vertexes.get(6), vertexes.get(7)));
//    }
//
//    public void setEdgeLength(float edgeLength) {
//        this.edgeLength = edgeLength;
//        update();
//    }
//}
