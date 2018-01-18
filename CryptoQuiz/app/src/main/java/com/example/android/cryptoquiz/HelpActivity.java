package com.example.android.cryptoquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    // this activity serves as the "help/about" section of the app. It will include info about me as well as a support email. Layout is left minimal for best performance (might be beautified in a different commit)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_help);
    }

    public void sendMail(View v){
        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setData(Uri.parse("mailto:gereonelvers99@gmail.com"));
        email.putExtra(Intent.EXTRA_SUBJECT, "CryptoQuiz request");
        if (email.resolveActivity(getPackageManager()) != null) {
            startActivity(email);
        }
    }

    public void openGithub(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://www.github.com/gereonelvers"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }

    public void returnMainMenu (View v) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            String nameString = getIntent().getStringExtra("name");
            intent.putExtra("name", nameString);
            startActivity(intent);
        }

}