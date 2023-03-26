import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import model.Coordinate;
import model.Cube;
import model.Edge;
import model.Polygon;
import java.nio.DoubleBuffer;
import java.util.List;

public class RawGL2ES2demo implements GLEventListener {
    private float rotateX, rotateY, rotateZ;

    private void drawCube(GL2 gl, Cube cube) {
        if (cube.getPolygons() != null &&
                cube.getPolygons().size() > 0 &&
                cube.getPolygons().get(0).getVertexes().size() == 4) {
            gl.glColor3f(0, 0.4f, 0.4f);
            gl.glBegin(GL2.GL_QUADS);
            for (Polygon polygon : cube.getPolygons()) {
                List<Coordinate> vertexes = polygon.getVertexes();
                for (Coordinate coordinate : vertexes) {
                    gl.glVertex3f(coordinate.getX(), coordinate.getY(), coordinate.getZ());
                }
            }
            gl.glEnd();
        }

        gl.glColor3f(1, 1, 1);
        gl.glBegin(GL2.GL_LINES);
        for (Edge edge : cube.getEdges()) {
            Coordinate startCord = edge.getStartCord();
            Coordinate endCord = edge.getEndCord();
            gl.glVertex3f(startCord.getX(), startCord.getY(), startCord.getZ());
            gl.glVertex3f(endCord.getX(), endCord.getY(), endCord.getZ());
        }
        gl.glEnd();
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

        drawCube(gl, new Cube(0.5f, 0, 0, 0.3f));
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
        drawCube(gl, new Cube(-0.5f, 0, 0, 0.3f));
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}