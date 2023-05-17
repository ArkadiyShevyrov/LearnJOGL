package ru.mos.bmstu.jogl.model.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge3D {
    private Coordinate3D startCord;
    private Coordinate3D endCord;
}
