package ru.mos.bmstu.jogl.view.viewcontrol.utils;

import com.jogamp.nativewindow.util.Rectangle;
import com.jogamp.opengl.GL2;
import ru.mos.bmstu.jogl.model.model.Coordinate;
import ru.mos.bmstu.jogl.model.model.Edge;
import ru.mos.bmstu.jogl.model.model.ModelObject;
import ru.mos.bmstu.jogl.model.model.Polygon;
import java.util.List;


public class DrawObject {
    public static void drawEdges(GL2 gl, ModelObject modelObject) {
        Coordinate centralCord = modelObject.getCentralCord();
        gl.glBegin(GL2.GL_LINES);
        for (Edge edge : modelObject.getEdges()) {
            Coordinate startCord = edge.getStartCord();
            Coordinate endCord = edge.getEndCord();
            gl.glVertex3f(startCord.getX() + centralCord.getX(),
                    startCord.getY() + centralCord.getY(),
                    startCord.getZ() + centralCord.getZ());
            gl.glVertex3f(endCord.getX() + centralCord.getX(),
                    endCord.getY() + centralCord.getY(),
                    endCord.getZ() + centralCord.getZ());
        }
        gl.glEnd();
    }

    public static void drawPolygon(GL2 gl, ModelObject modelObject) {
        if (modelObject.getPolygons() == null) {
            return;
        }
        Coordinate centralCord = modelObject.getCentralCord();
        for (Polygon polygon : modelObject.getPolygons()) {
            List<Coordinate> vertexes = polygon.getVertexes();
            switch (vertexes.size()) {
                case 3: {
                    gl.glBegin(GL2.GL_TRIANGLES);
                    for (Coordinate coordinate : vertexes) {
                        gl.glVertex3f(coordinate.getX() + centralCord.getX(),
                                coordinate.getY() + centralCord.getY(),
                                coordinate.getZ() + centralCord.getZ());
                    }
                    gl.glEnd();
                }
                case 4: {
                    gl.glBegin(GL2.GL_QUADS);
                    for (Coordinate coordinate : vertexes) {
                        gl.glVertex3f(coordinate.getX() + centralCord.getX(),
                                coordinate.getY() + centralCord.getY(),
                                coordinate.getZ() + centralCord.getZ());
                    }
                    gl.glEnd();
                }
            }
        }
    }

    public static void drawBorder(GL2 gl, Rectangle border) {
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-border.getWidth() + 1, -border.getHeight(), 0);
        gl.glVertex3f(-border.getWidth(), border.getHeight(), 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-border.getWidth(), border.getHeight() - 1, 0);
        gl.glVertex3f(border.getWidth(), border.getHeight(), 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(border.getWidth(), border.getHeight(), 0);
        gl.glVertex3f(border.getWidth(), -border.getHeight(), 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(border.getWidth(), -border.getHeight(), 0);
        gl.glVertex3f(-border.getWidth(), -border.getHeight(), 0);
        gl.glEnd();
    }

    public static void drawModelObject(GL2 gl, ModelObject modelObject) {
        if (false) {
            gl.glColor3f(1, 0, 1);
            drawPolygon(gl, modelObject);
        }

        gl.glColor3f(1, 1, 1);
        drawEdges(gl, modelObject);
    }

    public static void drawModelObject(GL2 gl, ModelObject modelObject, float size, boolean isPolygon) {
        if (isPolygon) {
            gl.glColor3f(1, 0, 1);
            drawPolygon(gl, modelObject, size);
        }
        gl.glColor3f(1, 1, 1);
        drawEdges(gl, modelObject, size);
    }

    public static void drawCurrentModelObject(GL2 gl, ModelObject modelObject, float size, boolean isPolygon) {
        if (isPolygon) {
            gl.glColor3f(0.3f, 0, 1);
            drawPolygon(gl, modelObject, size);
        }
        gl.glColor3f(0.3f, 1, 1);
        drawEdges(gl, modelObject, size);
    }

    private static void drawEdges(GL2 gl, ModelObject modelObject, float size) {
        Coordinate centralCord = modelObject.getCentralCord();
        gl.glBegin(GL2.GL_LINES);
        for (Edge edge : modelObject.getEdges()) {
            Coordinate startCord = edge.getStartCord();
            Coordinate endCord = edge.getEndCord();
            gl.glVertex3f(size*(startCord.getX() + centralCord.getX()),
                    size*(startCord.getY() + centralCord.getY()),
                    size*(startCord.getZ() + centralCord.getZ()));
            gl.glVertex3f(size*(endCord.getX() + centralCord.getX()),
                    size*(endCord.getY() + centralCord.getY()),
                    size*(endCord.getZ() + centralCord.getZ()));
        }
        gl.glEnd();
    }

    private static void drawPolygon(GL2 gl, ModelObject modelObject, float size) {
        if (modelObject.getPolygons() == null) {
            return;
        }
        Coordinate centralCord = modelObject.getCentralCord();
        for (Polygon polygon : modelObject.getPolygons()) {
            List<Coordinate> vertexes = polygon.getVertexes();
            switch (vertexes.size()) {
                case 3: {
                    gl.glBegin(GL2.GL_TRIANGLES);
                    for (Coordinate coordinate : vertexes) {
                        gl.glVertex3f(size*(coordinate.getX() + centralCord.getX()),
                                size*(coordinate.getY() + centralCord.getY()),
                                size*(coordinate.getZ() + centralCord.getZ()));
                    }
                    gl.glEnd();
                }
                case 4: {
                    gl.glBegin(GL2.GL_QUADS);
                    for (Coordinate coordinate : vertexes) {
                        gl.glVertex3f(size*(coordinate.getX() + centralCord.getX()),
                                size*(coordinate.getY() + centralCord.getY()),
                                size*(coordinate.getZ() + centralCord.getZ()));
                    }
                    gl.glEnd();
                }
            }
        }
    }
}
