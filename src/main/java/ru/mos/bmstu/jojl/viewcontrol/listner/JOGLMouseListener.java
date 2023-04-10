package ru.mos.bmstu.jojl.viewcontrol.listner;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jojl.model.model.ModelObject;
import ru.mos.bmstu.jojl.model.model.primitive.TruncatedPyramid;
import ru.mos.bmstu.jojl.model.service.ModelService;

@Slf4j
@RequiredArgsConstructor
@Service
public class JOGLMouseListener implements MouseListener {
    @NonNull
    private final ModelService modelService;

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        for (ModelObject modelObject : modelService.getListModelObjects()) {
            if (modelObject instanceof TruncatedPyramid pyramid) {
                modelObject = new TruncatedPyramid(0, 0, 0, pyramid.getEdgeLength() + 1);
                modelService.set(0, modelObject);
            }
        }
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
