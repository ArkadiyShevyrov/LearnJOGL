package ru.mos.bmstu.jogl.view.viewcontrol.service;

import com.jogamp.opengl.GL2;
import ru.mos.bmstu.jogl.model.model.ModelObject;
import ru.mos.bmstu.jogl.model.model.primitive.Cube;
import ru.mos.bmstu.jogl.view.viewcontrol.utils.DrawObject;
import java.nio.DoubleBuffer;

public class DRAWOB {
    private float rotateX, rotateY, rotateZ;
    private boolean isPolygon;

    private void drawModelObject(GL2 gl, ModelObject modelObject) {
        if (isPolygon) {
            gl.glColor3f(1, 0, 1);
            DrawObject.drawPolygon(gl, modelObject);
        }

        gl.glColor3f(1, 1, 1);
        DrawObject.drawEdges(gl, modelObject);
    }


    private void drawLab4(GL2 gl) {
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-10, 10, -10, 10, -10, 10);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glRotatef(-90 + 15, 1, 0, 0);
        gl.glRotatef(0, 0, 1, 0);
        gl.glRotatef(60, 0, 0, 1);

        gl.glRotatef(rotateX, 1, 0, 0);
        gl.glRotatef(rotateY, 0, 1, 0);
        gl.glRotatef(rotateZ, 0, 0, 1);

        gl.glColor3f(1, 1, 1);
//        for (ModelObject modelObject : modelService.getListModelObjects()) {
//            drawModelObject(gl, modelObject);
//        }
    }

    private void drawLab3(GL2 gl) {
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-10, 10, -10, 10, -10, 10);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glRotatef(-90 + 15, 1, 0, 0);
        gl.glRotatef(0, 0, 1, 0);
        gl.glRotatef(60, 0, 0, 1);

        gl.glRotatef(rotateX, 1, 0, 0);
        gl.glRotatef(rotateY, 0, 1, 0);
        gl.glRotatef(rotateZ, 0, 0, 1);

        gl.glColor3f(1, 1, 1);
//        for (ModelObject modelObject : modelService.getListModelObjects()) {
//            drawModelObject(gl, modelObject);
//        }
    }

    private void drawLaba1(GL2 gl) {
        drawStaticCube(gl);

        draw2Cube(gl);
    }

    private void draw2Cube(GL2 gl) {
        gl.glMatrixMode(GL2.GL_PROJECTION);  // Set up the projection.
        gl.glLoadIdentity();
        double[] mx = {
                1.0, 0.0, 0.0, 0.0,
                0.0, 1.0, 0.0, 0.0,
                Math.cos(Math.PI / 6.0), Math.sin(Math.PI / 6.0), 1.0, 0.0,
                0.0, 0.0, 0.0, 1.0
        };
        gl.glMultMatrixd(DoubleBuffer.wrap(mx));
        gl.glMatrixMode(GL2.GL_MODELVIEW);

        gl.glLoadIdentity();
        gl.glRotatef(rotateZ++, 0, 0, 1);
        gl.glRotatef(rotateY++, 0, 1, 0);
        gl.glRotatef(rotateX++, 1, 0, 0);

        gl.glColor3f(1, 0, 1);

        drawModelObject(gl, new Cube(0.5f, 0, 0, 0.3f));
    }

    private void drawStaticCube(GL2 gl) {
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-1, 1, -1, 1, -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glRotatef(45, 1, 0, 0);
        gl.glRotatef(60, 0, 1, 0);
        gl.glRotatef(0, 0, 0, 1);

        gl.glColor3f(1, 1, 1);
        drawModelObject(gl, new Cube(-0.5f, 0, 0, 0.3f));
    }

}
