package com.example.tourney;

import android.app.Activity;
import android.view.View;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

public class ChooseTournamentActivity extends FragmentActivity {
    private Spinner tourn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_tournament);

        tourn = findViewById(R.id.tourSpinner);
        // Get the Tournament info and display it

        //tourn.setOnItemSelectedListener(tournChangedLS);

    }


}
