package com.example.easyintegral;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class Lernpfad1 extends Activity {
public ImageButton soundbutton;
public MediaPlayer mediaPlayer;
public boolean mpplaying =false ;
private ImageButton next1;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.lp1);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        soundbutton = (ImageButton) findViewById(R.id.soundimageButton);
        final Animation shake = AnimationUtils.loadAnimation(this,R.anim.shakeanimation);
        soundbutton.startAnimation(shake);
        mediaPlayer = MediaPlayer.create(this,R.raw.lp1);
        ImageView rundersee = (ImageView)findViewById(R.id.runderseeimageview);
        LinearLayout parent0 = (LinearLayout)findViewById(R.id.parent0);
        next1 = (ImageButton)findViewById(R.id.next1);
        next1.setEnabled(false);

       /* Transition starttransition = new Fade();
        starttransition.setDuration(20000);
        starttransition.addTarget(rundersee);
        TransitionManager.beginDelayedTransition(parent0,starttransition);
        rundersee.setVisibility(rundersee.VISIBLE);*/


        Animation myfadeinanimaion = AnimationUtils.loadAnimation(this,R.anim.fadein);
        rundersee.startAnimation(myfadeinanimaion);


        CheckBox checkBox1 = (CheckBox)findViewById(R.id.check1);
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.check2);
        CheckBox checkBox3 = (CheckBox)findViewById(R.id.check3);
        CheckBox checkBox4 = (CheckBox)findViewById(R.id.check4);

        ImageView formel1 = (ImageView)findViewById(R.id.formel1);
        ImageView formel2 = (ImageView)findViewById(R.id.formel2);
        ImageView formel3 = (ImageView)findViewById(R.id.formel3);
        ImageView formel4 = (ImageView)findViewById(R.id.formel4);


        RelativeLayout parent1 = (RelativeLayout)findViewById(R.id.parent1);
        RelativeLayout parent2 = (RelativeLayout)findViewById(R.id.parent2);
        RelativeLayout parent3 = (RelativeLayout)findViewById(R.id.parent3);
        RelativeLayout parent4 = (RelativeLayout)findViewById(R.id.parent4);
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBox1.setBackgroundColor(Color.RED);

                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void run() {
                        Transition transition = new Fade();
                        transition.setDuration(1000);
                        transition.addTarget(R.id.formel1);
                        transition.addTarget(R.id.check1);
                        TransitionManager.beginDelayedTransition(parent1,transition);
                        checkBox1.setVisibility(checkBox1.INVISIBLE);
                        formel1.setVisibility(formel1.INVISIBLE);
                    }
                }, 1000);

            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBox2.setBackgroundColor(Color.RED);

                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void run() {
                        Transition transition = new Fade();
                        transition.setDuration(1000);
                        transition.addTarget(R.id.formel2);
                        transition.addTarget(R.id.check2);
                        TransitionManager.beginDelayedTransition(parent2,transition);
                        checkBox2.setVisibility(checkBox2.INVISIBLE);
                        formel2.setVisibility(formel2.INVISIBLE);
                    }
                }, 1000);

            }
        });

        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBox4.setBackgroundColor(Color.RED);

                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void run() {
                        Transition transition = new Fade();
                        transition.setDuration(1000);
                        transition.addTarget(R.id.formel4);
                        transition.addTarget(R.id.check4);
                        TransitionManager.beginDelayedTransition(parent4,transition);
                        checkBox4.setVisibility(checkBox4.INVISIBLE);
                        formel4.setVisibility(formel4.INVISIBLE);
                    }
                }, 1000);

            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBox3.setBackgroundColor(Color.GREEN);

                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void run() {
                        Transition transition = new Fade();
                        transition.setDuration(1000);
                        transition.addTarget(R.id.formel2);
                        transition.addTarget(R.id.check2);
                        TransitionManager.beginDelayedTransition(parent2,transition);
                        checkBox2.setVisibility(checkBox2.INVISIBLE);
                        formel2.setVisibility(formel2.INVISIBLE);

                        transition.addTarget(R.id.formel4);
                        transition.addTarget(R.id.check4);
                        TransitionManager.beginDelayedTransition(parent4,transition);
                        checkBox4.setVisibility(checkBox4.INVISIBLE);
                        formel4.setVisibility(formel4.INVISIBLE);

                        transition.addTarget(R.id.formel1);
                        transition.addTarget(R.id.check1);
                        TransitionManager.beginDelayedTransition(parent1,transition);
                        checkBox1.setVisibility(checkBox1.INVISIBLE);
                        formel1.setVisibility(formel1.INVISIBLE);
                        next1.startAnimation(shake);



                    }
                }, 1000);

            }
        });

    }


    public void klicksoundbutton(View view) {
        next1.setEnabled(true);
        soundbutton = (ImageButton) findViewById(R.id.soundimageButton);
        soundbutton.clearAnimation();
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                LinearLayout fragelayout = (LinearLayout)findViewById(R.id.fragelayout);
                fragelayout.setVisibility(fragelayout.VISIBLE);
            }
        });


    }

    public void zurück1(View view) {
        mediaPlayer.stop();
        mediaPlayer.release();
        Intent b = new Intent(Lernpfad1.this,MainActivity.class);
        startActivity(b);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void next1(View view) {
        mediaPlayer.stop();
        mediaPlayer.release();
        Intent i = new Intent(Lernpfad1.this,Lernfad2.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
        next1.clearAnimation();


    }

}


