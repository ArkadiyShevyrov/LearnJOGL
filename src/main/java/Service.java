import model.ModelObject;
import model.primitive.TruncatedPyramid;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public List<ModelObject> list = new ArrayList<>();
    {
        list.add(new TruncatedPyramid(0,0,0, 5));
    }
}
