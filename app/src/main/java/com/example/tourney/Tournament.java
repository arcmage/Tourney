package com.example.tourney;

import java.util.List;

public class Tournament {
    private int id;
    private String month;
    private List<Player> players;

    public Tournament() {
    }

    public Tournament(int id, String month, List<Player> players) {
        this.id = id;
        this.month = month;
        this.players = players;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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