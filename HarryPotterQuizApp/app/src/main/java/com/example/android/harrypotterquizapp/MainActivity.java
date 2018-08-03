package com.example.android.harrypotterquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int score = 0;
    private Spinner answer9a;
    private Spinner answer9b;
    private Spinner answer9c;
    private Spinner answer9d;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.characteristics_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        answer9a = (Spinner) findViewById(R.id.Answer9a);
        answer9a.setAdapter(adapter1);

        answer9b = (Spinner) findViewById(R.id.Answer9b);
        answer9b.setAdapter(adapter1);

        answer9c = (Spinner) findViewById(R.id.Answer9c);
        answer9c.setAdapter(adapter1);

        answer9d = (Spinner) findViewById(R.id.Answer9d);
        answer9d.setAdapter(adapter1);

    }

    public void submitAnswers(View v) {

        calculateScore();

        if (score < 1) {
            Toast.makeText(getApplicationContext(), "Have you ever seen the movies or read any of the books? Maybe this quiz isn't for you...", Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "Your score is: " + score, Toast.LENGTH_SHORT).show();
            if (score < 0)
                score = 0;

            return;
        }

        if (score == 15) {
            Toast.makeText(getApplicationContext(), "CONGRATULATIONS!!! You got the max score! You're a Harry Potter specialist! :)", Toast.LENGTH_LONG).show();
        } else if (score == 14)
            Toast.makeText(getApplicationContext(), "Congratulations! Only ONE answer wrong!", Toast.LENGTH_LONG).show();// You got "+ calculatePercentage() +"% of the answers right!

        else if (score < 14 && score > 11)
            Toast.makeText(getApplicationContext(), "Congratulations! You almost got there! You got " + calculatePercentage() + "% of the answers right!", Toast.LENGTH_LONG).show();

        else if (score < 12 && score > 8)
            Toast.makeText(getApplicationContext(), "Not bad :) You got " + calculatePercentage() + "% of the answers right!", Toast.LENGTH_LONG).show();

        else if (score < 9 && score > 5) {
            Toast.makeText(getApplicationContext(), "Maybe you should try again. You got " + calculatePercentage() + "% of the answers right!", Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "Tip: Check your spelling ;)", Toast.LENGTH_LONG).show();
        } else if (score < 6 && score > 2)
            Toast.makeText(getApplicationContext(), "Uhmmm... You got " + calculatePercentage() + "% of the answers right.", Toast.LENGTH_LONG).show();

        else
            Toast.makeText(getApplicationContext(), "Maybe this is not the quiz for you... You got " + calculatePercentage() + "% of the answers right.", Toast.LENGTH_LONG).show();

        score = 0;
    }

    private int calculatePercentage() {
        int finalScore = (score * 100) / 15;
        return finalScore;
    }

    private void calculateScore() {
        EditText answer1 = (EditText) findViewById(R.id.Answer1);
        String answ1 = answer1.getText().toString();
        String cleanedAnswer1 = cleanString(answ1);
        if (cleanedAnswer1.equals("muggles") || cleanedAnswer1.equals("muggle")) {
            score++;
        }

        EditText answer2 = (EditText) findViewById(R.id.Answer2);
        String answ2 = answer2.getText().toString();
        if (cleanString(answ2).equals("quidditch")) {
            score++;
        }

        RadioGroup answer3 = (RadioGroup) findViewById(R.id.Answer3);

        int checkedRadioButton1Id = answer3.getCheckedRadioButtonId();
        if (checkedRadioButton1Id == -1) {
            Toast.makeText(this, "Please select an option on question 3.", Toast.LENGTH_SHORT).show();
        } else {
            if (checkedRadioButton1Id == R.id.Answer3b) {
                score++;
            }
        }

        EditText answer4 = (EditText) findViewById(R.id.Answer4);
        String answ4 = answer4.getText().toString();
        if (cleanString(answ4).equals("hedwig")) {
            score++;
        }

        CheckBox answer5a = (CheckBox) findViewById(R.id.Answer5a);
        if (answer5a.isChecked())
            score--;
        CheckBox answer5b = (CheckBox) findViewById(R.id.Answer5b);
        if (answer5b.isChecked())
            score++;
        CheckBox answer5c = (CheckBox) findViewById(R.id.Answer5c);
        if (answer5c.isChecked())
            score++;
        CheckBox answer5d = (CheckBox) findViewById(R.id.Answer5d);
        if (answer5d.isChecked())
            score--;

        RadioGroup answer6 = (RadioGroup) findViewById(R.id.Answer6);
        int checkedRadioGroupButton2Id = answer6.getCheckedRadioButtonId();
        if (checkedRadioGroupButton2Id == -1) {
            Toast.makeText(this, "Please select an option on question 6.", Toast.LENGTH_SHORT).show();
        } else {
            if (checkedRadioGroupButton2Id == R.id.Answer6c)
                score++;
        }

        EditText answer7 = (EditText) findViewById(R.id.Answer7);
        String answ7 = answer7.getText().toString();
        if (cleanString(answ7).equals("hogwarts")) {
            score++;
        }

        CheckBox answer8a = (CheckBox) findViewById(R.id.Answer8a);
        if (answer8a.isChecked())
            score--;
        CheckBox answer8b = (CheckBox) findViewById(R.id.Answer8b);
        if (answer8b.isChecked())
            score++;
        CheckBox answer8c = (CheckBox) findViewById(R.id.Answer8c);
        if (answer8c.isChecked())
            score--;
        CheckBox answer8d = (CheckBox) findViewById(R.id.Answer8d);
        if (answer8d.isChecked())
            score--;
        CheckBox answer8e = (CheckBox) findViewById(R.id.Answer8e);
        if (answer8e.isChecked())
            score++;
        CheckBox answer8f = (CheckBox) findViewById(R.id.Answer8f);
        if (answer8f.isChecked())
            score--;


        if (answer9a.getSelectedItem().toString().equals("Bravery"))
            score++;

        if (answer9b.getSelectedItem().toString().equals("Resourcefulness"))
            score++;

        if (answer9c.getSelectedItem().toString().equals("Kindness"))
            score++;

        if (answer9d.getSelectedItem().toString().equals("Intelligence"))
            score++;

        EditText answer10 = (EditText) findViewById(R.id.Answer10);
        String answ10 = answer10.getText().toString();
        if (cleanString(answ10).equals("peeves")) {
            score++;
        }
    }

    private String cleanString(String answer) {
        return answer.toLowerCase().trim();
    }
}
