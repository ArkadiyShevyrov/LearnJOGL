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

    public List<Coordinate2D> getVertexes() {
        List<Coordinate2D> list = new ArrayList<>();
        switch (edges.size()) {
            case 0 -> {
                return list;
            }
            case 1 -> list.add(edges.get(0).getStartCord());
            case 2 -> {
                list.add(edges.get(0).getStartCord());
                list.add(edges.get(0).getEndCord());
            }
            default -> {
                for (Edge2D edge : edges) {
                    list.add(edge.getStartCord());
                }
            }
        }
        return list;
    }
}
