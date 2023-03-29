import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.opengl.Threading;
import model.ModelObject;
import model.primitive.Cube;
import model.primitive.TruncatedPyramid;
import java.util.Random;

public class MyMouse implements MouseListener {

    private final Service service;

    public MyMouse(Service service) {
        this.service = service;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        for (ModelObject modelObject : service.list) {
            if (modelObject instanceof TruncatedPyramid pyramid) {

                modelObject =new TruncatedPyramid(0,0,0, pyramid.getEdgeLength() + 1);
                service.list.set(0, modelObject);
            }
        }
//        service.list.add(new Cube(mouseEvent.getX()/ 50f, mouseEvent.getY()/ 50f, new Random().nextFloat()*2, 5f));
//        System.out.println(mouseEvent.getX() + " " + mouseEvent.getY());
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseWheelMoved(MouseEvent mouseEvent) {

    }
}
