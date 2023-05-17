package ru.mos.bmstu.jogl.model.database;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.Coordinate3D;
import ru.mos.bmstu.jogl.model.model.ModelObject;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DBObject {
    public List<ModelObject> list = new ArrayList<>();

    {
        ModelObject modelObject = new ModelObject(new Coordinate3D(0, 0, 0));
        List<Coordinate3D> vertexes = modelObject.getVertexes();

        list.add(modelObject);
//        list.add(new Plan(new Coordinate3D(0,0,0)));
//        list.add(new Cube(0,0,0,100));
//        list.add(new TruncatedPyramid(0,0,0,140));
//        list.add(new Cube(0,-40,-60, 100));
//        list.add(new TruncatedPyramid(40,80,100,30));
    }
}
