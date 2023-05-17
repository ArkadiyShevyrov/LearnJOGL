package ru.mos.bmstu.jogl.model.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
public class Plane {
    @Setter
    protected Coordinate3D centralCord;
    protected List<Coordinate3D> coordinates;

    public Plane(Coordinate3D centralCord) {
        this.centralCord = centralCord;
    }
}
