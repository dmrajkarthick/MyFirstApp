package com.example.rkarthic.myfirstapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    MediaPlayer ourSong;

    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.splash);
        ourSong = MediaPlayer.create(Splash.this, R.raw.gunshot);

        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean music = getPrefs.getBoolean("checkbox", true);
        if(music)
            ourSong.start();

        Thread timer = new Thread(){
          public void run(){
              try
              {
                  sleep(2000);
              }catch(InterruptedException e)
              {
                  e.printStackTrace();
              }finally
              {
                  Intent openStartingPoint = new Intent("com.example.rkarthic.MENU");
                  startActivity(openStartingPoint);
              }
          }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ourSong.release();
        finish();      // closes the splash activity and destroys it forever.
    }

}
