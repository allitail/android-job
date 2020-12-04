package com.example.videoplayer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.display.DisplayManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    Button btnleft, btnright, btnequal, btnstop;

    VideoView videoplayer;

    ListView videolist;


    int videocount = 0;

    int stop;


    String[] videopath = {"/storage/emulated/0/a/Video/beef.mp4", "/storage/emulated/0/a/Video/pizza.mp4", "/storage/emulated/0/a/Video/fried.mp4", "/storage/emulated/0/a/Video/a.mp4", "/storage/emulated/0/a/Video/b.mp4", "/storage/emulated/0/a/Video/c.mp4", "/storage/emulated/0/a/video/e.mp4"};

    MediaPlayer mp;

    DisplayManager displayManager;
    Display[] presentationDisplays;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        videoplayer = (VideoView) findViewById(R.id.videoplayer);

        videoplayer.setVideoPath(videopath[videocount]);
        videoplayer.start();

        videolist = (ListView) findViewById(R.id.videolist);
        videolist.setOnItemClickListener(this);

        Log.d("pathlength:", "" + videopath.length);


        displayManager = (DisplayManager) getApplicationContext().getSystemService(Context.DISPLAY_SERVICE);
        presentationDisplays = displayManager.getDisplays(DisplayManager.DISPLAY_CATEGORY_PRESENTATION);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);


//        videoplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//
////                mediaPlayer.setLooping(true);
//
//            }
//        });

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override

            public void onClick(View v) {


                switch (v.getId()) {

                    case R.id.btnleft:
                        if (videocount == 0) {
                            videocount = videopath.length - 1;

                        } else if (videocount != 0) {
                            videocount--;

                        }
                        videoplayer.stopPlayback();
                        videoplayer.setVideoPath(videopath[videocount]);
                        videoplayer.start();
                        break;

                    case R.id.btnright:
                        if (videocount == videopath.length - 1) {
                            videocount = 0;
                        } else {
                            videocount++;

                        }
                        videoplayer.stopPlayback();
                        videoplayer.setVideoPath(videopath[videocount]);
                        videoplayer.start();
                        break;

                    case R.id.btnequal:
                        if (videoplayer != null) {
                            videoplayer.seekTo(stop);
                            videoplayer.start();
                        }
                        break;

                    case R.id.btnstop:
                        if (videoplayer != null) {
                            stop = videoplayer.getCurrentPosition();
                            videoplayer.pause();

                        }
                        break;
                }

            }

        };

        btnleft = (Button) findViewById(R.id.btnleft);
        btnleft.setOnClickListener(onClickListener);

        btnright = (Button) findViewById(R.id.btnright);
        btnright.setOnClickListener(onClickListener);

        btnequal = (Button) findViewById(R.id.btnequal);
        btnequal.setOnClickListener(onClickListener);

        btnstop = (Button) findViewById(R.id.btnstop);
        btnstop.setOnClickListener(onClickListener);

//        setVideoList();

        File file = new File("/storage/emulated/0/a/Video/");
        File[] fileList = file.listFiles();

        String[] fileNames = new String[fileList.length];

        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = fileList[i].getName();
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, fileNames);
        videolist.setAdapter(adapter);
        videolist.setOnItemClickListener(this);


    }

//    private void setVideoList() {


//        videolist.setOnClickListener(new AdapterView.OnItemClickListener{
//
//        });


//    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int videocount, long id) {

//        videoplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                if (videocount == videopath.length - 1) {
//                    videocount = 0;
//                } else {
//                    videocount++;
//
//                }
//                videoplayer.stopPlayback();
//                videoplayer.setVideoPath(videopath[videocount]);
//                videoplayer.start();
//
//
//            }
//        });

        if (videocount == videopath.length - 1) {
            videocount = 0;
        } else {
            videocount++;

        }
        videoplayer.stopPlayback();
        videoplayer.setVideoPath(videopath[videocount]);
        videoplayer.start();
    }
}
