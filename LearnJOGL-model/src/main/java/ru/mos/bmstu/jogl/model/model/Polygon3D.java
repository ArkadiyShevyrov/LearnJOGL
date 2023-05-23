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

    public List<Coordinate3D> getVertexes() {
        List<Coordinate3D> list = new ArrayList<>();
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
                for (Edge3D edge : edges) {
                    list.add(edge.getStartCord());
                }
            }
        }
        return list;
    }
}
