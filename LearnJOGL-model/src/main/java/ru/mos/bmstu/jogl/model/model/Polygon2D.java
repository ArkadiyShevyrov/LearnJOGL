package ru.mos.bmstu.jogl.model.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class Polygon2D {
    List<Edge2D> edges = new ArrayList<>();

    public Polygon2D(Edge2D... edges) {
        this.edges.addAll(Arrays.stream(edges).toList());
    }
}
