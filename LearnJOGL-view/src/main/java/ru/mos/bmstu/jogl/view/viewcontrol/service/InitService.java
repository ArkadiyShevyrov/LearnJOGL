package ru.mos.bmstu.jogl.view.viewcontrol.service;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.view.viewcontrol.listner.JOGLKeyListener;
import ru.mos.bmstu.jogl.view.viewcontrol.listner.JOGLMouseListener;

@Slf4j
@RequiredArgsConstructor
@Service
public class InitService {
    @NonNull
    private RawGL2ES2demo glEventListener;
    @NonNull
    private JOGLMouseListener mouseListener;
    @NonNull
    private JOGLKeyListener keyListener;

    public void start() {
        GLCapabilities caps = new GLCapabilities(GLProfile.get(GLProfile.GL2));
        caps.setBackgroundOpaque(true);
        GLWindow glWindow = getGlWindow(caps);
        FPSAnimator animator = new FPSAnimator(60, true);
        animator.add(glWindow);
        animator.start();
    }

    private GLWindow getGlWindow(GLCapabilities caps) {
        GLWindow glWindow = GLWindow.create(caps);
        glWindow.setTitle("Raw GL2ES2 Demo");
        glWindow.setSize(500, 500);
        glWindow.setUndecorated(false);
        glWindow.setPointerVisible(true);
        glWindow.setVisible(true);
        glWindow.addGLEventListener(glEventListener);
        glWindow.addMouseListener(mouseListener);
        glWindow.addKeyListener(keyListener);
        glWindow.display();
        return glWindow;
    }
}
