package ru.mos.bmstu.jogl.view.viewcontrol.menu.icon.models;

import com.jogamp.nativewindow.util.Rectangle;
import lombok.Getter;
import lombok.Setter;
import ru.mos.bmstu.jogl.model.model.ModelObject;

@Getter
@Setter
public class ModelIcon {
    private Rectangle border = new Rectangle();
    private ModelObject modelObject;
    private boolean current;
    private int index;
    private Enum type;
}
