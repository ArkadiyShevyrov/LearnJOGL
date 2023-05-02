package ru.mos.bmstu.jogl.view.viewcontrol.listner;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.service.ModelService;

@Slf4j
@Service
@RequiredArgsConstructor
public class JOGLKeyListener implements KeyListener {
//    @NonNull
//    private final MenuWorld menuWorld;
    @NonNull
    private final ModelService modelService;

    @Override
    public void keyPressed(KeyEvent keyEvent) {
//        switch (keyEvent.getKeyCode()) {
//            case KeyEvent.VK_1 -> {
//                menuWorld.updSize(1.1f);
//            }
//            case KeyEvent.VK_2 -> {
//                menuWorld.updSize(0.9f);
//            }
//            case KeyEvent.VK_3 -> {
//                for (ModelObject modelObject : modelService.getListModelObjects()) {
//                    if (modelObject instanceof TruncatedPyramid pyramid) {
//                        pyramid.setOffsetOxy(pyramid.getOffsetOxy() + 0.1f);
//                        modelService.set(0, pyramid);
//                    }
//                }
//            }
//            case KeyEvent.VK_4 -> {
//                for (ModelObject modelObject : modelService.getListModelObjects()) {
//                    if (modelObject instanceof TruncatedPyramid pyramid) {
//                        pyramid.setOffsetOxy(pyramid.getOffsetOxy() - 0.1f);
//                        modelService.set(0, pyramid);
//                        log.warn(String.valueOf(pyramid.getOffsetOxy()));
//                    }
//                }
//            }
//            case KeyEvent.VK_5 -> {
//                glEventListener.setPolygon(!glEventListener.isPolygon());
//            }
//            case KeyEvent.VK_A -> {
//                menuWorld.updCenterCoordinate(new Coordinate(-10,0,0));
//            }
//            case KeyEvent.VK_D -> {
//                menuWorld.updCenterCoordinate(new Coordinate(10,0,0));
//            }
//            case KeyEvent.VK_W -> {
//                menuWorld.updCenterCoordinate(new Coordinate(0,10,0));
//            }
//            case KeyEvent.VK_S -> {
//                menuWorld.updCenterCoordinate(new Coordinate(0,-10,0));
//            }
//        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
