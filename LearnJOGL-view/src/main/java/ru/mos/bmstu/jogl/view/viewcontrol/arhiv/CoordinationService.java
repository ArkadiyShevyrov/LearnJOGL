package ru.mos.bmstu.jogl.view.viewcontrol.arhiv;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.Coordinate;
import ru.mos.bmstu.jogl.model.service.Algorithmic;
import ru.mos.bmstu.jogl.view.viewcontrol.service.Window;

@Slf4j
@RequiredArgsConstructor
@Getter
@Service
public class CoordinationService {
//    private final float scale = 10;
//    private final Coordinate centerCoordinate = new Coordinate(scale, scale, 0);
    @NonNull
    private Window window;

    public Coordinate sayTouch(float x, float y) {
        float newX, newY;
        int height = window.getHeight();
        newX = x ;
        newY = -1 * (y - height) ;
        return new Coordinate(newX, newY, 0);
    }
}
