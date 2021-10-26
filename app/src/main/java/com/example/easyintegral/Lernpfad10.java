package com.example.easyintegral;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class Lernpfad10 extends Activity {
    private ImageButton soundbutton;
    private ImageButton nextbutton;
    private ImageButton zurückbutton;
    private MediaPlayer mediaPlayer;
    private WebView webView;
    private Animation shake;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.lp10);

        webView = (WebView) findViewById(R.id.web);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/geogebra.html");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(false);
        soundbutton = (ImageButton)findViewById(R.id.zehnterton);
        nextbutton = (ImageButton)findViewById(R.id.weiterzehn);
        zurückbutton = (ImageButton)findViewById(R.id.zurückzehn);
        shake = AnimationUtils.loadAnimation(Lernpfad10.this,R.anim.shakeanimation);
        soundbutton.startAnimation(shake);


        soundbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && mediaPlayer.isPlaying() ) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(Lernpfad10.this,R.raw.lp10);
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

                Intent i = new Intent(Lernpfad10.this,Lernpfad11.class);
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
                Intent i = new Intent(Lernpfad10.this,Lernpfad9.class);
                startActivity(i);
                Log.e("Test","intent gestartet");
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
