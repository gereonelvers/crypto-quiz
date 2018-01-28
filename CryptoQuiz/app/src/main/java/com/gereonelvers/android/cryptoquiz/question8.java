package com.gereonelvers.android.cryptoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class question8 extends AppCompatActivity {

    String answerInput;
    boolean hasAnswered = false;
    private static final int TIME_INTERVAL = 2000;
    private long mSkipPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slidein, R.anim.slideout);
        setContentView(R.layout.activity_question8);
    }

    public void nextQuestion(View v){
        if (!hasAnswered){
        EditText answer = findViewById(R.id.answerInput);
        answerInput = answer.getText().toString();
        if(answerInput.equals("")){
            if(mSkipPressed + TIME_INTERVAL > System.currentTimeMillis()){
            answer.setText("Blockchain");
            answer.setEnabled(false);
            answer.setFocusable(false);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            answer.setTextColor(getResources().getColor(R.color.correctAnswer));
            Button nextButton = findViewById(R.id.nextButton);
            nextButton.setText(R.string.nextButton);
            hasAnswered = true;}
            else{
                Toast.makeText(getBaseContext(), R.string.skipInput, Toast.LENGTH_SHORT).show();
            }
            mSkipPressed = System.currentTimeMillis();
        }
        else {

        answer.setText("Blockchain");
        answer.setEnabled(false);
        answer.setFocusable(false);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        answer.setTextColor(getResources().getColor(R.color.correctAnswer));
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setText(R.string.nextButton);
        hasAnswered = true;}}

        else {
            Intent intent = new Intent(getApplicationContext(), question9.class);
            int score = scoreCalc();
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }

    public int scoreCalc(){
        int score = getIntent().getIntExtra("score", 0);
        String answerString = answerInput.toLowerCase();
        if (answerString.contains("blockchain")) {
            score = score + 2;
        }
        else if(answerString.contains("block chain")){
            score = score + 2;
        }
        return score;
    }

}