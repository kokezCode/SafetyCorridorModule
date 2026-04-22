package com.autonomousvehicle.core;

import com.autonomousvehicle.entity.*;
import java.util.List;

public class SVMTrainer {
    private final TrainingConfig config;

    public SVMTrainer(TrainingConfig config) { this.config = config; }

    public TrainingResult train(List<DataPoint> data) {
        double w1 = 0, w2 = 0, b = 0;
        double[] history = new double[config.epochs()];
        long start = System.currentTimeMillis();

        for (int e = 0; e < config.epochs(); e++) {
            double loss = 0;
            for (DataPoint p : data) {
                double margin = p.getLabel() * (w1 * p.getX() + w2 * p.getY() + b);
                if (margin < 1) {
                    w1 -= config.lr() * (2 * config.lambda() * w1 - p.getLabel() * p.getX());
                    w2 -= config.lr() * (2 * config.lambda() * w2 - p.getLabel() * p.getY());
                    b -= config.lr() * (-p.getLabel());
                    loss += 1 - margin;
                } else {
                    w1 -= config.lr() * (2 * config.lambda() * w1);
                    w2 -= config.lr() * (2 * config.lambda() * w2);
                }
            }
            history[e] = (config.lambda() * (w1*w1 + w2*w2)) + (loss / data.size());
        }
        return new TrainingResult(new SVMModel(w1, w2, b), history, System.currentTimeMillis() - start);
    }
}