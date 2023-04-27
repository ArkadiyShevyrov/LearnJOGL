package ru.mos.bmstu.jogl.view.viewcontrol.service;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.util.FPSAnimator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.view.viewcontrol.listner.JOGLKeyListener;
import ru.mos.bmstu.jogl.view.viewcontrol.listner.JOGLMouseListener;
import ru.mos.bmstu.jogl.view.viewcontrol.listner.JOGLWindowListener;
import java.awt.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class InitService {
    @NonNull
    private DrawService glEventListener;
    @NonNull
    private JOGLMouseListener mouseListener;
    @NonNull
    private JOGLKeyListener keyListener;
    @NonNull
    private JOGLWindowListener windowListener;

    @NonNull
    private Window window;

    public void start() {
        GLWindow glWindow = getGlWindow();
        FPSAnimator animator = new FPSAnimator(60, true);
        animator.add(glWindow);
        animator.start();
    }

    private GLWindow getGlWindow() {
        window.init();
        GLWindow glWindow = window.getGlWindow();
        glWindow.setTitle("Raw GL2ES2 Demo");
        glWindow.setSize(500, 500);
//        glWindow.setUndecorated(false);
        glWindow.setPointerVisible(true);
        glWindow.setVisible(true);
        glWindow.display();
        glWindow.addGLEventListener(glEventListener);
        glWindow.addMouseListener(mouseListener);
        glWindow.addKeyListener(keyListener);
        glWindow.addWindowListener(windowListener);
        return glWindow;
    }
}
