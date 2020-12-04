package com.example.videoplaytube;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button btnleft, btnright, btnequal, btnstop;

    VideoView videoplayer;

    ListView videolist;



    int videocount = 0;

    String [] videopath = {"/storage/emulated/0/a/Video/beef.mp4", "/storage/emulated/0/a/Video/pizza.mp4", "/storage/emulated/0/a/Video/fried.mp4"};

    MediaPlayer mp;

    DisplayManager displayManager;
    Display [] presentationDisplays;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnleft = (Button)findViewById(R.id.btnleft);
        btnright = (Button)findViewById(R.id.btnright);
        btnequal = (Button)findViewById(R.id.btnequal);
        btnequal = (Button)findViewById(R.id.btnstop);

        videoplayer = (VideoView)findViewById(R.id.videoplayer);

        videoplayer.setVideoPath(videopath[videocount]);
        videoplayer.start();

        displayManager = (DisplayManager) getApplicationContext().getSystemService(Context.DISPLAY_SERVICE);
        presentationDisplays = displayManager.getDisplays(DisplayManager.DISPLAY_CATEGORY_PRESENTATION);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        videoplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                if(videocount==videopath.length) {
                    videocount = 0;
                } else {
                    videocount++;
                }
                videoplayer.stopPlayback();
                videoplayer.setVideoPath(videopath[videocount]);
                videoplayer.start();
            }
        });










    }

    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.btnleft:
                btnl();
                break;
            case R.id.btnright:
                btnr();
                break;
            case R.id.btnequal:
                btnre();
                break;
            case R.id.btnstop:
                btns();
                break;
        }

    }

    public void btnl() {

//        PlaybackParams pp = mp.getPlaybackParams();
//        mp.setPlaybackParams(pp);

        if(videocount==videopath.length) {
            videocount = 0;
        } else {
            videocount++;
        }

        videoplayer.canSeekBackward();
    }

    public void btnr() {

        if(videocount==videopath.length) {
            videocount = 0;
        } else {
            videocount++;
        }

        videoplayer.canSeekForward();
    }

    public void btnre() {

        if(videocount==videopath.length) {
            videocount = 0;
        } else {
            videocount++;
        }

        videoplayer.start();
    }

    public void btns() {

        if(videocount==videopath.length) {
            videocount = 0;
        } else {
            videocount++;
        }

        videoplayer.stopPlayback();
    }








}