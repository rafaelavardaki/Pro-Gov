package com.progov;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.category.DefaultCategoryDataset;

public class CompareCharts {
    
    public static void showIncomeComparison(String[] incomeNames, 
                                           double[] incomeNow, 
                                           double[] incomeLast) {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < incomeNames.length; i++) {
            String categoryNumber = Integer.toString(i + 1); 
            
            dataset.addValue(incomeLast[i], "2024", categoryNumber);
            dataset.addValue(incomeNow[i], "2025", categoryNumber);
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
            "ΣΥΓΚΡΙΣΗ ΕΣΟΔΩΝ",      
            "ΚΑΤΗΓΟΡΙΕΣ ΕΣΟΔΩΝ",
            "ΠΟΣΟ (€)",  
            dataset
        );
        chart.getLegend().setVisible(true);
        chart.getLegend().setPosition(RectangleEdge.BOTTOM);
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(70, 130, 180)); 
        renderer.setSeriesPaint(1, new Color(60, 179, 113));
        renderer.setItemMargin(0.1);
        
        ChartFrame frame = new ChartFrame("Σύγκριση Εσόδων", chart);
        frame.setSize(1400, 800);
        frame.setVisible(true);
    }
    
    public static void showExpenseComparison(String[] expenseNames,
                                            double[] expensesNow,
                                            double[] expensesLast) {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < expenseNames.length; i++) {
            String categoryNumber = Integer.toString(i + 1);  
            
            dataset.addValue(expensesLast[i], "2024", categoryNumber);
            dataset.addValue(expensesNow[i], "2025", categoryNumber);
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
            "ΣΥΓΚΡΙΣΗ ΕΞΟΔΩΝ",      
            "ΚΑΤΗΓΟΡΙΕΣ ΕΞΟΔΩΝ",    
            "ΠΟΣΟ (€)",              
            dataset
        );
        
        
        chart.getLegend().setVisible(true);
        chart.getLegend().setPosition(RectangleEdge.BOTTOM);
        
       
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        
      
        renderer.setSeriesPaint(0, new Color(255, 140, 0));    
        renderer.setSeriesPaint(1, new Color(220, 20, 60));  
        renderer.setItemMargin(0.1);
        
        ChartFrame frame = new ChartFrame("Σύγκριση Εξόδων", chart);
        frame.setSize(1400, 800);
        frame.setVisible(true);
    }
}
