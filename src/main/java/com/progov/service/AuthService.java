package com.progov.service;

import com.progov.model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

public class AuthService {

    private final UserStore store = new UserStore();

    // stored as: saltBase64:hashBase64
    private String hashPassword(String password) {
        try {
            byte[] salt = new byte[16];
            new SecureRandom().nextBytes(salt);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));

            return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean verifyPassword(String password, String stored) {
        try {
            String[] parts = stored.split(":");
            if (parts.length != 2) return false;

            byte[] salt = Base64.getDecoder().decode(parts[0]);
            byte[] expected = Base64.getDecoder().decode(parts[1]);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] actual = md.digest(password.getBytes(StandardCharsets.UTF_8));

            if (actual.length != expected.length) return false;
            int diff = 0;
            for (int i = 0; i < actual.length; i++) diff |= (actual[i] ^ expected[i]);
            return diff == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public String registerCitizen(String pan, String password) {
        final String panNorm = pan == null ? "" : pan.trim();
        final String passNorm = password == null ? "" : password.trim();

        if (panNorm.isEmpty() || passNorm.isEmpty()) return "Συμπληρώστε όλα τα πεδία.";
        if (panNorm.length() < 6) return "Ο Προσωπικός Αριθμός πρέπει να έχει τουλάχιστον 6 χαρακτήρες.";
        if (passNorm.length() < 4) return "Ο κωδικός πρέπει να έχει τουλάχιστον 4 χαρακτήρες.";

        List<User> users = store.loadAll();
        boolean exists = users.stream().anyMatch(u -> panNorm.equals(u.pan));
        if (exists) return "Υπάρχει ήδη λογαριασμός με αυτόν τον Προσωπικό Αριθμό.";

        String hash = hashPassword(passNorm);
        users.add(new User(panNorm, panNorm, hash)); // username = pan
        store.saveAll(users);

        return "OK";
    }

    public boolean loginCitizen(String pan, String password) {
        List<User> users = store.loadAll();
        User u = users.stream().filter(x -> x.pan != null && x.pan.equals(pan)).findFirst().orElse(null);
        if (u == null) return false;
        return verifyPassword(password, u.passwordHash);
    }

    // Για editor κρατάμε “σταθερό admin/admin” (ή το κάνουμε και αυτό store αν θες)
    public boolean loginEditor(String username, String password) {
        return "admin".equals(username) && "admin".equals(password);
    }
}
