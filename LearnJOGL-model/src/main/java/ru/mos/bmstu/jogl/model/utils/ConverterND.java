package ru.mos.bmstu.jogl.model.utils;

import ru.mos.bmstu.jogl.model.model.*;
import java.util.ArrayList;
import java.util.List;

public class ConverterND {
    public static Polygon3D convertTo3D(Polygon2D polygon2D) {
        List<Edge2D> edges2D = polygon2D.getEdges();
        List<Edge3D> edges3D = new ArrayList<>();
        for (Edge2D edge2D : edges2D) {
            edges3D.add(convertTo3D(edge2D));
        }
        return new Polygon3D(edges3D);
    }

    public static Edge3D convertTo3D(Edge2D edge2D) {
        return new Edge3D(convertTo3D(edge2D.getStartCord()), convertTo3D(edge2D.getEndCord()));
    }

    public static Coordinate3D convertTo3D(Coordinate2D coordinate2D) {
        return new Coordinate3D(coordinate2D.getX(), coordinate2D.getY(), 0);
    }
}
