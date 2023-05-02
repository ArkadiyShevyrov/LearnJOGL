package ru.mos.bmstu.jogl.view.viewcontrol.listner;

import com.jogamp.nativewindow.util.Rectangle;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.Coordinate;
import ru.mos.bmstu.jogl.model.service.ModelService;
import ru.mos.bmstu.jogl.view.viewcontrol.arhiv.CoordinationService;
import ru.mos.bmstu.jogl.view.viewcontrol.menu.Menu;
import ru.mos.bmstu.jogl.view.viewcontrol.menu.Menus;

@Slf4j
@Service
@RequiredArgsConstructor
public class JOGLMouseListener implements MouseListener {
    @NonNull
    private final ModelService modelService;
    @NonNull
    private final CoordinationService coordinationService;
    @NonNull
    private final Menus menus;

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Coordinate coordinate = coordinationService.sayTouch(mouseEvent.getX(), mouseEvent.getY());
        Menu menuInCord = menus.getMenuInCord((int) coordinate.getX(), (int) coordinate.getY());
        if (menuInCord != null) {
            Rectangle border = menuInCord.getBorder();
            menuInCord.clicked((int) (coordinate.getX() - border.getX()), (int) (coordinate.getY() - border.getY()));
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
