package com.example.videoplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.display.DisplayManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DisplayManager displayManager;
    Display[] presentationDisplays;
    View view;
    VideoView videov;
    int imgCount = 0;
    Bitmap bmImg1 = BitmapFactory.decodeFile("/storage/emulated/0/a/IMG/a.jpg");
    Bitmap bmImg2 = BitmapFactory.decodeFile("/storage/emulated/0/a/IMG/b.jpg");
    Bitmap bmImg3 = BitmapFactory.decodeFile("/storage/emulated/0/a/IMG/c.jpg");
    Bitmap bmImg4 = BitmapFactory.decodeFile("/storage/emulated/0/a/IMG/d.jpg");
    HandlerCust mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayManager = (DisplayManager) getApplicationContext().getSystemService(Context.DISPLAY_SERVICE);
        presentationDisplays = displayManager.getDisplays(DisplayManager.DISPLAY_CATEGORY_PRESENTATION);
        LayoutInflater inflate = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        view = inflate.inflate(R.layout.activity_main, null);

//        Presentation presentation = new Presentation(this,presentationDisplays[0]);
//        presentation.setContentView(view);
//        presentation.show();

//        ((ImageView)view.findViewById(R.id.img)).setImageBitmap(bmImg1);

        videov = findViewById(R.id.videov);
        videov.setVideoPath("/storage/emulated/0/a/Video/a.mp4");
        videov.start();
        videov.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
    }
});

//        findViewById(R.id.copy).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ;
//                UsbFileManagerCust mFileManager = new UsbFileManagerCust( Util.getExUSBPath(getApplicationContext()));
//                ArrayList<File> mArray = mFileManager.getFileArray();
//                String usbPath = Util.getExUSBPath(getApplicationContext())+"/adv_files";
//                File usbFolder = new File(usbPath);
//                File folder2 = new File(Util.SD_PATH_SCREEN_SAVER);
//                Util.copy(usbFolder,folder2);
//            }
//        });
//        mHandler = new HandlerCust();
//        mHandler.sendEmptyMessageDelayed(1,3000);
//        Log.e("aa",""+presentationDisplays.length);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("aa",""+presentationDisplays.length);
    }

//    private class HandlerCust extends Handler {
//        @Override
//        public void handleMessage(Message msg){
//            super.handleMessage(msg);
//
//            switch(msg.what){
//                case 1:
//                    imgCount++;
//                    switch (imgCount){
//                        case 0:
//                            ((ImageView)view.findViewById(R.id.img)).setImageBitmap(bmImg1);
//                            break;
//                        case 1:
//                            ((ImageView)view.findViewById(R.id.img)).setImageBitmap(bmImg2);
//                            break;
//                        case 2:
//                            ((ImageView)view.findViewById(R.id.img)).setImageBitmap(bmImg3);
//                            break;
//                        case 3:
//                            ((ImageView)view.findViewById(R.id.img)).setImageBitmap(bmImg4);
//                            imgCount = 0;
//                            break;
//                    }
//                    mHandler.sendEmptyMessageDelayed(1,3000);
//                    break;
//            }
//        }
//    }

}