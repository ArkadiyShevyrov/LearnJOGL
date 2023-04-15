package ru.mos.bmstu.jogl.model.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class Polygon {
    List<Coordinate> vertexes = new ArrayList<>();

    public Polygon(Coordinate ... coordinates) {
        vertexes.addAll(Arrays.stream(coordinates).toList());
    }
}
