package com.example.android.cryptoquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LearningResourcesActivity extends AppCompatActivity {

    // this activity will function as the "Sources" section of the app.
    // Sources that still need to be included:
    // - Video Background
    // - Crypto logo
    // Fair use disclaimer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_resources);
    }

    public void media1(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://www.reddit.com/r/bitcoin"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }

    public void media2(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://coinmarketcap.com/"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }



    public void media3(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("http://bitcoin.org/"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }


    public void media4(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://www.reddit.com/r/CryptoCurrency/"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }



    public void media5(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://www.lightning.network"));
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
