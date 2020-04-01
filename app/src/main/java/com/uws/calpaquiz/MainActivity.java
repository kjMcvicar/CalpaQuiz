package com.uws.calpaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {



    public Button btnEasy, btnMed, btnHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEasy = findViewById(R.id.btnEasy);
        btnMed = findViewById(R.id.btnMed);
        btnHard = findViewById(R.id.btnHard);

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               int diff = 1;
               Intent i = new Intent(getApplicationContext(), GameScreenActivity.class);
                i.putExtra("diff", diff);
               startActivity(i);
            }

        });

        btnMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int diff = 2;
                Intent i = new Intent(getApplicationContext(), GameScreenActivity.class);
                i.putExtra("diff", diff);
                startActivity(i);
            }

        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int diff = 3;
                Intent i = new Intent(getApplicationContext(), GameScreenActivity.class);
                i.putExtra("diff", diff);
                startActivity(i);
            }

        });


    }
}
