package ru.mos.bmstu.jogl.view.viewcontrol.menu;

import com.jogamp.nativewindow.util.Rectangle;
import com.jogamp.opengl.GL2;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.mos.bmstu.jogl.model.service.StableService;
import ru.mos.bmstu.jogl.view.viewcontrol.menu.icon.models.ModelIcon;
import ru.mos.bmstu.jogl.view.viewcontrol.utils.DrawObject;
import ru.mos.bmstu.jogl.view.viewcontrol.utils.MenuUtils;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class MenuTools extends Menu {

    private List<ModelIcon> icons;
    @NonNull
    private StableService stableService;

    public void initIcons() {
        icons = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < StableService.StableEnum.values().length; i++) {
            ModelIcon modelIcon = new ModelIcon();
            modelIcon.setBorder(new Rectangle(10 + 100 * index++, 10, 80, 80));
            modelIcon.setIndex(i);
            icons.add(modelIcon);
        }

//        ModelIcon createBorder = new ModelIcon();
//        createBorder.setBorder(new Rectangle(10 + 100 * index++, 10, 80, 80));
//        createBorder.setIndex(0);
//        icons.add(createBorder);
//        ModelIcon modelIcon = new ModelIcon();
//        modelIcon.setBorder(new Rectangle(10 + 100 * index++, 10, 80, 80));
//        modelIcon.setIndex(1);
//        icons.add(modelIcon);
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
        }
    }


    @Override
    public void clicked(int x, int y) {
        for (ModelIcon icon : icons) {
            if (MenuUtils.inRectangle(x, y, icon.getBorder())) {
                System.out.println(icon.getIndex());
                if (icon.getIndex() == 0) {
                    stableService.clearAll();
                }
            }
        }
    }
}
