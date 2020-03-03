package com.example.tourney;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

@Table
public class Player extends SugarRecord {
    private Long id;
    Tournament tournament;

    private String name;
    private int score;
    private boolean active;
    private boolean isBuffed;
    private int buffsNumber;

    public Player(){

    }
    public Player(String name, int score, Tournament tournament) {
        this.name = name;
        this.score = score;
        this.active = true;
        this.isBuffed = false;
        this.buffsNumber = 0;
        this.tournament = Tournament.find(Tournament.class, "month = ?", tournament.getMonth()).get(0);
    }

    public Long getId(){
        return id;
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

    public void setBuffsNumber(int buffsNumber) { this.buffsNumber = buffsNumber; }

    public void setTournament(String month){
        Tournament t = Tournament.find(Tournament.class, "month = ?", month).get(0);
        this.tournament = t;
        this.save();
    }
}
