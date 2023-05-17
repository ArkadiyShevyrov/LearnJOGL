package ru.mos.bmstu.jogl.model.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class Polygon3D {
    List<Edge3D> edges = new ArrayList<>();

    public Polygon3D(Edge3D... edges) {
        this.edges.addAll(Arrays.stream(edges).toList());
    }
}
