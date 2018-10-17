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


    public void scoreQuestion1 (View view) {
        RadioButton rb3 = findViewById(R.id.question1_rb3);

    }
   public void scoreQuestion2(View view) {
        CheckBox cb1 = findViewById(R.id.question2_cb3);

    }
    public void scoreQuestion3(View view) {
        EditText stateResponse = (EditText) findViewById(R.id.question3_response);

    }

    public void scoreQuestion4(View view) {

    }
    public int scoreTotal() {
        int totalScore1;
        RadioButton rb3 = findViewById(R.id.question1_rb3);
        boolean response3 = rb3.isChecked();
        if (response3) {
            correctResponse +=1;
        } else {
            incorrectResponse++;
        }
        CheckBox cb1 = findViewById(R.id.question2_cb3);
        boolean response1 = cb1.isChecked();
        if(response1) {
            correctResponse +=1;
        } else {
            incorrectResponse++;
        }
        EditText stateResponse = (EditText) findViewById(R.id.question3_response);
        if(stateResponse.getText().toString().equals("Colorado")) {
            correctResponse+=1;;
            //displayResponses(correctResponse);
        } else {
            incorrectResponse++;
        }
        CheckBox q4cb1 = findViewById(R.id.question4_cb1);
        boolean resp1 = q4cb1.isChecked();
        if(resp1) {
            correctResponse+=1;
        } else {
            incorrectResponse++;
        }

        if(correctResponse > 4){
            Toast.makeText(this, "Restart the App to Retake the Quiz", Toast.LENGTH_SHORT).show();
            correctResponse = 0;
        }
        return correctResponse;
    }


    public void submitResponses(View view) {
            displayResponses(scoreTotal());
            String message = "Your total number of correct responses is: " + correctResponse + " and " + incorrectResponse +" incorrect responses";
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
