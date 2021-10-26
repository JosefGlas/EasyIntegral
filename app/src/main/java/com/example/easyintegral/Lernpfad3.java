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

import java.sql.Time;

public class Lernpfad3 extends Activity {
    private ImageButton soundbutton3;
    private ImageButton nextbutton3;
    private ImageButton zurückbutton3;
    private MediaPlayer mediaPlayer3;
    private ImageView krummlsee;
   private  Animation shake2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lp3);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
         soundbutton3 = (ImageButton)findViewById(R.id.dritterton);
       krummlsee = (ImageView)findViewById(R.id.krummlseeBild);
       nextbutton3 = (ImageButton)findViewById(R.id.weiterdrei);
       zurückbutton3 = (ImageButton)findViewById(R.id.zurückdrei);
       krummlsee.animate().alpha(0f).setDuration(0);
        soundbutton3.setOnClickListener(sounbutton3listener);
        zurückbutton3.setOnClickListener(zurück3listener);
        nextbutton3.setOnClickListener(next3listener);
         shake2 = AnimationUtils.loadAnimation(this,R.anim.shakeanimation);
            soundbutton3.startAnimation(shake2);
        nextbutton3.setEnabled(false);

    }

     CountDownTimer imageContdown = new CountDownTimer(21000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            krummlsee.animate().alpha(1f).setDuration(2000);
        }
    };


    View.OnClickListener sounbutton3listener = new View.OnClickListener() {
       @Override
        public void onClick(View v) {
           if(mediaPlayer3 != null && mediaPlayer3.isPlaying()) {
               mediaPlayer3.stop();
               mediaPlayer3.release();
           }
            soundbutton3.clearAnimation();
           mediaPlayer3 = MediaPlayer.create(Lernpfad3.this, R.raw.lp3);
            mediaPlayer3.start();
            imageContdown.start();
            nextbutton3.setEnabled(true);
            mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    nextbutton3.startAnimation(shake2);
                }
            });



        }
    };
    View.OnClickListener next3listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mediaPlayer3 != null && mediaPlayer3.isPlaying()) {
                mediaPlayer3.stop();
                mediaPlayer3.release();
            }
            soundbutton3.clearAnimation();
            Intent d = new Intent(Lernpfad3.this,Lernpfad4.class);
            startActivity(d);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            nextbutton3.clearAnimation();

        }
    };
    View.OnClickListener zurück3listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mediaPlayer3 != null && mediaPlayer3.isPlaying() ) {
                mediaPlayer3.stop();
                mediaPlayer3.release();
            }
            soundbutton3.clearAnimation();
            Intent c = new Intent(Lernpfad3.this,Lernfad2.class);
            startActivity(c);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            nextbutton3.clearAnimation();

        }
    };


}
