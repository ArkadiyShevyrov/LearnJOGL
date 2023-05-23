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
        for (Enum stableEnum : StableService.StableEnum.values()) {
            ModelIcon modelIcon = new ModelIcon();
            modelIcon.setBorder(new Rectangle(10 + 100 * index++, 10, 80, 80));
            modelIcon.setType(stableEnum);
            icons.add(modelIcon);
        }
        for (Enum subEnum : stableService.getCurrentSubEnums()) {
            ModelIcon modelIcon = new ModelIcon();
            modelIcon.setBorder(new Rectangle(10 + 100 * index++, 10, 80, 80));
            modelIcon.setType(subEnum);
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

            if (icon.getType() instanceof StableService.StableEnum) {
                gl.glColor3f(1, 1, 0);
            } else {
                gl.glColor3f(1, 0.5f, 0);
            }
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
                Enum type = icon.getType();
                System.out.println(type);
                if (type instanceof StableService.StableEnum stableEnum) {
                    stableService.setStableEnum(stableEnum);
                } else {
                    stableService.setSubEnum(type);
                }
            }
        }
        initIcons();
    }
}
