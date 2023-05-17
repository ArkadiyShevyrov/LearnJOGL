import org.junit.jupiter.api.Test;
import ru.mos.bmstu.jogl.model.model.Coordinate3D;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Test2 {

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

    @Test
    public void testIsEdgesClosed() {
        List<Coordinate3D> list = new ArrayList<>();
        list.add(new Coordinate3D(2, 0, 0));
        list.add(new Coordinate3D(3, 2, 0));
        list.add(new Coordinate3D(0, 3, 0));
        list.add(new Coordinate3D(1, 2, 0));

        assertTrue(isPointInPolygon(new Coordinate3D(2, 2, 0), list));
        assertFalse(isPointInPolygon(new Coordinate3D(0, 0, 0), list));
    }
}


