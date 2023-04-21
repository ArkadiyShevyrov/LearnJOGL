package ru.mos.bmstu.jogl.view.viewcontrol.service;

import com.jogamp.opengl.GL2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TwoDimensionalSpace {
    private float scale = 10;
    public void draw(GL2 gl) {
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-scale, scale, -scale, scale, -scale, scale);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        drawGrid(gl);
    }

    private void drawGrid(GL2 gl) {
//        for (float i = -scale; i < scale; i += scale/10) {
//            gl.glColor3f(0, 1, 1);
//            gl.glBegin(GL2.GL_LINES);
//            gl.glVertex3f(-scale, i, 0);
//            gl.glVertex3f(scale, i, 0);
//            gl.glEnd();
//            gl.glBegin(GL2.GL_LINES);
//            gl.glVertex3f(i, -scale, 0);
//            gl.glVertex3f(i, scale, 0);
//            gl.glEnd();
//        }
        gl.glColor3f(0, 1, 0);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(0, -scale, 0);
        gl.glVertex3f(0, scale, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-scale, 0, 0);
        gl.glVertex3f(scale, 0, 0);
        gl.glEnd();
    }
}
