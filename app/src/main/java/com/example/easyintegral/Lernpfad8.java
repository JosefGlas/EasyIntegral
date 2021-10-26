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

import androidx.annotation.Nullable;

public class Lernpfad8 extends Activity {
    private ImageButton soundbutton;
    private ImageButton nextbutton;
    private ImageButton zurückbutton;
    private MediaPlayer mediaPlayer;
    private Animation shake;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.lp8);

        nextbutton = (ImageButton) findViewById(R.id.weiteracht);
        zurückbutton = (ImageButton)findViewById(R.id.zurückacht);
        shake = AnimationUtils.loadAnimation(Lernpfad8.this,R.anim.shakeanimation);
        countDownTimer = new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                nextbutton.startAnimation(shake);

            }
        };
        countDownTimer.start();

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextbutton.clearAnimation();
                Intent i = new Intent(Lernpfad8.this,Lernpfad9.class);
                startActivity(i);
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                countDownTimer.cancel();
            }
        });

        zurückbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextbutton.clearAnimation();
                Intent i = new Intent(Lernpfad8.this,Lernpfad7.class);
                startActivity(i);
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                countDownTimer.cancel();
            }
        });

    }


}
