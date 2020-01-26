package com.example.tourney;

public class Player {
    private String name;
    private int score;
    private boolean active;
    private boolean isBuffed;
    private int x;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Player(String name, int score, boolean active, boolean isBuffed, int x) {
        this.name = name;
        this.score = score;
        this.active = active;
        this.isBuffed = isBuffed;
        this.x = x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isBuffed() {
        return isBuffed;
    }

    public void setBuffed(boolean buffed) {
        isBuffed = buffed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
