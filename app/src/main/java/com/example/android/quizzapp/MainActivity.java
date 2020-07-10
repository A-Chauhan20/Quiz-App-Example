package com.example.android.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getResults(View view) {

        boolean answerArray[];
        answerArray = new boolean[10];
        RadioButton answer = findViewById(R.id.answerOne);
        answerArray[0] = answer.isChecked();
        answer = findViewById(R.id.answerTwo);
        answerArray[1] = answer.isChecked();
        answer = findViewById(R.id.answerThree);
        answerArray[2] = answer.isChecked();
        answer = findViewById(R.id.answerFour);
        answerArray[3] = answer.isChecked();
        answer = findViewById(R.id.answerFive);
        answerArray[4] = answer.isChecked();



        EditText answer6 = findViewById(R.id.answerSix);
        try {


            if(!TextUtils.isEmpty(answer6.getText().toString())){
                int checkYear = Integer.parseInt(answer6.getText().toString());
                if (checkYear == 1972) {
                    answerArray[5] = true;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }



        answer = findViewById(R.id.answerSeven);
        answerArray[6] = answer.isChecked();
        answer = findViewById(R.id.answerEight);
        answerArray[7] = answer.isChecked();
        answer = findViewById(R.id.answerNine);
        answerArray[8] = answer.isChecked();
        CheckBox ans101 = findViewById(R.id.answerTen1);
        CheckBox ans102 = findViewById(R.id.answerTen2);
        CheckBox ans103 = findViewById(R.id.answerTen3);

        if (ans103.isChecked() || ans101.isChecked() && ans102.isChecked() && ans103.isChecked()) {
            answerArray[9] = false;
        } else if (ans101.isChecked() && ans102.isChecked()) {
            answerArray[9] = true;
        }
        int score = calculateScore(answerArray);
        displayScore(score);
    }

    private int calculateScore(boolean scoreArray[]) {
        int methodScore = 0;
        for (int i = 0; i < 10; i++) {
            if (scoreArray[i]) {
                methodScore = methodScore + 1;
            }
        }
        return methodScore;
    }

    private void displayScore(int finalScore) {

        TextView scoreMessage = (TextView) findViewById(R.id.answerResult);
        scoreMessage.setText("YOUR SCORE : " + finalScore + " /10");

        Toast.makeText(this, "YOUR SCORE : " + Integer.toString(finalScore) + " / 10", Toast.LENGTH_LONG).show();
    }


}
