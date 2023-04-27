package ru.mos.bmstu.jogl.model.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.Coordinate;
import ru.mos.bmstu.jogl.model.model.Edge;
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
        List<Coordinate> vertexes = modelObject.getVertexes();
        if (vertexes.size() == 0) {
            vertexes.add(new Coordinate(x, y, 0));
        } else {
            vertexes.add(new Coordinate(x, y, 0));
            List<Edge> edges = modelObject.getEdges();
            int size = vertexes.size();
            edges.add(new Edge(vertexes.get(size - 2), vertexes.get(size - 1)));
        }
    }
}
