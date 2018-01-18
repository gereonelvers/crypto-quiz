package com.example.android.cryptoquiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    //This activity functions as the Apps main menu, giving the user access to the question quiz process, the options/help dialog and additional learning resources

    Boolean playingVideo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.actionBar);
        setSupportActionBar(myToolbar);
        final VideoView videoview = findViewById(R.id.backgroundVideo);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.testflipped);
        videoview.setVideoURI(uri);
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoview.start();
            }
        });
        TextView welcomeMessage = findViewById(R.id.welcomeMessage);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        String name = pref.getString("name", "there");
        welcomeMessage.setText(getString(R.string.welcomeMessage, name));
        if (savedInstanceState != null) {
            playingVideo = savedInstanceState.getBoolean("playingVideo");}
        if (playingVideo){
            videoview.start();
            }
        }


    @Override
    public void onResume(){
        super.onResume();
        final VideoView videoview = findViewById(R.id.backgroundVideo);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.testflipped);
        videoview.setVideoURI(uri);
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoview.start();
            }
        });
        if (playingVideo){
            videoview.start();
        }
        else {videoview.pause();}
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK) {
                Intent a = new Intent(Intent.ACTION_MAIN);
                a.addCategory(Intent.CATEGORY_HOME);
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(a);
        }
        return true;
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("playingVideo", playingVideo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.testmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Enables low resource mode (currently just disables video)
//        if (id == R.id.lowEnergyMode) {
//            VideoView videoView = findViewById(R.id.backgroundVideo);
//            if (videoView.isPlaying()){
//                Toast.makeText(MainActivity.this, "Video background paused to save resources", Toast.LENGTH_SHORT).show();
//                videoView.pause();
//                playingVideo = false;}
//
//            else {
//                videoView.start();
//                Toast.makeText(MainActivity.this, "Video background playback restarted", Toast.LENGTH_LONG).show();
//                playingVideo = true;}
//            return true;
//        }


        // Opens sources activity (Links to images etc.)
        if (id == R.id.sources){
            Intent intent = new Intent(getApplicationContext(), SourcesActivity.class);
            String nameString = getIntent().getStringExtra("name");
            intent.putExtra("name", nameString);
            startActivity(intent);
            return true;
        }

        if (id == R.id.help_about){
            Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
            String nameString = getIntent().getStringExtra("name");
            intent.putExtra("name", nameString);
            startActivity(intent);
            return true;
        }

        if (id == R.id.change_name){
            Intent intent = new Intent(getApplicationContext(), OpeningActivity.class);
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("name", "");
            editor.apply();
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_rotated);
            Toolbar myToolbar = findViewById(R.id.actionBar);
            setSupportActionBar(myToolbar);
            TextView welcomeMessage = findViewById(R.id.welcomeMessage);
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
            String name = pref.getString("name", "there");
            welcomeMessage.setText(getString(R.string.welcomeMessage, name));
            final VideoView videoview = findViewById(R.id.backgroundVideo);
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.test);
            videoview.setVideoURI(uri);
            videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    videoview.start();
                }
            });
            videoview.start();}
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_main);
            Toolbar myToolbar = findViewById(R.id.actionBar);
            setSupportActionBar(myToolbar);
            TextView welcomeMessage = findViewById(R.id.welcomeMessage);
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
            String name = pref.getString("name", "there");
            welcomeMessage.setText(getString(R.string.welcomeMessage, name));
            final VideoView videoview = findViewById(R.id.backgroundVideo);
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.testflipped);
            videoview.setVideoURI(uri);
            videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    videoview.start();
                }
            });
            videoview.start();}
    }

    public void startQuiz (View v) {
        Intent intent = new Intent(getApplicationContext(), question1.class);
        String nameString = getIntent().getStringExtra("name");
        intent.putExtra("name", nameString);
        startActivity(intent);
    }

    public void startPractise (View v) {
        Intent intent = new Intent(getApplicationContext(), PractiseActivity.class);
        String nameString = getIntent().getStringExtra("name");
        intent.putExtra("name", nameString);
        startActivity(intent);
    }

    public void startLearningResources (View v) {
        Intent intent = new Intent(getApplicationContext(), LearningResourcesActivity.class);
        String nameString = getIntent().getStringExtra("name");
        intent.putExtra("name", nameString);
        startActivity(intent);
    }

}


