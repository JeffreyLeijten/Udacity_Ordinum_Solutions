package com.example.android.ordinumsolutions;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLocation(View view){
        Uri location = Uri.parse("geo:0,0?q="+getString(R.string.address));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void openWebsiste(View view){
        Uri webpage = Uri.parse("http:"+getString(R.string.website));
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(webIntent);
        }
    }

    public void sendMail(View view){
        Intent eMailIntent = new Intent(Intent.ACTION_SENDTO);
        eMailIntent.setData(Uri.parse("mailto:"));
        String[] addresses = new String[1];
        addresses[0] = getString(R.string.e_mail_address);
        eMailIntent.putExtra(Intent.EXTRA_EMAIL, addresses);
        if (eMailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(eMailIntent);
        }
    }

}
