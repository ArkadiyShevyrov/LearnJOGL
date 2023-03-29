import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import model.ModelObject;
import model.primitive.TruncatedPyramid;

public class MyKey implements KeyListener {
    private final RawGL2ES2demo glEventListener;
    private final Service service;

    public MyKey(RawGL2ES2demo glEventListener, Service service) {
        this.glEventListener = glEventListener;
        this.service = service;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_1 -> {
                for (ModelObject modelObject : service.list) {
                    if (modelObject instanceof TruncatedPyramid pyramid) {
                        pyramid.setEdgeLength(pyramid.getEdgeLength() + 0.1f);
                        service.list.set(0, modelObject);
                    }
                }
            }
            case KeyEvent.VK_2 -> {
                for (ModelObject modelObject : service.list) {
                    if (modelObject instanceof TruncatedPyramid pyramid) {
                        pyramid.setEdgeLength(pyramid.getEdgeLength() - 0.1f);
                        service.list.set(0, modelObject);
                    }
                }
            }
            case KeyEvent.VK_3 -> {
                for (ModelObject modelObject : service.list) {
                    if (modelObject instanceof TruncatedPyramid pyramid) {
                        pyramid.setOffsetOxy(pyramid.getOffsetOxy() +0.1f);
                        service.list.set(0, pyramid);
                    }
                }
            }
            case KeyEvent.VK_4 -> {
                for (ModelObject modelObject : service.list) {
                    if (modelObject instanceof TruncatedPyramid pyramid) {
                        pyramid.setOffsetOxy(pyramid.getOffsetOxy()-0.1f);
                        service.list.set(0, pyramid);
                    }
                }
            }
            case KeyEvent.VK_5 -> {
                glEventListener.setPolygon(!glEventListener.isPolygon());
            }
            case KeyEvent.VK_A -> {
                glEventListener.setRotateZ(glEventListener.getRotateZ()+1);
            }
            case KeyEvent.VK_D -> {
                glEventListener.setRotateZ(glEventListener.getRotateZ()-1);
            }
            case KeyEvent.VK_W -> {
                glEventListener.setRotateX(glEventListener.getRotateX()+1);
                glEventListener.setRotateY(glEventListener.getRotateY()+1);
            }
            case KeyEvent.VK_S -> {
                glEventListener.setRotateX(glEventListener.getRotateX()-1);
                glEventListener.setRotateY(glEventListener.getRotateY()-1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
