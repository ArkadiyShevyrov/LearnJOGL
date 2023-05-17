package ru.mos.bmstu.jogl.model.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge2D {
    private Coordinate2D startCord;
    private Coordinate2D endCord;
}
