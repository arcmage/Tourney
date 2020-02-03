package com.example.tourney;

import com.orm.SugarRecord;

import java.util.List;

public class Tournament extends SugarRecord {
    private String month;
    private List<Player> players;

    public Tournament() {
    }

    public Tournament(String month, List<Player> players) {
        this.month = month;
        this.players = players;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}