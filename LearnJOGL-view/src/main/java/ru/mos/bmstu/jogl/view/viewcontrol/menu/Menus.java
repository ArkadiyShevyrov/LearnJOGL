package ru.mos.bmstu.jogl.view.viewcontrol.menu;

import com.jogamp.nativewindow.util.Rectangle;
import com.jogamp.opengl.GL2;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.service.ModelService;
import ru.mos.bmstu.jogl.model.service.StableService;
import ru.mos.bmstu.jogl.view.viewcontrol.service.Window;
import ru.mos.bmstu.jogl.view.viewcontrol.utils.DrawObject;
import ru.mos.bmstu.jogl.view.viewcontrol.utils.MenuUtils;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class Menus {
    @NonNull
    private Window window;
    @NonNull
    private ModelService modelService;
    @NonNull
    private StableService stableService;
    private List<Menu> menus;


    public void init() {
        MenuTools menuTools = new MenuTools();
        MenuWorld menuWorld = new MenuWorld(stableService);
        MenuModels menuModels = new MenuModels(modelService);
        menus = new ArrayList<>();
        int border = 10;
        menuTools.init(border, window.getHeight() - border - 100, window.getWidth() - 2 * border, 100);
        menuModels.init(border, border, 200, window.getHeight() - border - 100 - 2 * border);
        menuWorld.init(border + 200 + border, border, window.getWidth() - 200 - 20 - border, window.getHeight() - border - 100 - 20);
        menuModels.initIcons();
        menuTools.initIcons();
        menus.add(menuTools);
        menus.add(menuModels);
        menus.add(menuWorld);
    }

    public void draw(GL2 gl) {
        for (Menu menu : menus) {
            drawMenu(gl, menu);
        }
    }

    private void drawMenu(GL2 gl, Menu menu) {
        Rectangle border = menu.getBorder();
        gl.glViewport(border.getX(), border.getY(), border.getWidth(), border.getHeight());
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-border.getWidth(), border.getWidth(),
                -border.getHeight(), border.getHeight(),
                -border.getWidth(), border.getWidth());
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glColor3f(1, 0, 0);
        DrawObject.drawBorder(gl, border);
        if (menu instanceof MenuWorld menuWorld) {
            menuWorld.draw(gl);
        } else if (menu instanceof MenuModels menuModels) {
            menuModels.draw(gl);
        } else if (menu instanceof MenuTools menuTools) {
            menuTools.draw(gl);
        }
    }

    public Menu getMenuInCord(int x, int y) {
        for (Menu menu : menus) {
            Rectangle border = menu.getBorder();
            if (MenuUtils.inRectangle(x, y, border)) {
                return menu;
            }
        }
        return null;
    }

}
