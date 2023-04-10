package ru.mos.bmstu.jojl.viewcontrol.utils;

import com.jogamp.opengl.GL2;
import ru.mos.bmstu.jojl.model.model.Coordinate;
import ru.mos.bmstu.jojl.model.model.ModelObject;
import ru.mos.bmstu.jojl.model.model.Edge;
import ru.mos.bmstu.jojl.model.model.Polygon;
import java.util.List;

public class DrawObject {
    public static void drawEdges(GL2 gl, ModelObject modelObject) {
        gl.glBegin(GL2.GL_LINES);
        for (Edge edge : modelObject.getEdges()) {
            Coordinate startCord = edge.getStartCord();
            Coordinate endCord = edge.getEndCord();
            gl.glVertex3f(startCord.getX(), startCord.getY(), startCord.getZ());
            gl.glVertex3f(endCord.getX(), endCord.getY(), endCord.getZ());
        }
        gl.glEnd();
    }

    public static void drawPolygon(GL2 gl, ModelObject modelObject) {
        if (modelObject.getPolygons() == null) {
            return;
        }
        for (Polygon polygon : modelObject.getPolygons()) {
            List<Coordinate> vertexes = polygon.getVertexes();
            switch (vertexes.size()) {
                case 3: {
                    gl.glBegin(GL2.GL_TRIANGLES);
                    for (Coordinate coordinate : vertexes) {
                        gl.glVertex3f(coordinate.getX(), coordinate.getY(), coordinate.getZ());
                    }
                    gl.glEnd();
                }
                case 4: {
                    gl.glBegin(GL2.GL_QUADS);
                    for (Coordinate coordinate : vertexes) {
                        gl.glVertex3f(coordinate.getX(), coordinate.getY(), coordinate.getZ());
                    }
                    gl.glEnd();
                }
            }
        }
    }
}
