package com.autonomousvehicle.entity;

public record TrainingResult(SVMModel model, double[] lossHistory, long timeMs) {}