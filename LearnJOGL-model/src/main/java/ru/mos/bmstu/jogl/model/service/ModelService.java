package ru.mos.bmstu.jogl.model.service;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.ModelObject;
import ru.mos.bmstu.jogl.model.database.DBObject;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class ModelService {
    @NonNull
    private DBObject dbObject;
    @Getter
    private ModelObject currentModelObject;

//    public void addModelObject(ModelObject modelObject) {
//        dbObject.list.add(modelObject);
//    }

    public List<ModelObject> getListModelObjects() {
        return dbObject.list.stream().toList();
    }

    public void setCurrentModelObject(int index) {
        currentModelObject = dbObject.list.get(index);
    }

//    public void set(int i, ModelObject modelObject) {
//        dbObject.list.set(i, modelObject);
//    }
}
