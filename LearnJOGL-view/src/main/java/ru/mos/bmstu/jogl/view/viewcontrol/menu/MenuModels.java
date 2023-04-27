package ru.mos.bmstu.jogl.view.viewcontrol.menu;

import com.jogamp.nativewindow.util.Rectangle;
import com.jogamp.opengl.GL2;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mos.bmstu.jogl.model.model.Coordinate;
import ru.mos.bmstu.jogl.model.model.ModelObject;
import ru.mos.bmstu.jogl.model.service.ModelService;
import ru.mos.bmstu.jogl.model.utils.ModelObjectUtils;
import ru.mos.bmstu.jogl.view.viewcontrol.menu.icon.ModelIcon;
import ru.mos.bmstu.jogl.view.viewcontrol.utils.DrawObject;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MenuModels extends Menu {
    @NonNull
    private ModelService modelService;
    private List<ModelIcon> icons;

    public void initIcons() {
        icons = new ArrayList<>();
        List<ModelObject> listModelObjects = modelService.getListModelObjects();
        int index = 0;
        for (ModelObject modelObject : listModelObjects) {
            ModelIcon modelIcon = new ModelIcon();
            modelIcon.setModelObject(new ModelObject(modelObject));
            modelIcon.setBorder(new Rectangle(0, 100 * index++, 100, 100));
            modelIcon.getModelObject().setCentralCord(new Coordinate(0, 0, 0));
            icons.add(modelIcon);
        }
    }

    public void draw(GL2 gl) {

//        List<ModelObject> listModelObjects = modelService.getListModelObjects();
//        int index = 0;
//        for (ModelObject modelObject : listModelObjects) {
//            ModelObject modelIcon = new ModelObject(modelObject);
//            modelIcon.setCentralCord(new Coordinate(0,0,index*200));
//
//            drawModelIcon(gl, modelIcon,  index++);
//        }
        for (ModelIcon icon : icons) {
            Rectangle iconBorder = icon.getBorder();
            gl.glViewport(iconBorder.getX() + border.getX() + 50,
                    iconBorder.getY() + border.getY() + 50,
                    iconBorder.getWidth(),
                    iconBorder.getHeight());
            gl.glMatrixMode(GL2.GL_PROJECTION);
            gl.glLoadIdentity();
            gl.glOrtho(-iconBorder.getWidth(), iconBorder.getWidth(),
                    -iconBorder.getHeight(), iconBorder.getHeight(),
                    -iconBorder.getWidth(), iconBorder.getWidth());
            gl.glMatrixMode(GL2.GL_MODELVIEW);
            gl.glLoadIdentity();

            gl.glColor3f(1, 1, 0);
            DrawObject.drawBorder(gl, icon.getBorder());

            gl.glRotatef(-90 + 15, 1, 0, 0);
            gl.glRotatef(0, 0, 1, 0);
            gl.glRotatef(60, 0, 0, 1);

            Coordinate maxCord = ModelObjectUtils.getMaxCord(icon.getModelObject());
            float maxNumber = Math.max(Math.max(maxCord.getX(), maxCord.getY()), maxCord.getZ());
            float size = 100/(maxNumber*2);
            DrawObject.drawModelObject(gl, icon.getModelObject(), size);
        }
    }
}
