package com.progov.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.progov.model.User;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UserStore {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Path file = Path.of(System.getProperty("user.home"), ".progov", "users.json");
    private final Type LIST_TYPE = new TypeToken<List<User>>(){}.getType();

    public List<User> loadAll() {
        try {
            if (!Files.exists(file)) return new ArrayList<>();
            String json = Files.readString(file, StandardCharsets.UTF_8);
            List<User> users = gson.fromJson(json, LIST_TYPE);
            return users != null ? users : new ArrayList<>();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void saveAll(List<User> users) {
        try {
            Files.createDirectories(file.getParent());
            Files.writeString(file, gson.toJson(users), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save users.json", e);
        }
    }
}
