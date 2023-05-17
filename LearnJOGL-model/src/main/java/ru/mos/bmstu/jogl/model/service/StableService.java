package ru.mos.bmstu.jogl.model.service;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mos.bmstu.jogl.model.model.ModelObject;

@Slf4j
@Service
@RequiredArgsConstructor
public class StableService {
    public enum StableEnum {
        PLANE,
        MODEL,
        ASSEMBLING,
    }
    @Getter
    @Setter
    private StableEnum stableEnum = StableEnum.PLANE;
    @NonNull
    private ModelService modelService;
    @NonNull
    private PlanService planService;


    public void click(float x, float y) {
        switch (stableEnum) {
            case PLANE -> planService.click(x, y);
            case MODEL -> modelService.click();
            case ASSEMBLING -> System.out.println();
        }
    }

    public ModelObject getCurrentModelObject() {
        switch (stableEnum) {
            case PLANE -> {
                return planService.getCurrentModelObject();
            }
        }
        return null;
    }
}
