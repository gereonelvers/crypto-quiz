package com.gereonelvers.android.cryptoquiz;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class question7 extends AppCompatActivity {

    Boolean answer1 = false;
    Boolean answer2 = false;
    Boolean answer3 = false;
    Boolean answer4 = false;
    boolean hasAnswered = false;
    private static final int TIME_INTERVAL = 2000;
    private long mSkipPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slidein, R.anim.slideout);
        setContentView(R.layout.activity_question7);
    }

    public void nextQuestion(View v) {
        if (!hasAnswered) {
            if (!answer1 & !answer2 & !answer3 & !answer4){
                if (mSkipPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                    Button nextButton = findViewById(R.id.nextButton);
                    nextButton.setText(R.string.nextButton);
                    TextView answer3TV = findViewById(R.id.answer2);
                    answer3TV.setTextColor(getResources().getColor(R.color.correctAnswer));
                    hasAnswered = true;}
                    else{
                    Toast.makeText(getBaseContext(), R.string.skipSelect, Toast.LENGTH_SHORT).show();
                    }
                mSkipPressed = System.currentTimeMillis();
            }

            else {
            Button nextButton = findViewById(R.id.nextButton);
            nextButton.setText(R.string.nextButton);
            TextView answer3TV = findViewById(R.id.answer2);
            answer3TV.setTextColor(getResources().getColor(R.color.correctAnswer));
            hasAnswered = true;}
        } else {
            Intent intent = new Intent(getApplicationContext(), question8.class);
            int score = scoreCalc();
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void answer1bool(View v) {
        TextView answer1TV = findViewById(R.id.answer1);
        TextView answer2TV = findViewById(R.id.answer2);
        TextView answer3TV = findViewById(R.id.answer3);
        TextView answer4TV = findViewById(R.id.answer4);
        if (!hasAnswered) {
            if (!answer1) {
                answer1TV.setTextColor(getResources().getColor(R.color.selectedColor));
                answer2TV.setTextColor(getResources().getColor(R.color.black));
                answer3TV.setTextColor(getResources().getColor(R.color.black));
                answer4TV.setTextColor(getResources().getColor(R.color.black));
                answer1 = true;
                answer2 = false;
                answer3 = false;
                answer4 = false;
            } else {
                answer1TV.setTextColor(getResources().getColor(R.color.black));
                answer1 = false;
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void answer2bool(View v) {
        TextView answer1TV = findViewById(R.id.answer1);
        TextView answer2TV = findViewById(R.id.answer2);
        TextView answer3TV = findViewById(R.id.answer3);
        TextView answer4TV = findViewById(R.id.answer4);

        if (!hasAnswered) {
            if (!answer2) {
                answer2TV.setTextColor(getResources().getColor(R.color.selectedColor));
                answer1TV.setTextColor(getResources().getColor(R.color.black));
                answer3TV.setTextColor(getResources().getColor(R.color.black));
                answer4TV.setTextColor(getResources().getColor(R.color.black));
                answer2 = true;
                answer1 = false;
                answer3 = false;
                answer4 = false;
            } else {
                answer2TV.setTextColor(getResources().getColor(R.color.black));
                answer2 = false;
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void answer3bool(View v) {
        TextView answer1TV = findViewById(R.id.answer1);
        TextView answer2TV = findViewById(R.id.answer2);
        TextView answer3TV = findViewById(R.id.answer3);
        TextView answer4TV = findViewById(R.id.answer4);
        if (!hasAnswered) {
            if (!answer3) {
                answer3TV.setTextColor(getResources().getColor(R.color.selectedColor));
                answer2TV.setTextColor(getResources().getColor(R.color.black));
                answer1TV.setTextColor(getResources().getColor(R.color.black));
                answer4TV.setTextColor(getResources().getColor(R.color.black));
                answer3 = true;
                answer2 = false;
                answer1 = false;
                answer4 = false;
            } else {
                answer3TV.setTextColor(getResources().getColor(R.color.black));
                answer3 = false;
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void answer4bool(View v) {
        TextView answer1TV = findViewById(R.id.answer1);
        TextView answer2TV = findViewById(R.id.answer2);
        TextView answer3TV = findViewById(R.id.answer3);
        TextView answer4TV = findViewById(R.id.answer4);
        if (!hasAnswered) {
            if (!answer4) {
                answer4TV.setTextColor(getResources().getColor(R.color.selectedColor));
                answer2TV.setTextColor(getResources().getColor(R.color.black));
                answer3TV.setTextColor(getResources().getColor(R.color.black));
                answer1TV.setTextColor(getResources().getColor(R.color.black));
                answer4 = true;
                answer2 = false;
                answer3 = false;
                answer1 = false;
            } else {
                answer4TV.setTextColor(getResources().getColor(R.color.black));
                answer4 = false;
            }
        }
    }

    public int scoreCalc() {
        int score = getIntent().getIntExtra("score", 0);
        if (answer2) {
            score++;
        }
        return score;
    }

}