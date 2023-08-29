package com.ctis487.oldschool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addRapperButton;
    Button guessRapperButton;
    Button rapperTriviaButton;
    Intent newActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        addRapperButton = findViewById(R.id.addRapperButton);
        guessRapperButton = findViewById(R.id.guessRapperButton);
        rapperTriviaButton = findViewById(R.id.rapperTriviaButton);
    }

    public void openActivity(View view) {
        int buttonId = view.getId();

        switch(buttonId){
            case R.id.addRapperButton:
                newActivity = new Intent(MainActivity.this,AddRapperActivity.class);
                break;
            case R.id.guessRapperButton:
                newActivity = new Intent(MainActivity.this,GuessRapperActivity.class);
                break;
            case R.id.rapperTriviaButton:
                newActivity = new Intent(MainActivity.this,RapperTriviaActivity.class);
                break;
        }
        startActivity(newActivity);
    }
}
