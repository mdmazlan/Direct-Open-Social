package com.mdmazlan.directopensocial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_fb = findViewById(R.id.button_fb_id);
        Button button_ig = findViewById(R.id.button_ig_id);
        Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        button_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = openFacebook(MainActivity.this);
                vibrator.vibrate(30);
                startActivity(i);
            }
        });

        button_ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = openInstagram(MainActivity.this);
                vibrator.vibrate(30);
                startActivity(i);
            }
        });
    }
    // Facebook.....................................................................................

    private Intent openFacebook(MainActivity mainActivity) {
        try {
            mainActivity.getPackageManager()
                    .getPackageInfo("com.facebook.katana",0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/4"));// use profile or page ID....
        }catch (Exception e){
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/zuck")); // use username.....
        }
    }
    // Instagram.....................................................................................

    private Intent openInstagram(MainActivity mainActivity) {
        try {
            mainActivity.getPackageManager()
                    .getPackageInfo("com.instagram.android", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/zuck")); // use username.....
        }catch (Exception e){
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/zuck")); // use username.....
        }
    }
}