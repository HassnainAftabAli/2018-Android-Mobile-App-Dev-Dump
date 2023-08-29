package com.ctis487.oldschool;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RapperTriviaActivity extends AppCompatActivity {

    TextView questionText;
    Spinner rappersSpinner;
    int randomQuestionIndex;
    Rapper randomRapper;
    String questionValue;
    boolean isDefaultSelected=true;
    String randomQuestion;
    GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapper_trivia);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mDetector = new GestureDetectorCompat(this, new MyGestureListener());


        questionText = findViewById(R.id.questionText);
        rappersSpinner = findViewById(R.id.rappersSpinner);

        MySpinnerAdapter spinnerAdapter = new MySpinnerAdapter(this, R.layout.rapperspinner_layout,  AllRappers.getAllRappers());
        rappersSpinner.setAdapter(spinnerAdapter);

        randomQuestion = generateRandomQuestion();

        questionText.setText(randomQuestion);

        rappersSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(isDefaultSelected)
                    isDefaultSelected = false;
                else {
                    int selectedItem = rappersSpinner.getSelectedItemPosition();
                    if(randomRapper.getStageName().equals(AllRappers.allRappers.get(selectedItem).getStageName()))
                        makeAndShowDialogBox("Correct Answer");
                    else
                        Toast.makeText(RapperTriviaActivity.this,"Wrong Answer. Try Again.",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public boolean onTouchEvent(MotionEvent event){
        mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private String generateRandomQuestion(){
        randomQuestionIndex = (int)(Math.random() * 3);
        randomRapper = AllRappers.randomRapper();

        switch(randomQuestionIndex){
            case 0: questionValue = Integer.toString(randomRapper.getBirthYear()); break;
            case 1: questionValue = Integer.toString(randomRapper.getDeathYear()); break;
            case 2: questionValue = randomRapper.getRealName(); break;
        }
        return AllRappers.questions.get(randomQuestionIndex)+questionValue+" ?";
    }

    private void makeAndShowDialogBox(String message) {
        AlertDialog.Builder mDialogBox = new AlertDialog.Builder(this);
        mDialogBox.setMessage(message);
        mDialogBox.setIcon(R.drawable.ic_launcher_background);
        mDialogBox.setPositiveButton("Try another",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        randomQuestion=generateRandomQuestion();
                        questionText.setText(randomQuestion);
                    }
                });
        mDialogBox.create();
        mDialogBox.show();
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDoubleTap(MotionEvent event) {
            Intent mainActivityIntent = new Intent(RapperTriviaActivity.this,MainActivity.class);
            startActivity(mainActivityIntent);
            return true;
        }
    }
}
