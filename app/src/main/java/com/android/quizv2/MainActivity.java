package com.android.quizv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int correctResponse;
    int incorrectResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int scoreTotal() {
        RadioButton rb1 = findViewById(R.id.question1_rb1);
        RadioButton rb2 = findViewById(R.id.question1_rb2);
        RadioButton rb3 = findViewById(R.id.question1_rb3);
        boolean response1 = rb1.isChecked();
        boolean response2 = rb2.isChecked();
        boolean response3 = rb3.isChecked();
        if (response3 && !response1 && !response2) {
            correctResponse += 1;
        } else {
            incorrectResponse++;
        }
        CheckBox cb1 = findViewById(R.id.question2_cb1);
        CheckBox cb2 = findViewById(R.id.question2_cb2);
        CheckBox cb3 = findViewById(R.id.question2_cb3);
        boolean res1 = cb1.isChecked();
        boolean res2 = cb2.isChecked();
        boolean res3 = cb3.isChecked();
        if (res3 && !res1 && !res2) {
            correctResponse += 1;
        } else {
            incorrectResponse++;
        }
        EditText stateResponse = (EditText) findViewById(R.id.question3_response);
        if (stateResponse.getText().toString().equals("Colorado")) {
            correctResponse += 1;
        } else {
            incorrectResponse++;
        }
        CheckBox q4cb2 = findViewById(R.id.question4_cb2);
        CheckBox q4cb3 = findViewById(R.id.question4_cb3);
        CheckBox q4cb1 = findViewById(R.id.question4_cb1);
        boolean resp1 = q4cb1.isChecked();
        boolean resp2 = q4cb2.isChecked();
        boolean resp3 = q4cb3.isChecked();
        if (resp1 && !resp2 && !resp3) {
            correctResponse += 1;
        } else {
            incorrectResponse++;
        }

        if (correctResponse > 4 || incorrectResponse > 4) {
            Toast.makeText(this, "Restart the App to Retake the Quiz", Toast.LENGTH_SHORT).show();
            correctResponse = 0;
            incorrectResponse = 0;
        }
        return correctResponse;
    }

    public void submitResponses(View view) {
        displayResponses(scoreTotal());
        String message = "Your total number of correct responses is: " + correctResponse + " and " + incorrectResponse + " incorrect responses";
        displayScore(message);
    }

    public void displayResponses(int score) {
        TextView totalCorrect = findViewById(R.id.score);
        totalCorrect.setText(String.valueOf(score));
    }

    public void displayScore(String totalScore) {
        TextView scoreTextView = findViewById(R.id.total_score);
        scoreTextView.setText(totalScore);
    }
}
