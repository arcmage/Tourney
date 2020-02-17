package com.example.tourney;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SetupNewTournament extends Activity implements
    AdapterView.OnItemSelectedListener{
    List<Player> playersList = new ArrayList<>();
    List<String> names = new ArrayList<>();

    private EditText month;
    private Spinner players;
    private Button submit, cancel, add;
    private LinearLayout participatingRow;
    private Tournament tournament;
    private List<Player> temp = new ArrayList<>();

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

        playersList = Player.listAll(Player.class);
        for (Player item: playersList) {
            names.add(item.getName());
        }
        players.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, names);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        players.setAdapter(aa);

        add.setOnClickListener(addPlayerLS);
        submit.setOnClickListener(submitLS);
        cancel.setOnClickListener(cancelLS);

        tournament = new Tournament();
    }

    private View.OnClickListener addPlayerLS = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO query selected players from the database
            String selected = players.getSelectedItem().toString();
            //temp.add(selected);
            TextView newPlayer = new TextView(SetupNewTournament.this);
            newPlayer.setText(selected);
            participatingRow.addView(newPlayer);

            List<Player> player = Player.find(Player.class, "name = ?", selected);

            Log.w("MyTag", player.get(0).getName() + ", " + player.get(0).getScore());
            temp.add(player.get(0));
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
                Log.w("MyTag", "players? " + tournament.getPlayers().toString());
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
