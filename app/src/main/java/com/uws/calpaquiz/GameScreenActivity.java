package com.uws.calpaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameScreenActivity extends AppCompatActivity {

    public Button ansA, ansB, ansC, ansD;
    public TextView Question, Score, Count;
    public int count, score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);


        count = 0;
        score = 0;

        ansA = findViewById(R.id.btnAnsA);
        ansB = findViewById(R.id.btnAnsB);
        ansC = findViewById(R.id.btnAnsC);
        ansD = findViewById(R.id.btnAnsD);

        Question = findViewById(R.id.txtvQuestion);
        Score = findViewById(R.id.txtvScore);
        Count = findViewById(R.id.txtvCount);

        Intent mIntent = getIntent();
        int diff = mIntent.getIntExtra("diff", 0);

        final Question[] qSet = new Question[11];

        DatabaseAccess dbAccess = DatabaseAccess.getInstance(getApplicationContext());
        dbAccess.open();

        for(int i =0; i<qSet.length; i++){
            qSet[i] = dbAccess.genQuestion(diff);
        }

        setQuestion(qSet, count);

        Score.setText(Integer.toString(score));
        Count.setText(Integer.toString(count)+"/10");

        ansA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Context context = getApplicationContext();
                CharSequence yText = "Correct!";
                CharSequence nText = "Nope!";
                int duration = Toast.LENGTH_SHORT;

                DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String country = Question.getText().toString();
                String answer = ansA.getText().toString();

                if (databaseAccess.checkAnswer(country, answer)){
                    Toast toast = Toast.makeText(context, yText, duration);
                    toast.show();
                    score = score + 10;
                }
                else{
                    Toast toast = Toast.makeText(context, nText, duration);
                    toast.show();

                }

                count = count + 1;
                Score.setText(Integer.toString(score));
                Count.setText(Integer.toString(count)+"/10");

                setQuestion(qSet, count);

            }
        });

        ansB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Context context = getApplicationContext();
                CharSequence yText = "Correct!";
                CharSequence nText = "Nope!";
                int duration = Toast.LENGTH_SHORT;

                DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String country = Question.getText().toString();
                String answer = ansB.getText().toString();

                if (databaseAccess.checkAnswer(country, answer)){
                    Toast toast = Toast.makeText(context, yText, duration);
                    toast.show();
                    score = score + 10;


                }
                else{
                    Toast toast = Toast.makeText(context, nText, duration);
                    toast.show();


                }


                count = count + 1;
                Score.setText(Integer.toString(score));
                Count.setText(Integer.toString(count)+"/10");

                setQuestion(qSet, count);
            }

        });

        ansC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Context context = getApplicationContext();
                CharSequence yText = "Correct!";
                CharSequence nText = "Nope!";
                int duration = Toast.LENGTH_SHORT;

                DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String country = Question.getText().toString();
                String answer = ansC.getText().toString();

                if (databaseAccess.checkAnswer(country, answer)){
                    Toast toast = Toast.makeText(context, yText, duration);
                    toast.show();
                    score = score + 10;

                }
                else{
                    Toast toast = Toast.makeText(context, nText, duration);
                    toast.show();


                }


                count = count + 1;
                Score.setText(Integer.toString(score));
                Count.setText(Integer.toString(count)+"/10");

                setQuestion(qSet, count);
            }
        });

        ansD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Context context = getApplicationContext();
                CharSequence yText = "Correct!";
                CharSequence nText = "Nope!";
                int duration = Toast.LENGTH_SHORT;

                DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String country = Question.getText().toString();
                String answer = ansD.getText().toString();

                if (databaseAccess.checkAnswer(country, answer)){
                    Toast toast = Toast.makeText(context, yText, duration);
                    toast.show();
                    score = score + 10;

                }
                else{
                    Toast toast = Toast.makeText(context, nText, duration);
                    toast.show();

                }

                count = count + 1;
                Score.setText(Integer.toString(score));
                Count.setText(Integer.toString(count)+"/10");

                setQuestion(qSet, count);
            }
        });



    }

    public void setQuestion(Question [] array, int qNum){

       if (qNum <10) {
            Question.setText(array[qNum].getCountry());
            ansA.setText(array[qNum].getCapital());
            ansB.setText(array[qNum].getCityA());
            ansC.setText(array[qNum].getCityB());
            ansD.setText(array[qNum].getCityC());
        }
        else{
            Intent endGame = new Intent(getApplicationContext(), MainActivity.class);
           startActivity(endGame);
        }
    }


}
