package ru.mos.bmstu.jogl.model.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinate2D {
    private float x;
    private float y;

    public Coordinate2D(Coordinate2D coordinate) {
        this.x = coordinate.getX();
        this.y = coordinate.getY();
    }
}
