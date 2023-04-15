package ru.mos.bmstu.jogl.model.database;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.ModelObject;
import ru.mos.bmstu.jogl.model.model.primitive.TruncatedPyramid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DBObject {
    public List<ModelObject> list = new ArrayList<>();

    {
        list.add(new TruncatedPyramid(0, 0, 0, 5));
    }
}
