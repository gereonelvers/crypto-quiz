package com.gereonelvers.android.cryptoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class question1 extends AppCompatActivity {

    boolean hasAnswered = false;
    String answerInput;
    private static final int TIME_INTERVAL = 2000;
    private long mSkipPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_question1);
    }

    public void nextQuestion(View v) {
        if (!hasAnswered) {
            EditText answer = findViewById(R.id.answerInput);
            answerInput = answer.getText().toString();
            if(answerInput.equals("")){
                if (mSkipPressed + TIME_INTERVAL > System.currentTimeMillis()){
                    answer.setText("Satoshi Nakamoto");
                    answer.setEnabled(false);
                    answer.setFocusable(false);
                    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                    answer.setTextColor(getResources().getColor(R.color.correctAnswer));
                    Button nextButton = findViewById(R.id.nextButton);
                    nextButton.setText(R.string.nextButton);
                    hasAnswered = true;
                }
                else{
                    Toast.makeText(getBaseContext(), R.string.skipInput, Toast.LENGTH_SHORT).show();
                }
                mSkipPressed = System.currentTimeMillis();
            }
            else{
            answer.setText("Satoshi Nakamoto");
            answer.setEnabled(false);
            answer.setFocusable(false);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            answer.setTextColor(getResources().getColor(R.color.correctAnswer));
            Button nextButton = findViewById(R.id.nextButton);
            nextButton.setText(R.string.nextButton);
            hasAnswered = true;}
        } else {
            int score = scoreCalc();
            Intent intent = new Intent(getApplicationContext(), question2.class);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }

    public int scoreCalc() {
        int score = 0;
        String answerString = answerInput.toLowerCase();
        if (answerString.contains("satoshi nakamoto")) {
            score = score + 2;
        } else if (answerString.contains("satoshi")) {
            score = score + 1;
        } else if (answerString.contains("nakamoto")) {
            score = score + 1;
        }
        return score;
    }

}
