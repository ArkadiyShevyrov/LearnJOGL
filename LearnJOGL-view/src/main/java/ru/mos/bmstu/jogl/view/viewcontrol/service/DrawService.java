package ru.mos.bmstu.jogl.view.viewcontrol.service;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.service.ModelService;
import ru.mos.bmstu.jogl.view.viewcontrol.menu.Menus;

@Slf4j
@Service
@RequiredArgsConstructor
public class DrawService implements GLEventListener {
    @NonNull
    private final ModelService modelService;
    @NonNull
    private final Menus menus;


    @Override
    public void init(GLAutoDrawable drawable) {
//        GL2 gl = drawable.getGL().getGL2();
//        gl.glClearColor(0.8F, 0.8F, 0.8F, 1.0F);
//        gl.glClearDepth(1.0f);
//        gl.glEnable(GL2.GL_DEPTH_TEST);
//        gl.glDepthFunc(GL2.GL_LEQUAL);
        menus.init();
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 0);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        menus.draw(gl);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }


//
//    private void drawObjects(GL2 gl) {
//        Rectangle spaceBorder = new Rectangle(10+200+20, 10, window.getWidth()-200-20-20, window.getHeight()-10-100-20);
//        gl.glViewport(spaceBorder.getX(), spaceBorder.getY(), spaceBorder.getWidth(), spaceBorder.getHeight());
//        gl.glMatrixMode(GL2.GL_PROJECTION);
//        gl.glLoadIdentity();
//        gl.glOrtho(-spaceBorder.getWidth(), spaceBorder.getWidth(),
//                -spaceBorder.getHeight(), spaceBorder.getHeight(),
//                -1, 1);
//        gl.glMatrixMode(GL2.GL_MODELVIEW);
//        gl.glLoadIdentity();
//
//        grawBorder(gl, spaceBorder);
//
//        gl.glColor3f(0, 1, 0);
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f(0, -spaceBorder.getHeight(), 0);
//        gl.glVertex3f(0,  spaceBorder.getHeight(), 0);
//        gl.glEnd();
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex3f(-spaceBorder.getWidth(), 0, 0);
//        gl.glVertex3f(spaceBorder.getWidth(), 0, 0);
//        gl.glEnd();
//
//        dimensionalSpace.draw(gl);
//        ModelObject modelObject = modelService.getListModelObjects().get(0);
//        gl.glColor3f(1, 1, 1);
//        DrawObject.drawEdges(gl, modelObject);
//    }
//
//    private void drawTools(GL2 gl) {
//        gl.glViewport(10, window.getHeight() - 10 - 100, window.getWidth() - 20, 100);
//        gl.glMatrixMode(GL2.GL_PROJECTION);
//        gl.glLoadIdentity();
//        gl.glOrtho(0, window.getWidth() - 20, 0, 100, -1, 1);
//        gl.glMatrixMode(GL2.GL_MODELVIEW);
//        gl.glLoadIdentity();
//        gl.glColor3f(0, 1, 0);
//        gl.glBegin(GL2.GL_QUADS);
//        gl.glVertex2f(0, 0);
//        gl.glVertex2f(window.getWidth() - 20, 0);
//        gl.glVertex2f(window.getWidth() - 20, 100);
//        gl.glVertex2f(0, 100);
//        gl.glColor3f(1,0,0);
//        gl.glBegin(GL2.GL_QUADS);
//        gl.glVertex2f(0, 0);
//        gl.glVertex2f(100, 0);
//        gl.glVertex2f(100, 100);
//        gl.glVertex2f(0, 100);
//        gl.glEnd();
//        gl.glColor3f(1,1,0);
//    }

//    private void draw
}