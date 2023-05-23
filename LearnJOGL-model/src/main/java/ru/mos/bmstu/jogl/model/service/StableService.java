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
    private StableEnum stableEnum;
    @NonNull
    private ModelService modelService;
    @NonNull
    private PlanService planService;

    public void setSubEnum(Enum type) {
        if (type instanceof PlanService.PlanEnum planEnum) {
            planService.setPlanEnum(planEnum);
        }
    }


    public void click(float x, float y) {
        if (stableEnum == null) {
            return;
        }
        switch (stableEnum) {
            case PLANE -> planService.click(x, y);
            case MODEL -> modelService.click();
            case ASSEMBLING -> System.out.println();
        }
    }

    public ModelObject getCurrentModelObject() {
        if (stableEnum == null) {
            return null;
        }
        switch (stableEnum) {
            case PLANE -> {
                return planService.getCurrentModelObject();
            }
        }
        return null;
    }

    public Enum[] getCurrentSubEnums() {
        if (stableEnum == null) {
            return new Enum[]{};
        }
        switch (stableEnum) {
            case PLANE -> {
                return PlanService.PlanEnum.values();
            }
            case MODEL -> {
//                return ModelObjec
            }
            default -> {
                return new Enum[]{};
            }
        }
        return new Enum[]{};
    }
}
