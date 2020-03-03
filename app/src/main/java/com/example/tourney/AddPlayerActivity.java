package com.example.tourney;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AddPlayerActivity extends Activity {
    private EditText name, score;
    private TextView error;
    private Button submit, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        name = findViewById(R.id.name);
        score = findViewById(R.id.score);
        error = findViewById(R.id.error);
        submit = findViewById(R.id.submitBT);
        cancel = findViewById(R.id.cancelBT);

        submit.setOnClickListener(submitLS);
        cancel.setOnClickListener(cancelLS);
    }

    // TODO add more validation later
    public boolean validate(String name){
        if(name.equals("")){
            Toast.makeText(getApplicationContext(),"Please enter a name", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    public boolean isDuplicate(Player player){
        boolean condition = false;
        try {
            condition = Player.find(
                    Player.class, "name = ?", player.getName()).size() > 0 ? true : false;
            Log.w("MyTag","The list size: " + Player.find(
                    Player.class, "name = ?", player.getName()).size());
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "exception: " + e.getMessage(),Toast.LENGTH_LONG);
            Log.d("dbError","exception: " + e.getMessage());
            System.out.println("Exception: " + e.getMessage());
        }

        return condition;
    }

    public boolean addPlayer(String nameValue, int scoreValue){
        Player player = new Player(nameValue, scoreValue, MainActivity.tournament);
        if(! isDuplicate(player)){
            player.save();
            Toast.makeText(getApplicationContext(), "Player added", Toast.LENGTH_LONG).show();

            return true;
        }
        else{
            Toast.makeText(getApplicationContext(), "Player already exist", Toast.LENGTH_LONG).show();

            return false;
        }
    }

    // set listeners
    private View.OnClickListener submitLS = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            error.setText("");
            String nameValue = null;
            int scoreValue = 0;
            try{
                nameValue = name.getText().toString();
                scoreValue = Integer.parseInt(score.getText().toString());
            }catch(Exception e){
                Toast.makeText(getApplicationContext(),"Parsing failed",Toast.LENGTH_SHORT).show();
            }

            if(validate(nameValue)){
                if(addPlayer(nameValue, scoreValue)){
                    Intent intent = new Intent(AddPlayerActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
            else {
                error.setText("Validation failed");
            }
        }
    };

    private View.OnClickListener cancelLS = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(AddPlayerActivity.this, MainActivity.class);
            startActivity(intent);
        }
    };
}
