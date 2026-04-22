package com.autonomousvehicle.presentation;

import com.autonomousvehicle.entity.*;
import java.util.List;

public class UnifiedVisualizer {
    public void render(TrainingResult res, List<DataPoint> data) {
        // Öğrenme Eğrisi
        System.out.println("\n--- ÖĞRENME SÜRECİ (LOSS CURVE) ---");

        double[] h = res.lossHistory();

        for (int i = 0; i < h.length; i += h.length/10) {
            System.out.printf("Epoch %d: %.4f ", i, h[i]);
            for(int j=0; j<(int)(h[i]*20); j++) System.out.print("█");
            System.out.println();
        }

        System.out.printf("\nEğitim Süresi: %d ms\n", res.timeMs());

        // ASCII Harita
        System.out.println("\n--- OTONOM ARAÇ NAVİGASYON HARİTASI ---");
        System.out.println("A: Engel A, B: Engel B, #: Güvenli Hat, : Koridor");
        for (int y = 10; y >= -10; y--) {
            for (int x = -10; x <= 10; x++) {

                double score = res.model().score(x, y);
                char c = '.';
                if (Math.abs(score) < 0.3) c = '#';
                else if (Math.abs(score) < 1.0) c = ':';

                for(DataPoint p : data) {
                    if(Math.round(p.getX()) == x && Math.round(p.getY()) == y)
                        c = (p.getLabel() == 1) ? 'A' : 'B';
                }
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}