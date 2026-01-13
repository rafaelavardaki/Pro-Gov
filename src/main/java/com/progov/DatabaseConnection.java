package com.progov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/progov_db";
    private static final String USER = "root";  // Replace with your MySQL username
    private static final String PASSWORD = "RafVar0828!";  // Replace with your MySQL password

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createTables() {
        String createBudgetTableSQL = "CREATE TABLE IF NOT EXISTS budget_items (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "type ENUM ('income', 'expense') NOT NULL," +
                "category VARCHAR(255) NOT NULL," +
                "amount DOUBLE NOT NULL" +
                ");";

        try (Connection conn = getConnection();
             var stmt = conn.createStatement()) {
            stmt.execute(createBudgetTableSQL);
            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public static void saveBudgetItem(String type, String category, double amount) {
        String insertSQL = "INSERT INTO budget_items (type, category, amount) VALUES (?, ?, ?);";

        try (Connection conn = getConnection();
             var pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, type);
            pstmt.setString(2, category);
            pstmt.setDouble(3, amount);
            pstmt.executeUpdate();
            System.out.println("Budget item saved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int loadBudgetItems(String category, String type) {
        String querySQL = "SELECT * FROM budget_items WHERE category = ? AND type = ?;";

        try (Connection conn = getConnection();
             var pstmt = conn.prepareStatement(querySQL)) {
            pstmt.setString(1, category);
            pstmt.setString(2, type);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                
                String cat = rs.getString("category");
                double amount = rs.getDouble("amount");
                System.out.println( "Category: " + cat + ", Amount: " + amount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static List<String> getCategoriesByType(String type) {
        List<String> categories = new ArrayList<>();
        String querySQL = "SELECT DISTINCT category FROM budget_items WHERE type = ?;";

        try (Connection conn = getConnection();
             var pstmt = conn.prepareStatement(querySQL)) {
            pstmt.setString(1, type);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                categories.add(rs.getString("category") + " : " + rs.getDouble("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

}