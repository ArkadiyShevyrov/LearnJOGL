package ru.mos.bmstu.jogl.view.viewcontrol.menu.icon;

import com.jogamp.nativewindow.util.Rectangle;
import com.jogamp.opengl.GL2;
import lombok.Getter;
import lombok.Setter;
import ru.mos.bmstu.jogl.model.model.ModelObject;

@Getter
@Setter
public class ModelIcon {
    private Rectangle border = new Rectangle();
    private ModelObject modelObject;

    public void draw(GL2 gl) {

    }
}
