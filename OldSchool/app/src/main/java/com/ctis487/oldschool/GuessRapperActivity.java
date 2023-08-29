package com.ctis487.oldschool;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class GuessRapperActivity extends AppCompatActivity {

    ImageView rapperImage;
    EditText nameText;
    Button checkButton;
    Rapper randomRapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_rapper);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        rapperImage = findViewById(R.id.rapperLeftImage);
        nameText = findViewById(R.id.nameText);
        checkButton = findViewById(R.id.checkButton);

        randomRapper = AllRappers.randomRapper();

        if(!AllRappers.allRappers.isEmpty())
            rapperImage.setImageResource(randomRapper.getImageId());

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nameText.getText().toString().equals(""))
                    Toast.makeText(GuessRapperActivity.this,"Please enter a name", Toast.LENGTH_SHORT).show();
                else if(randomRapper.getStageName().equals(nameText.getText().toString()))
                    makeAndShowDialogBox("Correct Answer");
                else
                    Toast.makeText(GuessRapperActivity.this,"Wrong Answer", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void makeAndShowDialogBox(String message) {
        AlertDialog.Builder mDialogBox = new AlertDialog.Builder(this);
        mDialogBox.setMessage(message);
        mDialogBox.setIcon(R.drawable.ic_launcher_background);
        mDialogBox.setPositiveButton("Try another",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    randomRapper = AllRappers.randomRapper();

                    if(!AllRappers.allRappers.isEmpty())
                        rapperImage.setImageResource(randomRapper.getImageId());
                }
            });
         mDialogBox.create();
         mDialogBox.show();
    }
}
