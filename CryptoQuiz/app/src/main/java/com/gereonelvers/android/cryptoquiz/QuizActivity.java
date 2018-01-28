package com.gereonelvers.android.cryptoquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class QuizActivity extends AppCompatActivity {


    // This is the end screen. It will calculate the end result the user achieved and display an accurate image
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        // Get score and name
        int score = getIntent().getIntExtra("score", 0);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        String name = pref.getString("name", "");
        // Set score and name into TextViews
        TextView congrats = findViewById(R.id.congratsText);
        congrats.setText(getString(R.string.congrats, name));
        TextView scoreView = findViewById(R.id.score);
        scoreView.setText(getString(R.string.score, score));
        final VideoView videoview = findViewById(R.id.video);

        // Dynamic VideoView background based on the score the user achieved
        if(score <= 5){
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rcdownvid);
        videoview.setVideoURI(uri);
        congrats.setText(getString(R.string.badScore, name));}
        else if (score <= 10) {
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rcupdown);
            videoview.setVideoURI(uri);
        }
        else if (score <= 15) {
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rcupvid);
            videoview.setVideoURI(uri);
        }
        else {
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rcupfast);
            videoview.setVideoURI(uri);
        }
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoview.start();
            }
        });
        videoview.start();
    }

    // Custom Back button behaviour to make the questions inaccessible, so the user can't go back and change answers
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);}
            return true;
        }

    @Override
    public void onResume() {
        super.onResume();
        final VideoView videoview = findViewById(R.id.video);
        int score = getIntent().getIntExtra("score", 0);
        // Dynamic VideoView background based on the score the user achieved
        if(score <= 5){
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rcdownvid);
            videoview.setVideoURI(uri);}
        else if (score <= 10) {
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rcupdown);
            videoview.setVideoURI(uri);
        }
        else if (score <= 15) {
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rcupvid);
            videoview.setVideoURI(uri);
        }
        else {
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rcupfast);
            videoview.setVideoURI(uri);
        }
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoview.start();
            }
        });
        videoview.start();
    }

    public void back(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        }

    public void practise(View v){
        Intent intent = new Intent(getApplicationContext(), LearningResourcesActivity.class);
        startActivity(intent);
    }

    public void share(View v){
        int score = getIntent().getIntExtra("score", 0);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        String scoreString = Integer.toString(score);
        sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.shareText, scoreString));
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.shareTitle)));

    }


    }
