package ru.mos.bmstu.jogl.model.utils;

import ru.mos.bmstu.jogl.model.model.Plan;
import ru.mos.bmstu.jogl.model.model.Polygon2D;
import ru.mos.bmstu.jogl.model.model.Polygon3D;
import java.util.List;

public class PlanUtils {

    public static Polygon2D createNewPolygon(Plan plan) {
        Polygon2D polygon = new Polygon2D();
        List<Polygon2D> polygons = plan.getPolygons();
        polygons.add(polygon);
        return polygon;
    }

}
