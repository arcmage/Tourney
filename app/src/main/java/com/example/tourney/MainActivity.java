package com.example.tourney;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends Activity {
    private Button button, button2, button3;

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
}
