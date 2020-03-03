package com.example.tourney;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.List;

@Table
public class Tournament extends SugarRecord {
    private Long id;

    private String month;

    public Tournament() {
    }

    public Tournament(String month) {
        this.month = month;
    }

    public Long getId(){return id;}
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }

}