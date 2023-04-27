package ru.mos.bmstu.jogl.view.viewcontrol.service;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Window {
    @Getter
    private GLWindow glWindow;

    public void init() {
        GLCapabilities caps = new GLCapabilities(GLProfile.get(GLProfile.GL2));
        caps.setBackgroundOpaque(true);
        glWindow = GLWindow.create(caps);
    }

    public int getWidth() {
        return glWindow.getWidth();
    }

    public int getHeight() {
        return glWindow.getHeight();
    }
}
