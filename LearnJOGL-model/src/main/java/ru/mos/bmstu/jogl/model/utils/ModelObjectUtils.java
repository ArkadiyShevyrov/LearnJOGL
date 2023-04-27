package ru.mos.bmstu.jogl.model.utils;

import ru.mos.bmstu.jogl.model.model.Coordinate;
import ru.mos.bmstu.jogl.model.model.ModelObject;

public class ModelObjectUtils {
    public static Coordinate getMaxCord(ModelObject modelObject) {
        int maxX = 0;
        int maxY = 0;
        int maxZ = 0;
        for (Coordinate coordinate : modelObject.getVertexes()) {
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
        return new Coordinate(maxX, maxY, maxZ);
    }
}
