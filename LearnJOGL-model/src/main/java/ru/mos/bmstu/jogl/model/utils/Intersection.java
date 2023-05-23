package ru.mos.bmstu.jogl.model.utils;

import ru.mos.bmstu.jogl.model.model.Coordinate2D;
import ru.mos.bmstu.jogl.model.model.Edge2D;
import ru.mos.bmstu.jogl.model.model.Polygon2D;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Intersection {
    private static double crossProduct(Coordinate2D a, Coordinate2D b) {
        return a.getX() * b.getY() - a.getY() * b.getX();
    }

    private static double isLeft(Coordinate2D a, Coordinate2D b, Coordinate2D c) {
        return crossProduct(new Coordinate2D(b.getX() - a.getX(), b.getY() - a.getY()),
                new Coordinate2D(c.getX() - a.getX(), c.getY() - a.getY()));
    }

    private static Coordinate2D intersection(Edge2D e1, Edge2D e2) {
        Coordinate2D a = e1.getStartCord();
        Coordinate2D b = e1.getEndCord();
        Coordinate2D c = e2.getStartCord();
        Coordinate2D d = e2.getEndCord();

        double isLeft1 = isLeft(a, b, c);
        double isLeft2 = isLeft(a, b, d);

        if (isLeft1 * isLeft2 >= 0) {
            return null;
        }

        double isLeft3 = isLeft(c, d, a);
        double isLeft4 = isLeft(c, d, b);

        if (isLeft3 * isLeft4 >= 0) {
            return null;
        }

        double denom = (d.getY() - c.getY()) * (b.getX() - a.getX()) - (d.getX() - c.getX()) * (b.getY() - a.getY());
        double ua = ((d.getX() - c.getX()) * (a.getY() - c.getY()) - (d.getY() - c.getY()) * (a.getX() - c.getX())) / denom;
        double ub = ((b.getX() - a.getX()) * (a.getY() - c.getY()) - (b.getY() - a.getY()) * (a.getX() - c.getX())) / denom;

        if (ua >= 0 && ua <= 1 && ub >= 0 && ub <= 1) {
            return new Coordinate2D((float) (a.getX() + ua * (b.getX() - a.getX())), (float) (a.getY() + ua * (b.getY() - a.getY())));
        }

        return null;
    }

    public static List<Coordinate2D> intersection(Polygon2D subjectPolygon, Polygon2D clipPolygon) {
        List<Edge2D> subjectEdges = subjectPolygon.getEdges();
        List<Edge2D> clipEdges = clipPolygon.getEdges();
        List<Coordinate2D> intersectionPoints = new ArrayList<>();

        for (Edge2D subjectEdge : subjectEdges) {
            List<Coordinate2D> edgeIntersectionPoints = new ArrayList<>();

            for (Edge2D clipEdge : clipEdges) {
                Coordinate2D intersectionPoint = intersection(subjectEdge, clipEdge);
                if (intersectionPoint == null) {
                    continue;
                }
                edgeIntersectionPoints.add(intersectionPoint);
            }

            if (!edgeIntersectionPoints.isEmpty()) {
                edgeIntersectionPoints.sort(Comparator.comparingDouble(Coordinate2D::getX));
                Coordinate2D firstPoint = edgeIntersectionPoints.get(0);
                Coordinate2D lastPoint = edgeIntersectionPoints.get(edgeIntersectionPoints.size() - 1);
                intersectionPoints.add(firstPoint);

                if (firstPoint != lastPoint) {
                    intersectionPoints.add(lastPoint);
                }
            }
        }

        return intersectionPoints;
    }
}
