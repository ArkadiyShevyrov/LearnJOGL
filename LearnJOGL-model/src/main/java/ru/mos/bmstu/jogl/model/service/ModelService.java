package ru.mos.bmstu.jogl.model.service;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.Coordinate3D;
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

    public void createNewModelObject(Coordinate3D coordinate) {
        ModelObject modelObject = new ModelObject(coordinate);
        dbObject.list.add(modelObject);
        currentModelObject = modelObject;
    }

    public void addPointToCurrentModel(Coordinate3D coordinate) {

    }

    public void addLineToCurrentModel(Coordinate3D coordinate) {

    }

    public void addSquareToCurrentModel(Coordinate3D coordinate) {

    }

    public void click() {

    }
}
