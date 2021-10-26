package com.example.easyintegral;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class Lernfad2 extends Activity {
    private boolean klickcount = false;
    public ImageButton soundbutton2;
    public MediaPlayer mediaPlayer2;
    private ImageButton next2;
    private CountDownTimer countDownTimer;
    private CountDownTimer countDownTimer2;


    private int zeit=0;
    private Handler zeithandler = new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lp2);
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        TextView fragelayout2 = (TextView)findViewById(R.id.fragelayout2);
        TextView antwortlayout2 = (TextView)findViewById(R.id.antwortlayout2);
        antwortlayout2.animate().alpha(0f).setDuration(0);
        fragelayout2.bringToFront();
        ImageView geofiguren = (ImageView)findViewById(R.id.geofiguren);
        geofiguren.animate().alpha(0f).setDuration(0);
        next2 = (ImageButton) findViewById(R.id.next2);

        float density  = getResources().getDisplayMetrics().density;
        int dpHeight = (int) ( outMetrics.heightPixels / density);
       int dpWidth  = (int) (outMetrics.widthPixels / density);
        Log.e("höhe", Integer.toString(dpHeight));
        Log.e("breite", Integer.toString(dpWidth));
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // soundbutton2 = (ImageButton) findViewById(R.id.soundimageButton2);
        final Animation shake = AnimationUtils.loadAnimation(this,R.anim.shakeanimation);

//        soundbutton2.startAnimation(shake);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.runderseesound);
        ImageView rundersee = (ImageView)findViewById(R.id.runderseeimageview);

        countDownTimer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                next2.startAnimation(shake);
            }
        }.start();

        countDownTimer2 = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                next2.startAnimation(shake);
            }
        };


    }

    public void next2(View view) {
        if (!(klickcount)) {
            TextView fragelayout2 = (TextView) findViewById(R.id.fragelayout2);
            RelativeLayout parent00 = (RelativeLayout) findViewById(R.id.parent00);
            TextView antwortlayout2 = (TextView) findViewById(R.id.antwortlayout2);
            fragelayout2.animate().alpha(0f).setDuration(1000);
            antwortlayout2.animate().alpha(1f).setDuration(2000);
            antwortlayout2.bringToFront();
            ImageView geofiguren = (ImageView)findViewById(R.id.geofiguren);
            geofiguren.animate().alpha(1f).setDuration(2000);
            geofiguren.bringToFront();
            klickcount = true;
            next2.clearAnimation();
            countDownTimer2.start();

        } else if (klickcount) {
            Intent z = new Intent(Lernfad2.this, Lernpfad3.class);
            startActivity(z);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            next2.clearAnimation();

        }


    }

    public void zurück2(View view) {
        if (!(klickcount)) {
            Intent b = new Intent(Lernfad2.this,Lernpfad1.class);
            startActivity(b);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            klickcount = true;
            next2.clearAnimation();
        }else if (klickcount) {
            TextView fragelayout2 = (TextView) findViewById(R.id.fragelayout2);
            RelativeLayout parent00 = (RelativeLayout) findViewById(R.id.parent00);
            TextView antwortlayout2 = (TextView) findViewById(R.id.antwortlayout2);
            fragelayout2.animate().alpha(1f).setDuration(2000);
            antwortlayout2.animate().alpha(0f).setDuration(2000);
            fragelayout2.bringToFront();
            ImageView geofiguren = (ImageView)findViewById(R.id.geofiguren);
            geofiguren.animate().alpha(0f).setDuration(2000);
            klickcount=false;
            next2.clearAnimation();
        }
    }


}
