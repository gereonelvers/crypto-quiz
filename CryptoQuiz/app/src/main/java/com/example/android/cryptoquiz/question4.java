package com.example.android.cryptoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;


public class question4 extends AppCompatActivity {

    boolean hasAnswered = false;
    String answerInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slidein, R.anim.slideout);
        setContentView(R.layout.activity_question4);
        Boolean practiseMode = getIntent().getBooleanExtra("practise", false);
        if (practiseMode) {

        }
    }

    public void nextQuestion(View v){
        if (!hasAnswered){
            EditText answer = findViewById(R.id.answerInput);
            answerInput = answer.getText().toString();
            answer.setText("Segregated Witness (SegWit)");
            answer.setEnabled(false);
            answer.setFocusable(false);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            answer.setTextColor(getResources().getColor(R.color.correctAnswer));
            Button nextButton = findViewById(R.id.nextButton);
            nextButton.setText(R.string.nextButton);
            hasAnswered = true;
            }
        else {
            Intent intent = new Intent(getApplicationContext(), question5.class);
            int score = scoreCalc();
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }

    public int scoreCalc(){
        int score = getIntent().getIntExtra("score", 0);
        String answerString = answerInput.toLowerCase();
        if (answerString.contains("segregated witness")) {
            score = score + 2;
        }
        else if(answerString.contains("segwit")){
            score = score + 2;
        }
        return score;
    }

}