package com.example.easyintegral;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class Lernpfad4 extends Activity {
    private ImageButton soundbutton4;
    private ImageButton nextbutton4;
    private ImageButton zurückbutton4;
    private MediaPlayer mediaPlayer4;
    private ImageView funktionf;
    private Animation shake4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.lp4);
         shake4 = AnimationUtils.loadAnimation(this,R.anim.shakeanimation);
        nextbutton4 = (ImageButton) findViewById(R.id.weitervier);
        zurückbutton4= (ImageButton) findViewById(R.id.zurückvier);
        soundbutton4 = (ImageButton) findViewById(R.id.vierterton);
        funktionf = (ImageView) findViewById(R.id.formel5);
        soundbutton4.startAnimation(shake4);
        funktionf.animate().alpha(0f).setDuration(0);

        CountDownTimer formel5countdown = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                funktionf.animate().alpha(1f).setDuration(2000);
            }
        };


        soundbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer4 != null && mediaPlayer4.isPlaying() ) {
                    mediaPlayer4.stop();
                    mediaPlayer4.release();
                }
                soundbutton4.clearAnimation();
                mediaPlayer4 = MediaPlayer.create(Lernpfad4.this,R.raw.lp4);
                mediaPlayer4.start();
                formel5countdown.start();
                mediaPlayer4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        nextbutton4.startAnimation(shake4);
                    }
                });

            }
        });
        zurückbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer4 != null && mediaPlayer4.isPlaying() ) {
                    mediaPlayer4.stop();
                    mediaPlayer4.release();
                }
                soundbutton4.clearAnimation();
                Intent e = new Intent(Lernpfad4.this,Lernpfad3.class);
                startActivity(e);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                nextbutton4.clearAnimation();

            }
        });

        nextbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer4 != null && mediaPlayer4.isPlaying() ) {
                    mediaPlayer4.stop();
                    mediaPlayer4.release();
                }
                soundbutton4.clearAnimation();
                Intent e = new Intent(Lernpfad4.this,Lernpfad5.class);
                startActivity(e);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                nextbutton4.clearAnimation();
            }
        });


    }
}
