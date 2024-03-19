package com.playground.bodyoft.enums;

import lombok.Data;

public enum TrainingDayEnum {
    PRIMEIRO(1), SEGUNDO(2), TERCEIRO(3);

    private int value;

    TrainingDayEnum(int value) {
        value = value;
    }

    public int getValue(){
        return value;
    }
}
