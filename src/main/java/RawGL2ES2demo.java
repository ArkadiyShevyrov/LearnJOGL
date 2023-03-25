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
    public static DisplayMode dm, dm_old;
    private GLU glu = new GLU();
    private float xrot, yrot, zrot;
    private int texture;

    @Override
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();

        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glClearColor(0f, 0f, 0f, 0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glDepthFunc(GL2.GL_LEQUAL);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

        gl.glEnable(GL2.GL_TEXTURE_2D);
        try {

            File im = new File("D:\\mad.jpg ");
            Texture t = TextureIO.newTexture(im, true);
            texture = t.getTextureObject(gl);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity(); // Reset The View
        gl.glTranslatef(0f, 0f, -5.0f);

        gl.glRotatef(xrot, 1.0f, 1.0f, 1.0f);
        gl.glRotatef(yrot * 4, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(zrot * 16, 0.0f, 0.0f, 1.0f);
//        rotate(gl, zrot * 16, 0.0f, 0.0f, 1.0f);



        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture);
        gl.glBegin(GL2.GL_QUADS);

        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);

        // Back Face
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);

        // Top Face
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);

        // Bottom Face
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);

        // Right face
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);

        // Left Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);

        gl.glEnd();
        gl.glFlush();

        //change the speeds here
        xrot += .1f;
        yrot += .1f;
        zrot += .1f;
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        if (height <= 0)
            height = 1;

        gl.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
        gl.glPushMatrix();
        double[] mx = {1.0, 0.0, 0.0, 0.0,
                0.0, 1.0, 0.0, 0.0,
                -cos(3.14 / 6.0), -sin(3.14 / 6.0), 1.0, 0.0,
                0.0, 0.0, 0.0, 1.0};
        gl.glMultMatrixd(DoubleBuffer.wrap(mx));
        gl.glPopMatrix();

        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }


    public void rotate(GL2 gl, float phi, float v, float v1, float v2) {

        double[] Roz = new double[]{
                cos(phi), sin(phi), 0, 0,
                -sin(phi), cos(phi), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        };
        double[] Roy = new double[]{
                cos(phi), 0, sin(phi), 0,
                0, 1, 0, 0,
                -sin(phi), 0, cos(phi), 0,
                0, 0, 0, 1
        };
        double[] Rox = new double[]{
                1, 0, 0, 0,
                0, cos(phi), -sin(phi), 0,
                0, sin(phi), cos(phi), 0,
                0, 0, 0, 1
        };
        if (v != 0) {
            gl.glMultMatrixd(DoubleBuffer.wrap(Rox));
        }
        if (v1 != 0) {
            gl.glMultMatrixd(DoubleBuffer.wrap(Roy));
        }
        if (v2 != 0) {
            gl.glMultMatrixd(DoubleBuffer.wrap(Roz));
        }
    }

}