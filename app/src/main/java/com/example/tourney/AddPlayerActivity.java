package com.example.tourney;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AddPlayerActivity extends Activity {
    private TextView name, score, error;
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

    public boolean validate(String name, int score){
        if(name.equals("")){
            error.setText("Please input a name");
            return false;
        }
        //TODO insure no name duplicates exist

        return true;
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

            if(validate(nameValue, scoreValue)){
                //TODO Create and Store Player info
                Player player = new Player(nameValue, scoreValue);
                player.save();
                Toast.makeText(getApplicationContext(), "Player added", Toast.LENGTH_SHORT);

                Intent intent = new Intent(AddPlayerActivity.this, MainActivity.class);
                startActivity(intent);
            }
            else {
                error.setText("No dice");
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
