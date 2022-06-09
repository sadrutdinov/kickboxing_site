package com.sai.kickboxing_site.entities.cost_of_training;

public enum TrainingType {
    ONE("Разовое"),
    EIGHT("Абонемент (8 занятий)"),
    TWELVE("Абонемент (12 занятий)");

    private String description;

    TrainingType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
