package ru.mos.bmstu.jogl.model.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {
    private Coordinate startCord;
    private Coordinate endCord;
}
