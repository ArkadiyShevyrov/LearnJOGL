package ru.mos.bmstu.jogl.view.viewcontrol.arhiv;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.Coordinate3D;
import ru.mos.bmstu.jogl.view.viewcontrol.service.Window;

@Slf4j
@RequiredArgsConstructor
@Getter
@Service
public class CoordinationService {
//    private final float scale = 10;
//    private final Coordinate3D centerCoordinate = new Coordinate3D(scale, scale, 0);
    @NonNull
    private Window window;

    public Coordinate3D sayTouch(float x, float y) {
        float newX, newY;
        int height = window.getHeight();
        newX = x ;
        newY = -1 * (y - height) ;
        return new Coordinate3D(newX, newY, 0);
    }
}
