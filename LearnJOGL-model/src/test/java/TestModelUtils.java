import org.junit.jupiter.api.Test;
import ru.mos.bmstu.jogl.model.model.Coordinate3D;
import ru.mos.bmstu.jogl.model.model.Edge3D;
import ru.mos.bmstu.jogl.model.utils.ModelUtils;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestModelUtils {

    @Test
    public void testIsEdgesClosed() {
        List<Edge3D> edgesTrue1 = new ArrayList<>();
        edgesTrue1.add(new Edge3D(new Coordinate3D(0, 0, 0), new Coordinate3D(1, 0, 0)));
        edgesTrue1.add(new Edge3D(new Coordinate3D(1, 0, 0), new Coordinate3D(2, 0, 0)));
        edgesTrue1.add(new Edge3D(new Coordinate3D(2, 0, 0), new Coordinate3D(0, 0, 0)));
        assertTrue(ModelUtils.isEdgesClosed(edgesTrue1));
        List<Edge3D> edgesFalse = new ArrayList<>();
        edgesFalse.add(new Edge3D(new Coordinate3D(0, 0, 0), new Coordinate3D(1, 0, 0)));
        edgesFalse.add(new Edge3D(new Coordinate3D(1, 0, 0), new Coordinate3D(2, 0, 0)));
        edgesFalse.add(new Edge3D(new Coordinate3D(2, 0, 0), new Coordinate3D(3, 0, 0)));
        assertFalse(ModelUtils.isEdgesClosed(edgesFalse));
    }

}
