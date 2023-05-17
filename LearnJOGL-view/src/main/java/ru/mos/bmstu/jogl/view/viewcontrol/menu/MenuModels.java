package ru.mos.bmstu.jogl.view.viewcontrol.menu;

import com.jogamp.nativewindow.util.Rectangle;
import com.jogamp.opengl.GL2;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.mos.bmstu.jogl.model.model.Coordinate3D;
import ru.mos.bmstu.jogl.model.model.ModelObject;
import ru.mos.bmstu.jogl.model.service.ModelService;
import ru.mos.bmstu.jogl.model.utils.ModelObjectUtils;
import ru.mos.bmstu.jogl.view.viewcontrol.menu.icon.models.ModelIcon;
import ru.mos.bmstu.jogl.view.viewcontrol.utils.DrawObject;
import ru.mos.bmstu.jogl.view.viewcontrol.utils.MenuUtils;
import java.util.ArrayList;
import java.util.List;

@Slf4j
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
        for (int i = 0; i < listModelObjects.size(); i++) {
            ModelObject modelObject = listModelObjects.get(i);
            ModelIcon modelIcon = new ModelIcon();
            ModelObject iconModel = new ModelObject(modelObject);
            modelIcon.setModelObject(iconModel);
            modelIcon.setBorder(new Rectangle(50, 50 + 100 * index++, 100, 100));
            modelIcon.getModelObject().setCentralCord(new Coordinate3D(0, 0, 0));
            modelIcon.setIndex(i);
            icons.add(modelIcon);
        }
    }

    public void draw(GL2 gl) {
        for (ModelIcon icon : icons) {
            Rectangle iconBorder = icon.getBorder();
            gl.glViewport(iconBorder.getX() + border.getX(),
                    iconBorder.getY() + border.getY(),
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
            if (icon.isCurrent()) {
                gl.glColor3f(0.3f, 0, 1);
            }
            DrawObject.drawBorder(gl, icon.getBorder());

            gl.glRotatef(-90 + 15, 1, 0, 0);
            gl.glRotatef(0, 0, 1, 0);
            gl.glRotatef(60, 0, 0, 1);

            Coordinate3D maxCord = ModelObjectUtils.getMaxCord(icon.getModelObject());
            float maxNumber = Math.max(Math.max(maxCord.getX(), maxCord.getY()), maxCord.getZ());
            float size = 100 / (maxNumber * 2);
            DrawObject.drawModelObject(gl, icon.getModelObject(), size, true);
        }
    }

    @Override
    public void clicked(int x, int y) {
        for (ModelIcon icon : icons) {
            if (MenuUtils.inRectangle(x, y, icon.getBorder())) {
                for (ModelIcon icon2 : icons) {
                    icon2.setCurrent(false);
                }
                icon.setCurrent(true);
                modelService.setCurrentModelObject(icon.getIndex());
            }
        }
    }
}
