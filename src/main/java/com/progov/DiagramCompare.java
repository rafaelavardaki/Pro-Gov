package com.progov;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class DiagramCompare {
    
    public static void diagramm3(String[] incomeNames, 
                                double[] incomeNow, 
                                double[] incomeLastYear) {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int size = Math.min(
            incomeNames.length,
            Math.min(incomeNow.length, incomeLastYear.length)
        );
        
        if (size == 0) return;
        
        for (int i = 0; i < size; i++) {
            String shortName = incomeNames[i];
            dataset.addValue(incomeLastYear[i], "ΠΕΡΣΙ", shortName);
            dataset.addValue(incomeNow[i], "ΦΕΤΟΣ", shortName);
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
            "ΣΥΓΚΡΙΣΗ ΕΣΟΔΩΝ: 2024 vs 2025",
            "Κατηγορίες Εσόδων",
            "Ποσό (€)",
            dataset
        );

        ChartFrame frame = new ChartFrame("Σύγκριση Εσόδων", chart);
        frame.setSize(1000, 700);
        frame.setVisible(true);
    }
    
    public static void diagramm4(String[] expenseNames,
                                double[] expensesNow,
                                double[] expensesLastYear) {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int size = Math.min(
            expenseNames.length,
            Math.min(expensesNow.length, expensesLastYear.length)
        );
        
        if (size == 0) return;
        
        for (int i = 0; i < size; i++) {
            String shortName = expenseNames[i];
            dataset.addValue(expensesLastYear[i], "ΠΕΡΣΙ", shortName);
            dataset.addValue(expensesNow[i], "ΦΕΤΟΣ", shortName);
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
            "ΣΥΓΚΡΙΣΗ ΕΞΟΔΩΝ: 2024 vs 2025",
            "Κατηγορίες Εξόδων",
            "Ποσό (€)",
            dataset
        );

        ChartFrame frame = new ChartFrame("Σύγκριση Εξόδων", chart);
        frame.setSize(1000, 700);
        frame.setVisible(true);
    }
}
