package ru.mos.bmstu.jogl.view.viewcontrol.menu;

import com.jogamp.opengl.GL2;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mos.bmstu.jogl.model.model.ModelObject;
import ru.mos.bmstu.jogl.model.model.primitive.Cube;
import ru.mos.bmstu.jogl.model.service.ModelService;
import ru.mos.bmstu.jogl.view.viewcontrol.utils.DrawObject;

@Component
@RequiredArgsConstructor
public class MenuWorld extends Menu {
    @NonNull
    private ModelService modelService;

    public void draw(GL2 gl) {
        gl.glRotatef(-90 + 15, 1, 0, 0);
        gl.glRotatef(0, 0, 1, 0);
        gl.glRotatef(60, 0, 0, 1);

        gl.glColor3f(0, 1, 0);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(0, -border.getHeight(), 0);
        gl.glVertex3f(0, border.getHeight(), 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-border.getWidth(), 0, 0);
        gl.glVertex3f(border.getWidth(), 0, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(0, 0, -100);
        gl.glVertex3f(0, 0, 100);
        gl.glEnd();

        for (ModelObject modelObject : modelService.getListModelObjects()) {
            drawModelObject(gl, modelObject);
        }

    }

    private void drawModelObject(GL2 gl, ModelObject modelObject) {
        if (true) {
            gl.glColor3f(1, 0, 1);
            DrawObject.drawPolygon(gl, modelObject);
        }

        gl.glColor3f(1, 1, 1);
        DrawObject.drawEdges(gl, modelObject);
    }
}
