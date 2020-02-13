package com.example.tourney;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

import java.util.List;

public class SetupNewTournament extends Activity {
    private EditText month;
    private Spinner players;
    private Button submit, cancel, add;
    private LinearLayout participatingRow;
    private Tournament tournament;
    private List<Player> temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_new_tournament);

        month = findViewById(R.id.monthEntry);
        players = findViewById(R.id.playerSpinner);
        participatingRow = findViewById(R.id.participantRow);
        add = findViewById(R.id.addPlayer);
        submit = findViewById(R.id.submit);
        cancel = findViewById(R.id.cancel);

        add.setOnClickListener(addPlayerLS);
        submit.setOnClickListener(submitLS);
        cancel.setOnClickListener(cancelLS);

        tournament = new Tournament();
    }

    private View.OnClickListener addPlayerLS = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Player selected = (Player) players.getSelectedItem();
            temp.add(selected);
            TextView newPlayer = new TextView(SetupNewTournament.this);
            newPlayer.setText(selected.getName());
            participatingRow.addView(newPlayer);
        }
    };

    private View.OnClickListener submitLS = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // if not empty and players are 3 or more
            if(! month.getText().toString().equals("") && temp.size() >= 3){
                tournament.setMonth(month.getText().toString());
                tournament.setPlayers(temp);
                tournament.save();
                Intent intent = new Intent(SetupNewTournament.this, MainActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(), "Please make sure to " +
                        "input a name and have at least 3 players participating", Toast.LENGTH_LONG).show();
            }
        }
    };

    private View.OnClickListener cancelLS = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SetupNewTournament.this, MainActivity.class);
            startActivity(intent);
        }
    };
}
