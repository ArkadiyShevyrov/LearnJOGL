import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.fixedfunc.GLMatrixFunc;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.DoubleBuffer;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class RawGL2ES2demo implements GLEventListener {
    private float rotateX, rotateY, rotateZ;

    private void drawCube(GL2 gl, float size) {

        gl.glBegin(GL2.GL_LINES);

        // a
        gl.glVertex3f(0f, 0f, 0f);
        gl.glVertex3f(size, 0f, 0f);

        // b
        gl.glVertex3f(0f, 0f, 0f);
        gl.glVertex3f(0f, size, 0f);

        // c
        gl.glVertex3f(0f, size, 0f);
        gl.glVertex3f(size, size, 0f);

        // d
        gl.glVertex3f(size, size, 0f);
        gl.glVertex3f(size, 0f, 0f);

        // e
        gl.glVertex3f(0f, 0f, 0f);
        gl.glVertex3f(0f, 0f, size);

        // g
        gl.glVertex3f(0f, size, 0f);
        gl.glVertex3f(0f, size, size);

        // h
        gl.glVertex3f(size, size, 0f);
        gl.glVertex3f(size, size, size);

        // i
        gl.glVertex3f(size, 0f, 0f);
        gl.glVertex3f(size, 0f, size);

        // j
        gl.glVertex3f(0f, 0f, size);
        gl.glVertex3f(0f, size, size);

        // k
        gl.glVertex3f(0f, size, size);
        gl.glVertex3f(size, size, size);

        gl.glVertex3f(size, size, size);
        gl.glVertex3f(size, 0f, size);

        gl.glVertex3f(size, 0f, size);
        gl.glVertex3f(0f, 0f, size);

        gl.glEnd();
    }
    @Override
    public void init(GLAutoDrawable drawable) {
        // called when the panel is created
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0.8F, 0.8F, 0.8F, 1.0F);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);
        gl.glEnable(GL2.GL_COLOR_MATERIAL);
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClearColor(0,0,0,0);
        gl.glClear( GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT );

        gl.glMatrixMode(GL2.GL_PROJECTION);  // Set up the projection.
        gl.glLoadIdentity();
        gl.glOrtho(-1,1,-1,1,-2,2);
        gl.glMatrixMode(GL2.GL_MODELVIEW);

        gl.glLoadIdentity();             // Set up modelview transform.
        gl.glRotatef(rotateZ++,0,0,1);
        gl.glRotatef(rotateY++,0,1,0);
        gl.glRotatef(rotateX++,1,0,0);



        gl.glColor3f(1, 1, 1);

        gl.glEnable(GL2.GL_DEPTH_TEST);


        //////////////////
        gl.glCullFace(GL2.GL_FRONT);
        this.drawCube(gl, 0.7f);


        /////////////////
        gl.glCullFace(GL2.GL_BACK);

        gl.glPushAttrib(GL2.GL_ENABLE_BIT);
        gl.glLineStipple(1, (short)0xAAAA);
        gl.glEnable(GL2.GL_LINE_STIPPLE);

        this.drawCube(gl, 0.7f);

        gl.glDisable(GL2.GL_LINE_STIPPLE);
        gl.glPopAttrib();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}