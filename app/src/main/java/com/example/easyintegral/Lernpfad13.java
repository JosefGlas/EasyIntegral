package com.example.easyintegral;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class Lernpfad13 extends Activity {
    private ImageButton nextbutton;
    private ImageButton zurückbutton;
    private Animation shake;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.lp13);
        nextbutton = (ImageButton) findViewById(R.id.weiterdreizehn);
        zurückbutton= (ImageButton) findViewById(R.id.zurückdreizehn);
        shake = AnimationUtils.loadAnimation(this, R.anim.shakeanimation);
        CountDownTimer countDownTimer = new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                nextbutton.startAnimation(shake);
            }
        }.start();

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextbutton.clearAnimation();
                Intent i = new Intent(Lernpfad13.this,Lernpfad14.class);
                startActivity(i);
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);

            }
        });
        zurückbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextbutton.clearAnimation();
                Intent i = new Intent(Lernpfad13.this,Lernpfad12.class);
                startActivity(i);
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);

            }
        });
     }
}
