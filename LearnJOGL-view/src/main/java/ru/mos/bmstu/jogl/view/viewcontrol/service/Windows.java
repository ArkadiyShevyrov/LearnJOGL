package ru.mos.bmstu.jogl.view.viewcontrol.service;

import com.jogamp.newt.opengl.GLWindow;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Windows {
    private GLWindow glWindow;
}
