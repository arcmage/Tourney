package com.example.tourney;

import com.orm.SugarRecord;

public class Player extends SugarRecord {
    private int id;
    private String name;
    private int score;
    private boolean active;
    private boolean isBuffed;
    private int buffsNumber;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        this.active = true;
        this.isBuffed = false;
        this.buffsNumber = 0;
    }

    public Player(String name, int score, boolean active, boolean isBuffed, int buffsNumber) {
        this.name = name;
        this.score = score;
        this.active = active;
        this.isBuffed = isBuffed;
        this.buffsNumber = buffsNumber;
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

    public int getBuffsNumber() {
        return buffsNumber;
    }

    public void setBuffsNumber(int buffsNumber) {
        this.buffsNumber = buffsNumber;
    }
}
