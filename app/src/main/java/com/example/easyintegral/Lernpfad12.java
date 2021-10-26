package com.example.easyintegral;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class Lernpfad12 extends Activity {
    private ImageButton soundbutton;
    private ImageButton nextbutton;
    private ImageButton zurückbutton;
    private MediaPlayer mediaPlayer;
    private Animation shake;
    private ImageView limus;
    private ImageView blind1;
    private ImageView blind2;
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.lp12);
        soundbutton = (ImageButton) findViewById(R.id.zwölfterton);
        nextbutton = (ImageButton) findViewById(R.id.weiterzwölf);
        zurückbutton = (ImageButton) findViewById(R.id.zurückzwölf);
        limus = (ImageView) findViewById(R.id.limus);
        shake = AnimationUtils.loadAnimation(this, R.anim.shakeanimation);
        soundbutton.startAnimation(shake);
        blind1 = (ImageView) findViewById(R.id.blind1);
        blind2 = (ImageView) findViewById(R.id.blind2);
        limus.animate().alpha(0f).setDuration(0);
        countDownTimer = new CountDownTimer(35000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                    if(millisUntilFinished<22000){
                        blind1.animate().alpha(0f).setDuration(200);
                    }
                    if(millisUntilFinished<10000){
                        blind2.animate().alpha(0f).setDuration(200);
                    }
            }

            @Override
            public void onFinish() {
                limus.animate().alpha(1f).setDuration(200);
            }
        };



        soundbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && mediaPlayer.isPlaying() ) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(Lernpfad12.this,R.raw.lp12);
                countDownTimer.start();
                mediaPlayer.start();
                soundbutton.clearAnimation();
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
                try {  if(mediaPlayer != null && mediaPlayer.isPlaying() ) {

                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                }
                } catch (Exception e) {
                    e.printStackTrace();
                }


                soundbutton.clearAnimation();
                nextbutton.clearAnimation();

                Intent i = new Intent(Lernpfad12.this,Lernpfad13.class);
                startActivity(i);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

        zurückbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {if(mediaPlayer != null && mediaPlayer.isPlaying() ) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    nextbutton.clearAnimation();
                }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                soundbutton.clearAnimation();
                nextbutton.clearAnimation();
                Intent i = new Intent(Lernpfad12.this,Lernpfad11.class);
                startActivity(i);
                Log.e("Test","intent gestartet");
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
    }
}
