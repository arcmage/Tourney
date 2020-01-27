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

    public boolean validate(TextView name, TextView score){
        //TODO insure input would be in String and int format
        String nameValue = null;
        int scoreValue;
        try{
            nameValue = name.getText().toString();
            scoreValue = Integer.parseInt(score.getText().toString());
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Parsing failed",Toast.LENGTH_SHORT).show();
        }

        if(nameValue.equals("")){
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
            if(validate(name, score)){
                //TODO Create and Store Player info
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
