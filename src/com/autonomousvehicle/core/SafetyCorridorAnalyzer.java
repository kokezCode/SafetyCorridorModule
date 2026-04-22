package com.autonomousvehicle.core;

import com.autonomousvehicle.entity.*;
import java.util.List;

public class SafetyCorridorAnalyzer {
    public void printReport(TrainingResult res, List<DataPoint> data) {

        SVMModel m = res.model();

        System.out.println("\n--- GÜVENLİK ANALİZİ ---");
        System.out.printf("Koridor Genişliği: %.4f birim\n", m.margin());
        System.out.printf("Denklem: %.2fx + %.2fy + %.2f = 0\n", m.getW1(), m.getW2(), m.getBias());

        int correct = 0;
        for(DataPoint p : data) if(m.predict(p.getX(), p.getY()) == p.getLabel()) correct++;
        System.out.printf("Doğruluk: %%%.1f\n", (100.0 * correct / data.size()));
    }
}