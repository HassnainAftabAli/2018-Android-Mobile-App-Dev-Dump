package com.ctis487.oldschool;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class AddRapperActivity extends AppCompatActivity {

    Button addRappersButton;
    Button addQuestionsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rapper);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        addRappersButton = findViewById(R.id.addRappersButton);
        addQuestionsButton = findViewById(R.id.addQuestionsButton);

        addRappersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllRappers.addRapper(new Rapper("2pac", 1971, 1996, "Tupac Amaru Shakur",R.mipmap.tupac));
                AllRappers.addRapper(new Rapper("Biggie", 1972, 1997, "Christopher George Wallace",R.mipmap.biggie));
                AllRappers.addRapper(new Rapper("Big Pun", 1971, 2000, "Christopher Lee Carlos Rios",R.mipmap.bigpun));
                AllRappers.addRapper(new Rapper("BigL", 1974, 1999, "Lamont Coleman",R.mipmap.bigl));
                AllRappers.addRapper(new Rapper("Proof", 1973, 2006, "DeShaun Dupree Holton",R.mipmap.proof));
                AllRappers.addRapper(new Rapper("Prodigy", 1974, 2017, "Albert Johnson",R.mipmap.prodigy));
                AllRappers.addRapper(new Rapper("ODB", 1968, 2004, "Russell Tyrone Jones",R.mipmap.odb));

                Toast.makeText(AddRapperActivity.this,"All Dead Rappers Added", Toast.LENGTH_SHORT).show();
            }
        });

        addQuestionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllRappers.questions.add("Which Rapper's birth year is ");
                AllRappers.questions.add("Which Rapper's death year is ");
                AllRappers.questions.add("Which Rapper's real name is ");

                Toast.makeText(AddRapperActivity.this,"All Questions Added", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
