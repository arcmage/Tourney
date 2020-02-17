package com.example.tourney;

import android.app.Activity;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

public class ChooseTournamentActivity extends FragmentActivity implements
        AdapterView.OnItemSelectedListener {
    List<Tournament> tournamentList = new ArrayList<>();
    List<String> tours = new ArrayList<>();

    private Spinner tourn;
    private LinearLayout scoresRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_tournament);

        scoresRow = findViewById(R.id.scoresRow);
        tourn = findViewById(R.id.tourSpinner);
        tournamentList = Tournament.listAll(Tournament.class);
        for(Tournament item : tournamentList){
            tours.add(item.getMonth());
        }
        tourn.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tours);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tourn.setAdapter(aa);
        // Get the Tournament info and display it

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //TODO players value returned are null, try to join tables
        List<Tournament> t = Tournament.find(Tournament.class, "month = ?", parent.getItemAtPosition(position).toString());
        Tournament current = t.get(0);
        List<Player> particpatingPlayers = current.getPlayers();
        TextView newView = new TextView(ChooseTournamentActivity.this);
        for(Player item: particpatingPlayers) {
            newView.setText(item.getName().toString());
            scoresRow.addView(newView);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
