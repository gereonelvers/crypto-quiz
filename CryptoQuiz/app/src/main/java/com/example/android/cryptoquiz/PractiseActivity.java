package com.example.android.cryptoquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PractiseActivity extends AppCompatActivity {

    // This activity serves as the "Learning resources" section of the app. It will include information and links to resources, encouraging the user to learn more
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_practise);
        Toolbar myToolbar = findViewById(R.id.actionBar);
        myToolbar.setTitle(R.string.practise_toolbar_title);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.testmenu, menu);
        return true;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);}
        return true;
    }


public void question1(View v){
    Intent intent = new Intent(getApplicationContext(), question1.class);
    String nameString = getIntent().getStringExtra("name");
    intent.putExtra("name", nameString);
    intent.putExtra("practise", true);
    startActivity(intent);
}


    public void question2(View v){
        Intent intent = new Intent(getApplicationContext(), question2.class);
        String nameString = getIntent().getStringExtra("name");
        intent.putExtra("name", nameString);
        intent.putExtra("practise", true);
        startActivity(intent);
    }

    public void question3(View v){
        Intent intent = new Intent(getApplicationContext(), question3.class);
        String nameString = getIntent().getStringExtra("name");
        intent.putExtra("name", nameString);
        intent.putExtra("practise", true);
        startActivity(intent);
    }

    public void question4(View v){
        Intent intent = new Intent(getApplicationContext(), question4.class);
        String nameString = getIntent().getStringExtra("name");
        intent.putExtra("name", nameString);
        intent.putExtra("practise", true);
        startActivity(intent);
    }

    public void question5(View v){
        Intent intent = new Intent(getApplicationContext(), question5.class);
        String nameString = getIntent().getStringExtra("name");
        intent.putExtra("name", nameString);
        intent.putExtra("practise", true);
        startActivity(intent);
    }

    public void question6(View v){
        Intent intent = new Intent(getApplicationContext(), question6.class);
        String nameString = getIntent().getStringExtra("name");
        intent.putExtra("name", nameString);
        intent.putExtra("practise", true);
        startActivity(intent);
    }

    public void question7(View v){
        Intent intent = new Intent(getApplicationContext(), question7.class);
        String nameString = getIntent().getStringExtra("name");
        intent.putExtra("name", nameString);
        intent.putExtra("practise", true);
        startActivity(intent);
    }

    public void question8(View v){
        Intent intent = new Intent(getApplicationContext(), question8.class);
        String nameString = getIntent().getStringExtra("name");
        intent.putExtra("name", nameString);
        intent.putExtra("practise", true);
        startActivity(intent);
    }

    public void question9(View v){
        Intent intent = new Intent(getApplicationContext(), question9.class);
        String nameString = getIntent().getStringExtra("name");
        intent.putExtra("name", nameString);
        intent.putExtra("practise", true);
        startActivity(intent);
    }

    public void question10(View v){
        Intent intent = new Intent(getApplicationContext(), question10.class);
        String nameString = getIntent().getStringExtra("name");
        intent.putExtra("name", nameString);
        intent.putExtra("practise", true);
        startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

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

}
