package com.autonomousvehicle.entity;

public final class DataPoint {
    private final double x;
    private final double y;
    private final int label; // +1 veya -1

    public DataPoint(double x, double y, int label) {
        if (label != 1 && label != -1) throw new IllegalArgumentException("Etiket +1 veya -1 olmalı.");
        this.x = x;
        this.y = y;
        this.label = label;
    }
    public double getX() { return x; }
    public double getY() { return y; }
    public int getLabel() { return label; }
}