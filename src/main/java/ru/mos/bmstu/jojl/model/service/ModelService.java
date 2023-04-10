package ru.mos.bmstu.jojl.model.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jojl.model.database.DBObject;
import ru.mos.bmstu.jojl.model.model.ModelObject;
import ru.mos.bmstu.jojl.model.model.primitive.TruncatedPyramid;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class ModelService {
    @NonNull
    private DBObject dbObject;

    public void addModelObject(ModelObject modelObject) {
        dbObject.list.add(modelObject);
    }

    public List<ModelObject> getListModelObjects() {
        return dbObject.list.stream().toList();
    }

    public void set(int i, ModelObject modelObject) {
        dbObject.list.set(i, modelObject);
    }
}
