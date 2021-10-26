package com.example.easyintegral;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import androidx.annotation.Nullable;

public class Lernpfad5 extends Activity {
    private ImageButton soundbutton5;
    private ImageButton nextbutton5;
    private ImageButton zurückbutton5;
    private MediaPlayer mediaPlayer5;
    private ImageButton plus;
    private ImageButton minus;
    private int clickcount = 0;
    private ImageView dreieck1;
    private ImageView dreieck2;
    private ImageView dreieck3;
    private ImageView dreieck4;
    private ImageSwitcher imageSwitcher;
    private ImageSwitcher formelswitcher;
    private Animation shake5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.lp5);
        imageSwitcher = (ImageSwitcher)findViewById(R.id.dreieck1);
        formelswitcher = (ImageSwitcher)findViewById(R.id.formelhalter);
        formelswitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this,R.anim.fadein);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.fadeout);
        formelswitcher.setInAnimation(in);
        imageSwitcher.setInAnimation(in);
        formelswitcher.setOutAnimation(out);
        imageSwitcher.setOutAnimation(out);

        imageSwitcher.setImageResource(R.drawable.dreieck);
        formelswitcher.setImageResource(R.drawable.dreieckformel1);

        soundbutton5 = (ImageButton) findViewById(R.id.fuenfterton);
        nextbutton5 = (ImageButton) findViewById(R.id.weiterfuenf);
        zurückbutton5 = (ImageButton) findViewById(R.id.zurückfuenf);
        plus = (ImageButton) findViewById(R.id.plus);
        minus = (ImageButton)findViewById(R.id.minus);
        shake5 = AnimationUtils.loadAnimation(this,R.anim.shakeanimation);
        soundbutton5.startAnimation(shake5);

        soundbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer5 != null && mediaPlayer5.isPlaying() ) {
                    mediaPlayer5.stop();
                    mediaPlayer5.release();
                }
                soundbutton5.clearAnimation();
                mediaPlayer5 = MediaPlayer.create(Lernpfad5.this,R.raw.lp5);
                mediaPlayer5.start();
                mediaPlayer5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        nextbutton5.startAnimation(shake5);
                    }
                });

            }
        });
        nextbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer5 != null && mediaPlayer5.isPlaying() ) {
                    mediaPlayer5.stop();
                    mediaPlayer5.release();
                }
                soundbutton5.clearAnimation();
                Intent i = new Intent(Lernpfad5.this,Lernpfad6.class);
                startActivity(i);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                nextbutton5.clearAnimation();
            }
        });

        zurückbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer5 != null && mediaPlayer5.isPlaying() ) {
                    mediaPlayer5.stop();
                    mediaPlayer5.release();
                }
                soundbutton5.clearAnimation();
                Intent i = new Intent(Lernpfad5.this,Lernpfad4.class);
                startActivity(i);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                nextbutton5.clearAnimation();
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickcount == 0){
                imageSwitcher.setImageResource(R.drawable.dreieck2);
                formelswitcher.setImageResource(R.drawable.dreieckformel2);
                clickcount=1;
                }else if (clickcount == 1){
                    imageSwitcher.setImageResource(R.drawable.dreieck3);
                    formelswitcher.setImageResource(R.drawable.dreieckformel3);
                    clickcount=2;
                }else if(clickcount==2){
                    imageSwitcher.setImageResource(R.drawable.dreieck4);
                    formelswitcher.setImageResource(R.drawable.dreieckformel4);
                    clickcount = 3;
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickcount ==1){
                    imageSwitcher.setImageResource(R.drawable.dreieck);
                    formelswitcher.setImageResource(R.drawable.dreieckformel1);
                    clickcount=0;
                }else if(clickcount==2){
                    imageSwitcher.setImageResource(R.drawable.dreieck2);
                    formelswitcher.setImageResource(R.drawable.dreieckformel2);
                    clickcount =1;
                }else if (clickcount ==3){
                    imageSwitcher.setImageResource(R.drawable.dreieck3);
                    formelswitcher.setImageResource(R.drawable.dreieckformel3);
                    clickcount =2;
                }
            }
        });
    }
}
