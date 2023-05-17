package ru.mos.bmstu.jogl.model.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinate3D {
    private float x;
    private float y;
    private float z;

    public Coordinate3D(Coordinate3D coordinate) {
        this.x = coordinate.getX();
        this.y = coordinate.getY();
        this.z = coordinate.getZ();
    }
}
