package ru.mos.bmstu.jogl.view.viewcontrol.utils;

import com.jogamp.nativewindow.util.Rectangle;
import com.jogamp.opengl.GL2;
import ru.mos.bmstu.jogl.model.model.Coordinate3D;
import ru.mos.bmstu.jogl.model.model.Edge3D;
import ru.mos.bmstu.jogl.model.model.ModelObject;
import ru.mos.bmstu.jogl.model.model.Polygon3D;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class DrawObject {
    public static void drawEdges(GL2 gl, ModelObject modelObject) {
        Coordinate3D centralCord = modelObject.getCentralCord();
        gl.glBegin(GL2.GL_LINES);
        for (Edge3D edge : modelObject.getEdges()) {
            Coordinate3D startCord = edge.getStartCord();
            Coordinate3D endCord = edge.getEndCord();
            gl.glVertex3f(startCord.getX() + centralCord.getX(),
                    startCord.getY() + centralCord.getY(),
                    startCord.getZ() + centralCord.getZ());
            gl.glVertex3f(endCord.getX() + centralCord.getX(),
                    endCord.getY() + centralCord.getY(),
                    endCord.getZ() + centralCord.getZ());
        }
        gl.glEnd();
    }

    public static void drawPolygon(GL2 gl, ModelObject modelObject) {
        if (modelObject.getPolygons() == null) {
            return;
        }
        Coordinate3D centralCord = modelObject.getCentralCord();
        for (Polygon3D polygon : modelObject.getPolygons()) {
            List<Edge3D> edges = polygon.getEdges();
            switch (edges.size()) {
                case 0, 1, 2 -> {
                }
                case 3 -> {
                    gl.glBegin(GL2.GL_TRIANGLES);
                    for (Edge3D edge3D : edges) {
                        Coordinate3D coordinate = edge3D.getStartCord();
                        gl.glVertex3f((coordinate.getX() + centralCord.getX()),
                                (coordinate.getY() + centralCord.getY()),
                                (coordinate.getZ() + centralCord.getZ()));
                    }
                    gl.glEnd();
                }
                case 4 -> {
                    gl.glBegin(GL2.GL_QUADS);
                    for (Edge3D edge3D : edges) {
                        Coordinate3D coordinate = edge3D.getStartCord();
                        gl.glVertex3f((coordinate.getX() + centralCord.getX()),
                                (coordinate.getY() + centralCord.getY()),
                                (coordinate.getZ() + centralCord.getZ()));
                    }
                    gl.glEnd();
                }
                default -> {

                }
            }
        }
    }

    public static void drawBorder(GL2 gl, Rectangle border) {
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-border.getWidth() + 1, -border.getHeight(), 0);
        gl.glVertex3f(-border.getWidth(), border.getHeight(), 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(-border.getWidth(), border.getHeight() - 1, 0);
        gl.glVertex3f(border.getWidth(), border.getHeight(), 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(border.getWidth(), border.getHeight(), 0);
        gl.glVertex3f(border.getWidth(), -border.getHeight(), 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3f(border.getWidth(), -border.getHeight(), 0);
        gl.glVertex3f(-border.getWidth(), -border.getHeight(), 0);
        gl.glEnd();
    }

    public static void drawModelObject(GL2 gl, ModelObject modelObject, float size, boolean isPolygon) {
        if (isPolygon) {
            gl.glColor3f(1, 0, 1);
            drawPolygon(gl, modelObject, size);
        }
        gl.glColor3f(1, 1, 1);

        drawEdges(gl, modelObject, size);
    }

    private static void drawEdgesPixels(ModelObject modelObject, Rectangle border, int[][] matrix, int sizePixel) {
        for (Edge3D edge : modelObject.getEdges()) {
            Coordinate3D startCord = edge.getStartCord();
            Coordinate3D endCord = edge.getEndCord();
            drawLine((int) (startCord.getX() + border.getWidth()) / sizePixel, (int) (startCord.getY() + border.getHeight()) / sizePixel,
                    (int) (endCord.getX() + border.getWidth()) / sizePixel, (int) (endCord.getY() + border.getHeight()) / sizePixel, matrix);
        }
    }

    public static void drawLine(int x1, int y1, int x2, int y2, int[][] matrix) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (x1 != x2 || y1 != y2) {
            matrix[x1][y1] = 1;

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

    private static void drawPixel(GL2 gl, int x, int y, float size, float sizePixel) {
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3f(size * (x),
                size * (y),
                size * (0));
        gl.glVertex3f(size * (x + sizePixel),
                size * (y),
                size * (0));
        gl.glVertex3f(size * (x + sizePixel),
                size * (y + sizePixel),
                size * (0));
        gl.glVertex3f(size * (x),
                size * (y + sizePixel),
                size * (0));
        gl.glEnd();
    }

    public static void drawCurrentModelObject(GL2 gl, ModelObject modelObject, float size, boolean isPolygon) {
        if (isPolygon) {
            gl.glColor3f(0.3f, 0, 1);
            drawPolygon(gl, modelObject, size);
        }
        gl.glColor3f(0.3f, 1, 1);
        drawEdges(gl, modelObject, size);
    }

    private static void drawEdges(GL2 gl, ModelObject modelObject, float size) {
        Coordinate3D centralCord = modelObject.getCentralCord();
        gl.glBegin(GL2.GL_LINES);
        for (Edge3D edge : modelObject.getEdges()) {
            Coordinate3D startCord = edge.getStartCord();
            Coordinate3D endCord = edge.getEndCord();
            gl.glVertex3f(size * (startCord.getX() + centralCord.getX()),
                    size * (startCord.getY() + centralCord.getY()),
                    size * (startCord.getZ() + centralCord.getZ()));
            gl.glVertex3f(size * (endCord.getX() + centralCord.getX()),
                    size * (endCord.getY() + centralCord.getY()),
                    size * (endCord.getZ() + centralCord.getZ()));
        }
        gl.glEnd();
    }

    private static void drawPolygon(GL2 gl, ModelObject modelObject, float size) {
        if (modelObject.getPolygons() == null) {
            return;
        }
        Coordinate3D centralCord = modelObject.getCentralCord();
        for (Polygon3D polygon : modelObject.getPolygons()) {
            List<Edge3D> edges = polygon.getEdges();
            switch (edges.size()) {
                case 3: {
                    gl.glBegin(GL2.GL_TRIANGLES);
                    for (Edge3D edge3D : edges) {
                        Coordinate3D coordinate = edge3D.getStartCord();
                        gl.glVertex3f(size * (coordinate.getX() + centralCord.getX()),
                                size * (coordinate.getY() + centralCord.getY()),
                                size * (coordinate.getZ() + centralCord.getZ()));
                    }
                    gl.glEnd();
                }
                case 4: {
                    gl.glBegin(GL2.GL_QUADS);
                    for (Edge3D edge3D : edges) {
                        Coordinate3D coordinate = edge3D.getStartCord();
                        gl.glVertex3f(size * (coordinate.getX() + centralCord.getX()),
                                size * (coordinate.getY() + centralCord.getY()),
                                size * (coordinate.getZ() + centralCord.getZ()));
                    }
                    gl.glEnd();
                }
            }
        }
    }

    public static void drawModelObject(GL2 gl, ModelObject modelObject, float size, boolean isPolygon, Rectangle border) {
        int sizePixel = 10;
        boolean pixels = true;
        int[][] matrix = new int[(border.getWidth() * 2 + 1)][(border.getHeight() * 2 + 1)];

        gl.glColor3f(1, 1, 1);
        if (pixels && modelObject.getVertexes().size() != 0) {
            drawEdgesPixels(modelObject, border, matrix, sizePixel);
            Coordinate3D coordinate3D = getCoordinate3D(modelObject);

            fill(matrix, (int) (coordinate3D.getX() + border.getWidth()) / sizePixel,
                    (int) (coordinate3D.getY() + border.getHeight()) / sizePixel,
                    2, 1);
        } else {
            drawEdges(gl, modelObject, size);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int a = matrix[i][j];
                gl.glColor3f(1, 1, 1);
                if (a == 1) {
                    drawPixel(gl, i * sizePixel - border.getWidth(), j * sizePixel - border.getHeight(), size, sizePixel);
                }
                gl.glColor3f(1, 0, 1);
                if (a == 2) {
                    drawPixel(gl, i * sizePixel - border.getWidth(), j * sizePixel - border.getHeight(), size, sizePixel);
                }
            }
        }
    }

    private static Coordinate3D getCoordinate3D(ModelObject modelObject) {
        int minX = (int) modelObject.getVertexes().get(0).getX();
        int maxX = (int) modelObject.getVertexes().get(0).getX();
        int minY = (int) modelObject.getVertexes().get(0).getY();
        int maxY = (int) modelObject.getVertexes().get(0).getY();
        for (int i = 1; i < modelObject.getVertexes().size(); i++) {
            if (modelObject.getVertexes().get(i).getX() < minX) {
                minX = (int) modelObject.getVertexes().get(i).getX();
            }
            if (modelObject.getVertexes().get(i).getX() > maxX) {
                maxX = (int) modelObject.getVertexes().get(i).getX();
            }
            if (modelObject.getVertexes().get(i).getY() < minY) {
                minY = (int) modelObject.getVertexes().get(i).getY();
            }
            if (modelObject.getVertexes().get(i).getY() > maxY) {
                maxY = (int) modelObject.getVertexes().get(i).getY();
            }
        }
        for (int i = minX; i < maxX; i++) {
            for (int j = minY; j < maxY; j++) {
                Coordinate3D coordinateD = new Coordinate3D(i, j, 0);
                Coordinate3D coordinate2D = new Coordinate3D(i+10, j, 0);
                Coordinate3D coordinate3D = new Coordinate3D(i-10, j, 0);
                Coordinate3D coordinate4D = new Coordinate3D(i, j+10, 0);
                Coordinate3D coordinate5D = new Coordinate3D(i, j-10, 0);
                if (isPointInPolygon(coordinateD, modelObject.getVertexes()) &&
                        isPointInPolygon(coordinate2D, modelObject.getVertexes()) &&
                        isPointInPolygon(coordinate3D, modelObject.getVertexes()) &&
                        isPointInPolygon(coordinate4D, modelObject.getVertexes()) &&
                        isPointInPolygon(coordinate5D, modelObject.getVertexes())
                ) {
                    return coordinate2D;
                }
            }
        }
        return new Coordinate3D(0, 0, 0);
    }

    public static void fill(int[][] matrix, int x, int y, int fillValue, int boundaryValue) {
        if (matrix[x][y] == fillValue || matrix[x][y] == boundaryValue) {
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int px = point[0];
            int py = point[1];

            if (matrix[px][py] == fillValue || matrix[px][py] == boundaryValue) {
                continue;
            }

            matrix[px][py] = fillValue;

            if (px > 0) {
                queue.add(new int[]{px - 1, py});
            }
            if (py > 0) {
                queue.add(new int[]{px, py - 1});
            }
            if (px < matrix.length - 1) {
                queue.add(new int[]{px + 1, py});
            }
            if (py < matrix[0].length - 1) {
                queue.add(new int[]{px, py + 1});
            }
        }
    }


    public static boolean isPointInPolygon(Coordinate3D point, List<Coordinate3D> polygon) {
        int intersections = 0;
        for (int i = 0; i < polygon.size(); i++) {
            Coordinate3D p1 = polygon.get(i);
            Coordinate3D p2 = polygon.get((i + 1) % polygon.size());
            if (point.getY() > Math.min(p1.getY(), p2.getY()) &&
                    point.getY() <= Math.max(p1.getY(), p2.getY()) &&
                    point.getX() <= Math.max(p1.getX(), p2.getX()) &&
                    p1.getY() != p2.getY()) {
                double xIntersection = (point.getY() - p1.getY()) * (p2.getX() - p1.getX()) / (p2.getY() - p1.getY()) + p1.getX();
                if (p1.getX() == p2.getX() || point.getX() <= xIntersection) {
                    intersections++;
                }
            }
        }
        return intersections % 2 == 1;
    }
}
