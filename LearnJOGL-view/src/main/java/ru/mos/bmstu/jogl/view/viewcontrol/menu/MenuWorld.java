package ru.mos.bmstu.jogl.view.viewcontrol.menu;

import com.jogamp.opengl.GL2;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.mos.bmstu.jogl.model.model.Coordinate3D;
import ru.mos.bmstu.jogl.model.model.ModelObject;
import ru.mos.bmstu.jogl.model.service.ModelService;
import ru.mos.bmstu.jogl.model.service.StableService;
import ru.mos.bmstu.jogl.view.viewcontrol.utils.DrawObject;


@RequiredArgsConstructor
public class MenuWorld extends Menu {
    private float size = 1;
    private Coordinate3D centerCoordinate = new Coordinate3D(0, 0, 0);
    @NonNull
    private StableService stableService;

    public void updSize(float mul) {
        size *= mul;
        if (size == 0) {
            size = 1;
        }
    }

    public void updCenterCoordinate(Coordinate3D coordinate) {
        centerCoordinate = new Coordinate3D(coordinate.getX() + centerCoordinate.getX(),
                coordinate.getY() + centerCoordinate.getY(),
                coordinate.getZ() + centerCoordinate.getZ());
    }

    public void draw(GL2 gl) {
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-border.getWidth(), border.getWidth(),
                -border.getHeight(), border.getHeight(),
                -border.getWidth(), border.getWidth());
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

//        gl.glRotatef(-90 + 15, 1, 0, 0);
//        gl.glRotatef(0, 0, 1, 0);
//        gl.glRotatef(60, 0, 0, 1);

        gl.glColor3f(0, 1, 0);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(size * (0 + centerCoordinate.getX()),
                size * (-border.getHeight() + centerCoordinate.getY()),
                size * (0 + centerCoordinate.getZ()));
        gl.glVertex3f(size * (0 + centerCoordinate.getX()),
                size * (border.getHeight() + centerCoordinate.getY()),
                size * (0 + centerCoordinate.getZ()));
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(size * (-border.getWidth() + centerCoordinate.getX()),
                size * (0 + centerCoordinate.getY()), size * (0 + centerCoordinate.getZ()));
        gl.glVertex3f(border.getWidth() + centerCoordinate.getX(),
                size * (0 + centerCoordinate.getY()), size * (0 + centerCoordinate.getZ()));
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(size * (0 + centerCoordinate.getX()),
                size * (0 + centerCoordinate.getY()), size * (-100 + centerCoordinate.getZ()));
        gl.glVertex3f(size * (0 + centerCoordinate.getX()),
                size * (0 + centerCoordinate.getY()), size * (100 + centerCoordinate.getZ()));
        gl.glEnd();

//        for (ModelObject modelObject : modelService.getListModelObjects()) {
//            ModelObject drawObject = new ModelObject(modelObject);
//            Coordinate3D centralCord = drawObject.getCentralCord();
//            drawObject.setCentralCord(new Coordinate3D(centralCord.getX() + centerCoordinate.getX(),
//                    centralCord.getY() + centerCoordinate.getY(),
//                    centralCord.getZ() + centerCoordinate.getZ()));
//            if (modelObject.equals(modelService.getCurrentModelObject())) {
//                DrawObject.drawCurrentModelObject(gl, drawObject, size, true);
//                continue;
//            }
//            DrawObject.drawModelObject(gl, drawObject, size, true);
//        }

        DrawObject.drawModelObject(gl, stableService.getCurrentModelObject(), size, true, border);
    }

    @Override
    public void clicked(int x, int y) {
        stableService.click((x - border.getWidth()/2)*2,(y -border.getHeight()/2)*2);
    }
}
