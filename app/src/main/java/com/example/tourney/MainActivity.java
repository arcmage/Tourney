package com.example.tourney;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private Button button, button2, button3;

    static Tournament tournament = new Tournament();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button.setOnClickListener(addPlayerLS);
        button2.setOnClickListener(chooseTourLS);
        button3.setOnClickListener(setupTourLS);

        // Delete current records
        // Player.deleteAll(Player.class);
        // Tournament.deleteAll(Tournament.class);

        // TODO populate initial db
        //populateDB();
    }

    private View.OnClickListener addPlayerLS = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, AddPlayerActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener chooseTourLS = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ChooseTournamentActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener setupTourLS = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SetupNewTournament.class);
            startActivity(intent);
        }
    };

    private void populateDB(){
        Tournament t = new Tournament("Jan 2020");
        t.save();
        Player p1 = new Player("Gin", 25, t);
        p1.save();
        Player p2 = new Player("Devoo", 22, t);
        p2.save();
        Player p3 = new Player("Saydoh", 20, t);
        p3.save();
        Player p4 = new Player("Kira", 2, t);
        p4.save();
    }
}
