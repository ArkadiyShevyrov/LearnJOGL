package ru.mos.bmstu.jogl.model.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.Coordinate3D;
import ru.mos.bmstu.jogl.model.model.Edge3D;
import ru.mos.bmstu.jogl.model.model.ModelObject;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class Algorithmic {
    @NonNull
    private final ModelService modelService;

    public void a(float x, float y) {
        ModelObject modelObject = modelService.getListModelObjects().get(0);
        List<Coordinate3D> vertexes = modelObject.getVertexes();
        if (vertexes.size() == 0) {
            vertexes.add(new Coordinate3D(x, y, 0));
        } else {
            vertexes.add(new Coordinate3D(x, y, 0));
            List<Edge3D> edges = modelObject.getEdges();
            int size = vertexes.size();
            edges.add(new Edge3D(vertexes.get(size - 2), vertexes.get(size - 1)));
        }
    }
}
