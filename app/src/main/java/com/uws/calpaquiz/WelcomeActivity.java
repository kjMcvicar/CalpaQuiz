package com.uws.calpaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//This is the Welcome screen Class, functions here allow the user to enter the next screen
//and show info about the app

public class WelcomeActivity extends AppCompatActivity {

    //creating variables for buttons
    public Button startBtn, infoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //linking variables to xml design buttons
        startBtn = findViewById(R.id.btnStart);
        infoBtn = findViewById(R.id.btnInfo);

        //this function takes the user to the main activity
        startBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);
            }
        });

        //onclick listener to display app information
        infoBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }));
    }
}
