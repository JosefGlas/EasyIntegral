package com.example.easyintegral;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

public class Lernpfad6 extends Activity {
    private ImageButton soundbutton6;
    private ImageButton nextbutton6;
    private ImageButton zurückbutton6;
    private MediaPlayer mediaPlayer6;
    private ImageView trapezview;
    private ImageView trapezformel;
    private ImageView trapezrechnung;
    private Animation shake6 ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.lp6);


        soundbutton6 = (ImageButton) findViewById(R.id.sechsterton);
        nextbutton6 = (ImageButton) findViewById(R.id.weitersechs);
        zurückbutton6 = (ImageButton) findViewById(R.id.zurücksechs);
        trapezrechnung = (ImageView) findViewById(R.id.trapezrechnung);

        trapezview = (ImageView) findViewById(R.id.formel);
        trapezformel =(ImageView) findViewById(R.id.trapezformel);
        trapezformel.animate().alpha(0f).setDuration(0);
        trapezrechnung.animate().alpha(0f).setDuration(0);
        shake6 = AnimationUtils.loadAnimation(this,R.anim.shakeanimation);
        soundbutton6.startAnimation(shake6);
        nextbutton6.setEnabled(false);



        CountDownTimer countdownscale = new CountDownTimer(21000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                trapezformel.animate().alpha(1f).setDuration(1000);
                ScaleAnimation scale1 = new ScaleAnimation(1f,0.45f,1f,0.45f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f);
                scale1.setFillAfter(true);
                scale1.setDuration(1000);
                trapezview.startAnimation(scale1);
                trapezformel.animate().alpha(1f).setDuration(1000);
            }
        };

        CountDownTimer countdownrechnung = new CountDownTimer(37000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                trapezrechnung.animate().alpha(1f).setDuration(1000);
            }
        };




        nextbutton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer6 != null && mediaPlayer6.isPlaying() ) {
                    mediaPlayer6.stop();
                    mediaPlayer6.release();
                }
                soundbutton6.clearAnimation();
                nextbutton6.clearAnimation();
                Intent i = new Intent(Lernpfad6.this,Lernpfad7.class);
                startActivity(i);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });
        zurückbutton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer6 != null && mediaPlayer6.isPlaying() ) {
                    mediaPlayer6.stop();
                    mediaPlayer6.release();
                }
                soundbutton6.clearAnimation();
                nextbutton6.clearAnimation();
                Intent i = new Intent(Lernpfad6.this,Lernpfad5.class);
                startActivity(i);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        soundbutton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer6 != null && mediaPlayer6.isPlaying() ) {
                    mediaPlayer6.stop();
                    mediaPlayer6.release();
                }
                mediaPlayer6 = MediaPlayer.create(Lernpfad6.this,R.raw.lp6);
                mediaPlayer6.start();
                countdownrechnung.start();
                countdownscale.start();
                nextbutton6.setEnabled(true);
                soundbutton6.clearAnimation();
                mediaPlayer6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        nextbutton6.startAnimation(shake6);
                    }
                });
            }
        });



    }

    public void scaleView(View v, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(
                0.5f, 1f, // Start and end values for the X axis scaling
                1f, 1f, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 1f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(1000);
        v.startAnimation(anim);
    }
}
