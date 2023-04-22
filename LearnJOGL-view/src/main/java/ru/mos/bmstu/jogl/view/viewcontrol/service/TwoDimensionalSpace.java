package ru.mos.bmstu.jogl.view.viewcontrol.service;

import com.jogamp.opengl.GL2;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.Coordinate;

@Slf4j

@Service
@RequiredArgsConstructor
public class TwoDimensionalSpace {
    @NonNull
    private final CoordinationService coordinationService;

    public void draw(GL2 gl) {
        gl.glViewport(0,0, 1000, 1000);

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        float scale = coordinationService.getScale();
        Coordinate centerCoordinate = coordinationService.getCenterCoordinate();
        gl.glOrtho(-scale, scale, -scale, scale, -scale, scale);
        gl.glTranslatef(-scale,
                -scale,
                -scale);
        gl.glTranslatef(scale*centerCoordinate.getX(),
                scale*centerCoordinate.getY(),
                scale*centerCoordinate.getZ());
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        drawGrid(gl);
    }

    private void drawGrid(GL2 gl) {
        float scale = coordinationService.getScale();
        for (float i = -scale; i < scale; i += scale/10) {
            gl.glColor3f(0, 1, 1);
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex3f(-scale, i, 0);
            gl.glVertex3f(scale, i, 0);
            gl.glEnd();
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex3f(i, -scale, 0);
            gl.glVertex3f(i, scale, 0);
            gl.glEnd();
        }
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
