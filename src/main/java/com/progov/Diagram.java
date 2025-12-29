package com.progov;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class Diagram {
     public static void diagramm1(String[] a, double[] b) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < a.length; i++) {
                dataset.addValue(b[i], "Έσοδα", a[i]);
        }
        JFreeChart chart = ChartFactory.createBarChart(
                "Έσοδα Κρατικού Προϋπολογισμού Ελλάδας (2025)",
                "Κατηγορία",
                "Δισ. €",
                dataset
        );

        ChartFrame frame = new ChartFrame("Bar Chart", chart);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public static void diagramm2(String[] a, double[] b) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < a.length; i++) {
                dataset.addValue(b[i], "Έξοδα", a[i]);
        }
        JFreeChart chart = ChartFactory.createBarChart(
                "Έξοδα Κρατικού Προϋπολογισμού Ελλάδας (2025)",
                "Κατηγορία",
                "€",
                dataset
        );

        ChartFrame frame = new ChartFrame("Bar Chart", chart);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
