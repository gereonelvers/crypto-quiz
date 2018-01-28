package com.gereonelvers.android.cryptoquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SourcesActivity extends AppCompatActivity {

    // this activity will function as the "Sources" section of the app.
    // Sources that still need to be included:
    // - Video Background
    // - Crypto logo
    // Fair use disclaimer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sources);
    }

    public void media1(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("http://www.logo-designer.co/german-designer-envisions-logo-design-for-cryptocurrency/"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }

    public void media2(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://www.youtube.com/watch?v=iTTrOhEWM-k"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }



    public void media3(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://amazyble.com/products/anonymous-mask"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }


    public void media4(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://blockgeeks-assets.scdn7.secure.raxcdn.com/wp-content/uploads/2016/10/How-Smart-Contracts-Works-1.png"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }



    public void media5(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://coinmarketcap.com/currencies/digibyte/"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }

    public void media6(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://www.cryptocompare.com/media/1382769/segwit.png"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }

    public void media7(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://www.buybitcoinworldwide.com/img/goodicons/wallet2.png"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }



    public void media8(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://twitter.com/SatoshiLite"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }

    public void media9(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://antonopoulos.com/"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }

    public void media10(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("http://ablogaboutnothinginparticular.com/wp-content/uploads/2016/07/blockchain-1.jpg"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }

    public void media11(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://news.bitcoin.com/wp-content/uploads/2016/12/unicrypt.jpg"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }

    public void media12(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://fs.bitcoinmagazine.com/img/articles/understanding-the-lightning-network-part-creating-the-network-2.jpg"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }

    public void media13(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("http://www.bitcoinrollercoaster.com/images/no-fun-roller-coaster-guy.gif"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }

    public void media14(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("http://www.brainlesstales.com/images/misc/bitcoin-roller-coaster.gif"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }

    public void media15(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("http://www.brainlesstales.com/bitcoin-assets/images/fan-versions/2015-08-eOTOeyg.gif"));
        if (browser.resolveActivity(getPackageManager()) != null) {
            startActivity(browser);
        }
    }

    public void media16(View v){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse("https://media.giphy.com/media/xUOxeVWzTVwAnOm7m0/giphy.gif"));
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


