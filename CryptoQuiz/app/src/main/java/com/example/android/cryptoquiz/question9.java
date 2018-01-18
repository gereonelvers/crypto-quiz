package com.example.android.cryptoquiz;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class question9 extends AppCompatActivity {

    Boolean answer1 = false;
    Boolean answer2 = false;
    Boolean answer3 = false;
    Boolean answer4 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slidein, R.anim.slideout);
        setContentView(R.layout.activity_question9);
        Boolean practiseMode = getIntent().getBooleanExtra("practise", false);
        if (practiseMode) {
            Button nextButton = findViewById(R.id.nextButton);
            nextButton.setText(R.string.back);
            TextView answer2TV = findViewById(R.id.answer2);
            answer2TV.setTextColor(getResources().getColor(R.color.correctAnswer));
            TextView answer4TV = findViewById(R.id.answer4);
            answer4TV.setTextColor(getResources().getColor(R.color.correctAnswer));

        }
    }

    public void nextQuestion(View v) {
        Boolean practiseMode = getIntent().getBooleanExtra("practise", false);
        if (!practiseMode) {
            Intent intent = new Intent(getApplicationContext(), question10.class);
            int score = scoreCalc();
            intent.putExtra("score", score);
            startActivity(intent);
        } else {
            Intent intent = new Intent(getApplicationContext(), PractiseActivity.class);
            startActivity(intent);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void answer1bool(View v) {
        Boolean practiseMode = getIntent().getBooleanExtra("practise", false);
        TextView answer1TV = findViewById(R.id.answer1);

        if (!practiseMode) {
            if (!answer1) {
                answer1TV.setTextColor(getResources().getColor(R.color.correctAnswer));
                answer1 = true;
            } else {
                answer1TV.setTextColor(getResources().getColor(R.color.black));
                answer1 = false;
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void answer2bool(View v) {
        Boolean practiseMode = getIntent().getBooleanExtra("practise", false);
        TextView answer2TV = findViewById(R.id.answer2);

        if (!practiseMode) {
            if (!answer2) {
                answer2TV.setTextColor(getResources().getColor(R.color.correctAnswer));
                answer2 = true;
            } else {
                answer2TV.setTextColor(getResources().getColor(R.color.black));
                answer2 = false;
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void answer3bool(View v) {
        Boolean practiseMode = getIntent().getBooleanExtra("practise", false);
        TextView answer3TV = findViewById(R.id.answer3);

        if (!practiseMode) {
            if (!answer3) {
                answer3TV.setTextColor(getResources().getColor(R.color.correctAnswer));
                answer3 = true;
            } else {
                answer3TV.setTextColor(getResources().getColor(R.color.black));
                answer3 = false;
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void answer4bool(View v) {
        Boolean practiseMode = getIntent().getBooleanExtra("practise", false);
        TextView answer4TV = findViewById(R.id.answer4);

        if (!practiseMode) {
            if (!answer4) {
                answer4TV.setTextColor(getResources().getColor(R.color.correctAnswer));
                answer4 = true;
            } else {
                answer4TV.setTextColor(getResources().getColor(R.color.black));
                answer4 = false;
            }
        }
    }

    public int scoreCalc() {
        int score = getIntent().getIntExtra("score", 0);
        if (answer1 && answer2 && answer3 && answer4) {
            score = score + 2;
        } else if (answer1 || answer2 || answer3 || answer4) {
            score++;
        }
        return score;
    }

}