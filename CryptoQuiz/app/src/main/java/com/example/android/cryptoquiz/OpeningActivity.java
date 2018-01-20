package com.example.android.cryptoquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

public class OpeningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opening_activity);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        String name = pref.getString("name", "");
        // Only run this Activity if username input is empty -> First time user runs the App
        if (name.equals("")) {
            final VideoView videoview = findViewById(R.id.backgroundVideo);
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.testflipped);
            videoview.setVideoURI(uri);
            videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    videoview.start();
                }
            });
            videoview.start();
        }
        // Move directly to the Main menu
        else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);

        }
    }

    // Make sure the Background restarts when resuming the App
    @Override
    public void onResume() {
        super.onResume();
        final VideoView videoview = findViewById(R.id.backgroundVideo);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.testflipped);
        videoview.setVideoURI(uri);
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoview.start();
            }
        });
        videoview.start();
    }

    // Change layout on orientation change
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.opening_activity_rotated);
            final VideoView videoview = findViewById(R.id.backgroundVideo);
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.test);
            videoview.setVideoURI(uri);
            videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    videoview.start();
                }
            });
            videoview.start();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.opening_activity);
            final VideoView videoview = findViewById(R.id.backgroundVideo);
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.testflipped);
            videoview.setVideoURI(uri);
            videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    videoview.start();
                }
            });
            videoview.start();
        }
    }


    // If the user has input a name and starts this method, start the main menu. Otherwise show toast reminding them
    public void startMainMenu(View v) {
        EditText name = findViewById(R.id.nameInput);
        String nameString = name.getText().toString();
        if (nameString.equals("")) {
            Toast.makeText(getApplicationContext(), R.string.nameMissing, Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("name", nameString);
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("name", nameString);
            editor.apply();
            startActivity(intent);
        }


    }

}
