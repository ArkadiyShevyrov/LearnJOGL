//package ru.mos.bmstu.jogl.model.model.primitive;
//
//import lombok.Getter;
//import ru.mos.bmstu.jogl.model.model.Coordinate3D;
//import ru.mos.bmstu.jogl.model.model.Edge3D;
//import ru.mos.bmstu.jogl.model.model.ModelObject;
//import ru.mos.bmstu.jogl.model.model.Polygon3D;
//
//@Getter
//public class TruncatedPyramid extends ModelObject {
//    private float edgeLength;
//    private float offsetOxy;
//
//    public TruncatedPyramid(float x, float y, float z, float edgeLength) {
//        super(x, y, z);
//        this.edgeLength = edgeLength;
//        this.offsetOxy = edgeLength / 4;
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
//    protected void updateVertexes() {
//        float y = 0;
//        float x = 0;
//        float z = 0;
//        float edgeRadius = edgeLength / 2;
//        this.vertexes.set(0, new Coordinate3D(x - edgeRadius, y - edgeRadius, z - edgeRadius));
//        this.vertexes.set(1, new Coordinate3D(x + edgeRadius, y - edgeRadius, z - edgeRadius));
//        this.vertexes.set(2, new Coordinate3D(x + edgeRadius, y + edgeRadius, z - edgeRadius));
//        this.vertexes.set(3, new Coordinate3D(x - edgeRadius, y + edgeRadius, z - edgeRadius));
//
//        float offset = (float) Math.sqrt(Math.pow(edgeRadius, 2) - Math.pow(offsetOxy, 2));
//        this.vertexes.set(4, new Coordinate3D(x - edgeRadius + offsetOxy, y - edgeRadius + offsetOxy, z + edgeRadius - offset));
//        this.vertexes.set(5, new Coordinate3D(x + edgeRadius - offsetOxy, y - edgeRadius + offsetOxy, z + edgeRadius - offset));
//        this.vertexes.set(6, new Coordinate3D(x + edgeRadius - offsetOxy, y + edgeRadius - offsetOxy, z + edgeRadius - offset));
//        this.vertexes.set(7, new Coordinate3D(x - edgeRadius + offsetOxy, y + edgeRadius - offsetOxy, z + edgeRadius - offset));
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
//        float offset = (float) Math.sqrt(Math.pow(edgeRadius, 2) - Math.pow(offsetOxy, 2));
//        this.vertexes.add(new Coordinate3D(x - edgeRadius + offsetOxy, y - edgeRadius + offsetOxy, z + edgeRadius - offset));
//        this.vertexes.add(new Coordinate3D(x + edgeRadius - offsetOxy, y - edgeRadius + offsetOxy, z + edgeRadius - offset));
//        this.vertexes.add(new Coordinate3D(x + edgeRadius - offsetOxy, y + edgeRadius - offsetOxy, z + edgeRadius - offset));
//        this.vertexes.add(new Coordinate3D(x - edgeRadius + offsetOxy, y + edgeRadius - offsetOxy, z + edgeRadius - offset));
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
//    protected void updEdges() {
//        this.edges.set(0, new Edge3D(vertexes.get(0), vertexes.get(1)));
//        this.edges.set(1, new Edge3D(vertexes.get(1), vertexes.get(2)));
//        this.edges.set(2, new Edge3D(vertexes.get(2), vertexes.get(3)));
//        this.edges.set(3, new Edge3D(vertexes.get(3), vertexes.get(0)));
//
//        this.edges.set(4, new Edge3D(vertexes.get(0), vertexes.get(4)));
//        this.edges.set(5, new Edge3D(vertexes.get(1), vertexes.get(5)));
//        this.edges.set(6, new Edge3D(vertexes.get(2), vertexes.get(6)));
//        this.edges.set(7, new Edge3D(vertexes.get(3), vertexes.get(7)));
//
//        this.edges.set(8, new Edge3D(vertexes.get(4), vertexes.get(5)));
//        this.edges.set(9, new Edge3D(vertexes.get(5), vertexes.get(6)));
//        this.edges.set(10, new Edge3D(vertexes.get(6), vertexes.get(7)));
//        this.edges.set(11, new Edge3D(vertexes.get(7), vertexes.get(4)));
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
//    protected void updPolygons() {
//        this.polygons.set(0, new Polygon3D(vertexes.get(0), vertexes.get(1), vertexes.get(2), vertexes.get(3)));
//
//        this.polygons.set(1, new Polygon3D(vertexes.get(0), vertexes.get(1), vertexes.get(5), vertexes.get(4)));
//        this.polygons.set(2, new Polygon3D(vertexes.get(1), vertexes.get(2), vertexes.get(6), vertexes.get(5)));
//        this.polygons.set(3, new Polygon3D(vertexes.get(2), vertexes.get(3), vertexes.get(7), vertexes.get(6)));
//        this.polygons.set(4, new Polygon3D(vertexes.get(3), vertexes.get(0), vertexes.get(4), vertexes.get(7)));
//
//        this.polygons.set(5, new Polygon3D(vertexes.get(4), vertexes.get(5), vertexes.get(6), vertexes.get(7)));
//    }
//
//    public void setEdgeLength(float edgeLength) {
//        this.edgeLength = edgeLength;
//        updateVertexes();
//        updEdges();
//        updPolygons();
//    }
//
//    public void setOffsetOxy(float offsetOxy) {
//        this.offsetOxy = offsetOxy;
//        updateVertexes();
//        updEdges();
//        updPolygons();
//    }
//}
