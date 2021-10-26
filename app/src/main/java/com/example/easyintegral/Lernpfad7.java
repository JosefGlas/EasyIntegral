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

public class Lernpfad7 extends Activity {
    private ImageButton soundbutton;
    private ImageButton nextbutton;
    private ImageButton zurückbutton;
    private MediaPlayer mediaPlayer;
    private Animation shake;
    private ImageView obersumme;
    private ImageView untersumme;
    private CountDownTimer obercountdown;
    private CountDownTimer untercountdown;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.lp7);


        soundbutton = (ImageButton) findViewById(R.id.siebterton);
        nextbutton = (ImageButton) findViewById(R.id.weitersieben);
        zurückbutton = (ImageButton)findViewById(R.id.zurücksieben);
        untersumme =(ImageView) findViewById(R.id.untersumme);
        obersumme = (ImageView) findViewById(R.id.obersumme);
        untersumme.animate().alpha(0f).setDuration(0);
        obersumme.animate().alpha(0f).setDuration(0);

        shake = AnimationUtils.loadAnimation(this,R.anim.shakeanimation);
        soundbutton.startAnimation(shake);
        obercountdown = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                obersumme.animate().alpha(1f).setDuration(1000);
            }
        };
        untercountdown =new CountDownTimer(45000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                untersumme.animate().alpha(1f).setDuration(1000);
            }
        };

        soundbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && mediaPlayer.isPlaying() ) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                soundbutton.clearAnimation();
                mediaPlayer = MediaPlayer.create(Lernpfad7.this,R.raw.lp7);
                mediaPlayer.start();
                obercountdown.start();
                untercountdown.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        nextbutton.startAnimation(shake);
                    }
                });
            }
        });
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && mediaPlayer.isPlaying() ) {
                    try {
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                        mediaPlayer.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                soundbutton.clearAnimation();
                nextbutton.clearAnimation();
                Intent i = new Intent(Lernpfad7.this,Lernpfad8.class);
                startActivity(i);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

        zurückbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && mediaPlayer.isPlaying() ) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                soundbutton.clearAnimation();
                nextbutton.clearAnimation();
                Intent i = new Intent(Lernpfad7.this,Lernpfad6.class);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

    }
}
