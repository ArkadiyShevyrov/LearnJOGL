package ru.mos.bmstu.jogl.view.viewcontrol.utils;

import com.jogamp.nativewindow.util.Rectangle;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MenuUtils {
    public boolean inRectangle(int x, int y, Rectangle rectangle) {
        return x >= rectangle.getX() &&
                x <= rectangle.getX() + rectangle.getWidth() &&
                y >= rectangle.getY() &&
                y <= rectangle.getY() + rectangle.getHeight();
    }
}
