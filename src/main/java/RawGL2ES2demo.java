import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import lombok.Getter;
import lombok.Setter;
import model.ModelObject;
import model.primitive.Cube;
import utils.DrawObject;
import java.nio.DoubleBuffer;

@Getter
@Setter
public class RawGL2ES2demo implements GLEventListener {
    Service service;
    private float rotateX, rotateY, rotateZ;
    private boolean isPolygon;

    public RawGL2ES2demo(Service service) {
        this.service = service;
    }

    private void drawModelObject(GL2 gl, ModelObject modelObject) {
        if (isPolygon) {
            gl.glColor3f(1, 0, 1);
            DrawObject.drawPolygon(gl, modelObject);
        }

        gl.glColor3f(1, 1, 1);
        DrawObject.drawEdges(gl, modelObject);
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0.8F, 0.8F, 0.8F, 1.0F);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glDepthFunc(GL2.GL_LEQUAL);
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 0);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
//        drawLaba2(gl);
        drawLab3(gl);
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
        for (ModelObject modelObject : service.list) {
            drawModelObject(gl, modelObject);
        }
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

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}