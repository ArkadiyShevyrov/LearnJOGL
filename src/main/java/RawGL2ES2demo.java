import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import lombok.Getter;
import lombok.Setter;
import model.ModelObject;
import model.primitive.Cube;
import utils.DrawObject;
import java.nio.DoubleBuffer;
import static java.lang.Math.*;

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
        drawLab2(gl);
    }

    private void drawLab2(GL2 gl) {
        drawStaticCube(gl);
        draw2Cube(gl);
    }

    private void draw2Cube(GL2 gl) {
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        double[] mx = {
                1.0, 0.0, 0.0, 0.0,
                0.0, 1.0, 0.0, 0.0,
                cos(Math.PI / 6.0), sin(Math.PI / 6.0), 1.0, 0.0,
                0.0, 0.0, 0.0, 1.0,
        };
        gl.glMultMatrixd(DoubleBuffer.wrap(mx));
        gl.glMatrixMode(GL2.GL_MODELVIEW);

        gl.glLoadIdentity();
        rotate(gl, -90, 0, 60);
        rotate(gl, rotateX, rotateY, rotateZ);

        gl.glColor3f(1, 0, 1);
        drawModelObject(gl, service.list.get(0));
    }

    private void drawStaticCube(GL2 gl) {
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        orthogonal(gl, -10, 10, -10, 10, -10, 10);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

        rotate(gl, 45, 60,0);

        gl.glColor3f(1, 1, 1);
        drawModelObject(gl, new Cube(-10f, 0, 0, 3f));
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    private void rotate(GL2 gl, float rotateX, float rotateY, float rotateZ) {
        double[] rz = {
                cos(rotateZ*PI/180), sin(rotateZ*PI/180), 0.0, 0.0,
                -sin(rotateZ*PI/180), cos(rotateZ*PI/180), 0.0, 0.0,
                0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 0.0, 1.0
        };
        double[] ry = {
                cos(rotateY*PI/180), 0.0, -sin(rotateY*PI/180), 0.0,
                0.0, 1.0, 0.0, 0.0,
                sin(rotateY*PI/180), 0.0, cos(rotateY*PI/180), 0.0,
                0.0, 0.0, 0.0, 1.0
        };
        double[] rx = {
                1.0, 0.0, 0.0, 0.0,
                0.0, cos(rotateX*PI/180), sin(rotateX*PI/180), 0.0,
                0.0, -sin(rotateX*PI/180), cos(rotateX*PI/180), 0.0,
                0.0, 0.0, 0.0, 1.0
        };
        gl.glMultMatrixd(DoubleBuffer.wrap(rx));
        gl.glMultMatrixd(DoubleBuffer.wrap(ry));
        gl.glMultMatrixd(DoubleBuffer.wrap(rz));
    }

    private void orthogonal(GL2 gl,
                            float left, float bottom, float near,
                            float right, float top, float far) {
        float tx = - (right+left)/(right-left);
        float ty = - (top+bottom)/(top-bottom);
        float tz = - (far + near)/(far - near);
        double[] mx = {
                2/(right-left), 0.0, 0.0, tx,
                0.0, 2/(top-bottom), 0.0, ty,
                0.0, 0.0, 2/(far-near), tz,
                0.0, 0.0, 0.0, 1.0,
        };
        gl.glMultMatrixd(DoubleBuffer.wrap(mx));
    }
}