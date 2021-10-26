package com.example.easyintegral;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    protected PowerManager.WakeLock mWakelock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        System.out.print("start");

        sendScroll();





    }


    public void Ersteklick(View view) {
          LinearLayout layout1 = (LinearLayout)findViewById(R.id.buttonholder1);
        LinearLayout layout2 = (LinearLayout)findViewById(R.id.buttonholder2);
        LinearLayout text = (LinearLayout) findViewById(R.id.starttext);
        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(-1, 0);
        lp1.weight=2;
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(-1,0);
        lp2.weight=0;
        text.setLayoutParams(lp2);
        layout1.setLayoutParams(lp1);
        layout2.setLayoutParams(lp1);
      // Intent i = new Intent(MainActivity.this,Lernpfad12.class);
      //  startActivity(i);
    }




    private void sendScroll() {
        ScrollView Scrollview = ((ScrollView) findViewById(R.id.erstesscrollview));

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Scrollview.smoothScrollBy(0,1);
            }
        },500,20);
    }

    @Override
    public void onBackPressed() {
        LinearLayout layout1 = (LinearLayout)findViewById(R.id.buttonholder1);
        LinearLayout layout2 = (LinearLayout)findViewById(R.id.buttonholder2);
        LinearLayout text = (LinearLayout) findViewById(R.id.starttext);
        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(-1, 0);
        lp1.weight=0;
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(-1,0);
        lp2.weight=4;
        text.setLayoutParams(lp2);
        layout1.setLayoutParams(lp1);
        layout2.setLayoutParams(lp1);
       sendScrollup();

    }
    private void sendScrollup() {
        ScrollView Scrollview = ((ScrollView) findViewById(R.id.erstesscrollview));

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Scrollview.smoothScrollBy(0,-1);
            }
        },500,30);
    }

    public void UmkehrundderDifferentiation(View view) {
        Toast.makeText(this, "Leider noch nicht verfügbar!",
                Toast.LENGTH_LONG).show();
    }

    public void Kombinationintegrationableitung(View view) {
        Toast.makeText(this, "Leider noch nicht verfügbar!",
                Toast.LENGTH_LONG).show();
    }

    public void RekonstruktionausÄnderungsraten(View view) {
        Toast.makeText(this, "Leider noch nicht verfügbar!",
                Toast.LENGTH_LONG).show();
    }

    public void FlächeninhalteunterFunktionsgraphen(View view) {
        Intent i = new Intent(MainActivity.this, Lernpfad1.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }


}