package com.example.easyintegral;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;

public class Lernpfad9 extends Activity {
    private ImageButton soundbutton;
    private ImageButton nextbutton;
    private ImageButton zurückbutton;
    private ImageView   scalepicture;
    private ImageView scalepicture2;
    private MediaPlayer mediaPlayer;
    private Animation shake;
    CountDownTimer countDownTimer;
    private ScaleAnimation scaleAnimationbig;
    private ScaleAnimation scaleAnimationsmall;
    private ImageView[] imageViews = new ImageView[10];
    private String   res =new String();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.lp9);

        soundbutton = (ImageButton) findViewById(R.id.neunterton);
        nextbutton = (ImageButton) findViewById(R.id.weiterneun);
        zurückbutton = (ImageButton)findViewById(R.id.zurückneun);
        scaleAnimationbig = new ScaleAnimation(1f,6f,1f,6f,Animation.RELATIVE_TO_SELF,1f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimationbig.setDuration(500);
        scaleAnimationsmall = new ScaleAnimation(6f,1f,6f,1f,Animation.RELATIVE_TO_SELF,1f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimationsmall.setDuration(500);
        for (int i=0;i<10;i++){
            int b = 91 + i;
            res="lp"+b;
            int resID = getResources().getIdentifier(res,"id",getOpPackageName());
            imageViews[i] = (ImageView) findViewById(resID);
            imageViews[i].animate().alpha(0f).setDuration(0);
        }
        imageViews[0].animate().alpha(1f).setDuration(0);
        scalepicture = (ImageView) findViewById(R.id.scalepicture1);
        scalepicture2 = (ImageView) findViewById(R.id.scalepicture2);
        shake = AnimationUtils.loadAnimation(this, R.anim.shakeanimation);
        soundbutton.startAnimation(shake);

        countDownTimer = new CountDownTimer(76000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished<50000){
                    imageViews[1].animate().alpha(1f).setDuration(1000);
                }
                if (millisUntilFinished<31000){
                    imageViews[2].animate().alpha(1f).setDuration(1000);
                }
                if(millisUntilFinished<26000){
                    imageViews[3].animate().alpha(1f).setDuration(1000);
                }
                if(millisUntilFinished<19000){
                    imageViews[4].animate().alpha(1f).setDuration(1000);
                }
                if(millisUntilFinished<16000){
                    imageViews[5].animate().alpha(1f).setDuration(1000);
                }
                if(millisUntilFinished<13000){
                    imageViews[6].animate().alpha(1f).setDuration(1000);
                }
                if(millisUntilFinished<10000){
                    imageViews[7].animate().alpha(1f).setDuration(1000);
                }
                if(millisUntilFinished<4000){
                    imageViews[8].animate().alpha(1f).setDuration(1000);
                }
            }

            @Override
            public void onFinish() {
                imageViews[9].animate().alpha(1f).setDuration(1000);
            }
        };


        soundbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && mediaPlayer.isPlaying() ) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(Lernpfad9.this,R.raw.lp9);
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
                        countDownTimer.cancel();}
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                soundbutton.clearAnimation();
                nextbutton.clearAnimation();

                Intent i = new Intent(Lernpfad9.this,Lernpfad10.class);
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
                    countDownTimer.cancel();
                    nextbutton.clearAnimation();
                }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                soundbutton.clearAnimation();
                nextbutton.clearAnimation();
                Intent i = new Intent(Lernpfad9.this,Lernpfad8.class);
                startActivity(i);
                Log.e("Test","intent gestartet");
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
        scalepicture.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    scalepicture.bringToFront();
                   scalepicture.startAnimation(scaleAnimationbig);
                   scaleAnimationbig.setFillAfter(true);
                   return true;
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    scalepicture2.clearAnimation();
                    scalepicture.startAnimation(scaleAnimationsmall);
                    scaleAnimationsmall.setFillAfter(true);
                    return true;

                }

                return false;

            }
        });

        scalepicture2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    scalepicture2.startAnimation(scaleAnimationbig);
                    scaleAnimationbig.setFillAfter(true);
                    scalepicture2.bringToFront();
                    return true;
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    scalepicture.clearAnimation();
                    scalepicture2.startAnimation(scaleAnimationsmall);
                    scaleAnimationsmall.setFillAfter(true);
                    return true;

                }
                return false;
            }
        });

    }
}
