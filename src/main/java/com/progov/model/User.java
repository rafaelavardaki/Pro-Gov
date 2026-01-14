package com.progov.model;

public class User {
    public String pan;          // Προσωπικός Αριθμός Πολίτη
    public String username;     // αν θες username, αλλιώς μπορεί να είναι ίδιο με pan
    public String passwordHash; // hashed password (salted)

    public User() {}

    public User(String pan, String username, String passwordHash) {
        this.pan = pan;
        this.username = username;
        this.passwordHash = passwordHash;
    }
}
