package ru.mos.bmstu.jogl.view.viewcontrol.service;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.Coordinate;

@Slf4j
@RequiredArgsConstructor
@Getter
@Service
public class CoordinationService {
    @NonNull
    private Windows windows;
    private final float scale = 1;
    private final Coordinate centerCoordinate = new Coordinate(1,0,0);

    public void sayTouch(float x, float y) {
        float newX, newY;
        int height = windows.getGlWindow().getHeight();
        int width = windows.getGlWindow().getWidth();
        newX = x/scale + centerCoordinate.getX();
        newY = -1*(y - height)/scale + centerCoordinate.getY();
        System.out.println(newX + " " + newY);
    }
}
