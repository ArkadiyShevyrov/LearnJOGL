package ru.mos.bmstu.jogl.view.viewcontrol.menu;

import com.jogamp.nativewindow.util.Rectangle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Menu {
    protected Rectangle border = new Rectangle();

    public void init(int x, int y, int weight, int height) {
        border.set(x, y, weight, height);
    }
}
