package com.example.easyintegral;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class Lernpfad11 extends Activity {
    private ImageButton soundbutton;
    private ImageButton nextbutton;
    private ImageButton zurückbutton;
    private MediaPlayer mediaPlayer;
    private Animation shake;
    private ImageView grafik1;
    private ImageView grafik2;
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.lp11);
        soundbutton= (ImageButton) findViewById(R.id.elfterton);
        nextbutton = (ImageButton) findViewById(R.id.weiterelf);
        zurückbutton = (ImageButton) findViewById(R.id.zurückelf);

        shake = AnimationUtils.loadAnimation(this, R.anim.shakeanimation);
        soundbutton.startAnimation(shake);
        grafik1 = (ImageView) findViewById(R.id.UOS100);
        grafik2 =(ImageView) findViewById(R.id.tabelleuos);
        grafik2.animate().alpha(0f).setDuration(0);

        countDownTimer = new CountDownTimer(13000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                grafik1.animate().alpha(0f).setDuration(0);
                grafik2.animate().alpha(1f).setDuration(500);
            }
        };

        soundbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && mediaPlayer.isPlaying() ) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(Lernpfad11.this,R.raw.lp11);
                mediaPlayer.start();
                soundbutton.clearAnimation();
                countDownTimer.start();
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

                Intent i = new Intent(Lernpfad11.this,Lernpfad12.class);
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
                Intent i = new Intent(Lernpfad11.this,Lernpfad10.class);
                startActivity(i);
                Log.e("Test","intent gestartet");
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });



    }
}
