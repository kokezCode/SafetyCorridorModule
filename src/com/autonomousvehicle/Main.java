package com.autonomousvehicle;

import com.autonomousvehicle.core.*;
import com.autonomousvehicle.entity.*;
import com.autonomousvehicle.presentation.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var data = Arrays.asList(
                new DataPoint(-5, 5, 1), new DataPoint(-3, 7, 1), new DataPoint(-2, 4, 1),
                new DataPoint(5, -5, -1), new DataPoint(3, -7, -1), new DataPoint(2, -4, -1)
        );

        var trainer = new SVMTrainer(TrainingConfig.defaultConfig());
        var result = trainer.train(data);

        new SafetyCorridorAnalyzer().printReport(result, data);
        new UnifiedVisualizer().render(result, data);
    }
}