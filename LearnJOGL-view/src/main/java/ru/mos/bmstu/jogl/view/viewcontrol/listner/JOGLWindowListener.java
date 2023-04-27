package ru.mos.bmstu.jogl.view.viewcontrol.listner;

import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.event.WindowListener;
import com.jogamp.newt.event.WindowUpdateEvent;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.view.viewcontrol.menu.Menus;

@Slf4j
@Service
@RequiredArgsConstructor
public class JOGLWindowListener implements WindowListener {
    @NonNull
    private Menus menus;

    @Override
    public void windowResized(WindowEvent windowEvent) {
        menus.init();
    }

    @Override
    public void windowMoved(WindowEvent windowEvent) {

    }

    @Override
    public void windowDestroyNotify(WindowEvent windowEvent) {

    }

    @Override
    public void windowDestroyed(WindowEvent windowEvent) {

    }

    @Override
    public void windowGainedFocus(WindowEvent windowEvent) {

    }

    @Override
    public void windowLostFocus(WindowEvent windowEvent) {

    }

    @Override
    public void windowRepaint(WindowUpdateEvent windowUpdateEvent) {

    }
}
