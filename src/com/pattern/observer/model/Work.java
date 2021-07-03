package com.pattern.observer.model;

import java.time.LocalDate;

public class Work {

    private final String name;
    private final LocalDate deliveryDate;
    private final float value;

    public Work(String name, LocalDate deliveryDate, float value) {
        this.name = name;
        this.deliveryDate = deliveryDate;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Work{" +
                "name='" + name + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", value=" + value +
                '}';
    }
}
