package com.autonomousvehicle.entity;

public final class SVMModel {
    private final double w1, w2, bias;

    public SVMModel(double w1, double w2, double bias) {
        this.w1 = w1; this.w2 = w2; this.bias = bias;
    }

    public double score(double x, double y) { return w1 * x + w2 * y + bias; }
    public int predict(double x, double y) { return score(x, y) >= 0 ? 1 : -1; }
    public double weightNorm() { return Math.sqrt(w1 * w1 + w2 * w2); }
    public double margin() { return 2.0 / weightNorm(); }

    public double getW1() { return w1; }
    public double getW2() { return w2; }
    public double getBias() { return bias; }
}