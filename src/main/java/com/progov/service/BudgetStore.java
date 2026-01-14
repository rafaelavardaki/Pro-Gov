package com.progov.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.progov.model.BudgetData;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class BudgetStore {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final Path file = Path.of(System.getProperty("user.home"), ".progov", "budget.json");

    public BudgetData load() {
        try {
            if (!Files.exists(file)) {
                return defaultData(); // αρχικά δεδομένα
            }
            String json = Files.readString(file, StandardCharsets.UTF_8);
            BudgetData data = gson.fromJson(json, BudgetData.class);
            return (data != null) ? data : defaultData();
        } catch (Exception e) {
            return defaultData();
        }
    }

    public void save(BudgetData data) {
        try {
            Files.createDirectories(file.getParent());
            String json = gson.toJson(data);
            Files.writeString(file, json, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save budget.json", e);
        }
    }

    public String loadJson() {
        return gson.toJson(load());
    }

    public void saveJson(String json) {
        BudgetData data = gson.fromJson(json, BudgetData.class);
        if (data == null) data = defaultData();
        save(data);
    }

    // default αρχικά δεδομένα (αν δεν υπάρχει αρχείο)
    private BudgetData defaultData() {
        BudgetData d = new BudgetData();
        d.revenues.add(new com.progov.model.BudgetItem(1, "Φόρος Εισοδήματος", 24941));
        d.revenues.add(new com.progov.model.BudgetItem(2, "ΦΠΑ", 19500));
        d.revenues.add(new com.progov.model.BudgetItem(3, "Λοιπά Έσοδα", 21971));

        d.expenses.add(new com.progov.model.BudgetItem(11, "Υγεία", 12500));
        d.expenses.add(new com.progov.model.BudgetItem(12, "Παιδεία", 6404));
        d.expenses.add(new com.progov.model.BudgetItem(13, "Άμυνα", 8900));
        d.expenses.add(new com.progov.model.BudgetItem(14, "Λοιπά Έξοδα", 21000));
        return d;
    }
}
