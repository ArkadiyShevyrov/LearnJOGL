package ru.mos.bmstu.jogl.view.viewcontrol.listner;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.service.ModelService;
import ru.mos.bmstu.jogl.view.viewcontrol.service.CoordinationService;

@Slf4j
@RequiredArgsConstructor
@Service
public class JOGLMouseListener implements MouseListener {
    @NonNull
    private final ModelService modelService;
    @NonNull
    private final CoordinationService coordinationService;

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        coordinationService.sayTouch(mouseEvent.getX(), mouseEvent.getY());
//        System.out.println((mouseEvent.getX() - 250)/25 + " " + -1*(mouseEvent.getY() - 250)/25);
//        for (ModelObject modelObject : modelService.getListModelObjects()) {
//            if (modelObject instanceof TruncatedPyramid pyramid) {
//                modelObject = new TruncatedPyramid(0, 0, 0, pyramid.getEdgeLength() + 1);
//                modelService.set(0, modelObject);
//            }
//        }
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
