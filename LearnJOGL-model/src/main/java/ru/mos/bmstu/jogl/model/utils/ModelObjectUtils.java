package ru.mos.bmstu.jogl.model.utils;

import ru.mos.bmstu.jogl.model.model.Coordinate3D;
import ru.mos.bmstu.jogl.model.model.ModelObject;

public class ModelObjectUtils {
    public static Coordinate3D getMaxCord(ModelObject modelObject) {
        int maxX = 0;
        int maxY = 0;
        int maxZ = 0;
        for (Coordinate3D coordinate : modelObject.getVertexes()) {
            float x = coordinate.getX();
            if (x > maxX) {
                maxX = (int) Math.floor(x);
            }
            float y = coordinate.getY();
            if (y > maxY) {
                maxY = (int) Math.floor(y);
            }
            float z = coordinate.getZ();
            if (z > maxZ) {
                maxZ = (int) Math.floor(z);
            }
        }
        return new Coordinate3D(maxX, maxY, maxZ);
    }
}
