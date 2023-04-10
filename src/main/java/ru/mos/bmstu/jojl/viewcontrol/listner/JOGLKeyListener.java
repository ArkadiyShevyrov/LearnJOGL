package ru.mos.bmstu.jojl.viewcontrol.listner;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jojl.model.model.ModelObject;
import ru.mos.bmstu.jojl.model.model.primitive.TruncatedPyramid;
import ru.mos.bmstu.jojl.model.service.ModelService;
import ru.mos.bmstu.jojl.viewcontrol.service.RawGL2ES2demo;

@Slf4j
@RequiredArgsConstructor
@Service
public class JOGLKeyListener implements KeyListener {
    @NonNull
    private final RawGL2ES2demo glEventListener;
    @NonNull
    private final ModelService modelService;

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_1 -> {
                for (ModelObject modelObject : modelService.getListModelObjects()) {
                    if (modelObject instanceof TruncatedPyramid pyramid) {
                        pyramid.setEdgeLength(pyramid.getEdgeLength() + 0.1f);
                        modelService.set(0, modelObject);
                    }
                }
            }
            case KeyEvent.VK_2 -> {
                for (ModelObject modelObject : modelService.getListModelObjects()) {
                    if (modelObject instanceof TruncatedPyramid pyramid) {
                        pyramid.setEdgeLength(pyramid.getEdgeLength() - 0.1f);
                        modelService.set(0, modelObject);
                    }
                }
            }
            case KeyEvent.VK_3 -> {
                for (ModelObject modelObject : modelService.getListModelObjects()) {
                    if (modelObject instanceof TruncatedPyramid pyramid) {
                        pyramid.setOffsetOxy(pyramid.getOffsetOxy() + 0.1f);
                        modelService.set(0, pyramid);
                    }
                }
            }
            case KeyEvent.VK_4 -> {
                for (ModelObject modelObject : modelService.getListModelObjects()) {
                    if (modelObject instanceof TruncatedPyramid pyramid) {
                        pyramid.setOffsetOxy(pyramid.getOffsetOxy() - 0.1f);
                        modelService.set(0, pyramid);
                    }
                }
            }
            case KeyEvent.VK_5 -> {
                glEventListener.setPolygon(!glEventListener.isPolygon());
            }
            case KeyEvent.VK_A -> {
                glEventListener.setRotateZ(glEventListener.getRotateZ() + 1);
            }
            case KeyEvent.VK_D -> {
                glEventListener.setRotateZ(glEventListener.getRotateZ() - 1);
            }
            case KeyEvent.VK_W -> {
                glEventListener.setRotateX(glEventListener.getRotateX() + 1);
                glEventListener.setRotateY(glEventListener.getRotateY() + 1);
            }
            case KeyEvent.VK_S -> {
                glEventListener.setRotateX(glEventListener.getRotateX() - 1);
                glEventListener.setRotateY(glEventListener.getRotateY() - 1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
