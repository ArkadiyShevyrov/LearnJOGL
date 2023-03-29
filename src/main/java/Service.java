import model.ModelObject;
import model.primitive.Cube;
import model.primitive.TruncatedPyramid;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public List<ModelObject> list = new ArrayList<>();
    {
        list.add(new Cube(0, 0, 0, 0.3f));
    }
}
