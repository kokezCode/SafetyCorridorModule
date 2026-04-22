package com.autonomousvehicle.entity;

public record TrainingConfig(int epochs, double lr, double lambda) {
    public static TrainingConfig defaultConfig() { return new TrainingConfig(5000, 0.005, 0.001); }
}