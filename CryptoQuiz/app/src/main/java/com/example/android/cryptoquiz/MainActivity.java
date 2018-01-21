package com.example.android.cryptoquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {
    //This activity functions as the Apps main menu, giving the user access to the question quiz process, the options/help dialog and additional learning resources

private Toolbar mTopToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_main);
        mTopToolbar = findViewById(R.id.actionBar);
        setSupportActionBar(mTopToolbar);
        final VideoView videoview = findViewById(R.id.backgroundVideo);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.testflipped);
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
        videoview.start();
    }


    @Override
    public void onResume() {
        super.onResume();
        final VideoView videoview = findViewById(R.id.backgroundVideo);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.testflipped);
        videoview.setVideoURI(uri);
        videoview.start();
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoview.start();
            }
        });
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }
        return true;
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

        // Opens sources activity (Links to images etc.)
        if (id == R.id.sources) {
            Intent intent = new Intent(getApplicationContext(), SourcesActivity.class);
            String nameString = getIntent().getStringExtra("name");
            intent.putExtra("name", nameString);
            startActivity(intent);
            return true;
        }

        // Help/About Activity
        if (id == R.id.help_about) {
            Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
            String nameString = getIntent().getStringExtra("name");
            intent.putExtra("name", nameString);
            startActivity(intent);
            return true;
        }

        //Change name (Opens Opening_Activity
        if (id == R.id.change_name) {
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

    // Change layout based on screen rotation
    public void onConfigurationChanged(Configuration newConfig) {
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
            setContentView(R.layout.activity_main);
            Toolbar myToolbar = findViewById(R.id.actionBar);
            setSupportActionBar(myToolbar);
            TextView welcomeMessage = findViewById(R.id.welcomeMessage);
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
            String name = pref.getString("name", "there");
            welcomeMessage.setText(getString(R.string.welcomeMessage, name));
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

    public void startQuiz(View v) {
        Intent intent = new Intent(getApplicationContext(), question1.class);
        String nameString = getIntent().getStringExtra("name");
        intent.putExtra("name", nameString);
        startActivity(intent);
    }



    public void startLearningResources(View v) {
        Intent intent = new Intent(getApplicationContext(), LearningResourcesActivity.class);
        String nameString = getIntent().getStringExtra("name");
        intent.putExtra("name", nameString);
        startActivity(intent);
    }

}


