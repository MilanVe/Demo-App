package com.example.deaddecoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.util.AnalyticQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private static final int PICK_FROM_FILE = 1;
    TextView text;
    VideoView vidView;
    ImageView imgView;
    private Uri vidUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text = (TextView) findViewById(R.id.textView);


        videoChooser();
        //Log.i("create", "this first?");

    }

    private void videoChooser() {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_FROM_FILE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK)
            return;

        //Uri vidUri = null;
        if (requestCode == PICK_FROM_FILE) {
            vidUri = data.getData();
        }

        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(getApplicationContext(), vidUri);

        //old code:
        int frames = Integer.parseInt(mediaMetadataRetriever.extractMetadata(32));
        //Log.d("frames", ""+frames);

        int numberOfThreads = 1;
        Float[] values = new Float[frames-numberOfThreads];
        Thread[] threads = new Thread[numberOfThreads];
        //List<Runnable> Framethreads;

        /** new recordings **/
        for(int t =0; t<numberOfThreads;t++)
        {
            threads[t] = new Framethreads(t,vidUri,numberOfThreads, values);
            threads[t].start();

        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        AnalyticQueue hueValues = new AnalyticQueue();
        Log.d("thread results", ""+values.toString());
        hueValues.addAll(Arrays.asList(values));
        text.setText("morse= "+hueValues.analyze());

        /** prerecorded functions
        AnalyticQueue hueValues = new AnalyticQueue();
        hueValues.analysefromstring();
         **/
    }

    class Framethreads extends Thread {
        //https://www.youtube.com/watch?v=QfQE1ayCzf8&ab_channel=CodinginFlow

        int ThreadIndex;
        private Uri vidUri = null;
        int numberOfThreads;
        Float[] hueValues;
        int Pixels_per_line = 50;
        int Pixels_per_column = 50;


        private Framethreads(int ThreadIndex, Uri vidUri, int numberOfThreads, Float[] hueValues) {
            this.ThreadIndex = ThreadIndex;
            this.numberOfThreads = numberOfThreads;
            this.hueValues = hueValues;
            this.vidUri = vidUri;
            }

        @Override
        public void run() {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(getApplicationContext(), vidUri);
            int width, height, frames;
            int orientation = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            frames = Integer.parseInt(mediaMetadataRetriever.extractMetadata(32));
            if (orientation == 0 || orientation == 180) {
                width = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                height = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            } else {
                width = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                height = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            }

            Log.d("orientation" , "" + orientation);
            Log.d("frame xy" , "" + width + " " + height);
            Log.d("frames" , "" + frames);

            Bitmap bitmap;
            for ( int f = ThreadIndex; f < frames-numberOfThreads; f += numberOfThreads ) {
                try {
                    bitmap = mediaMetadataRetriever.getFrameAtIndex(f);
                    float Hue = 0;

                    for (int col = 0; col < width - 1; col = col + width / Pixels_per_line) { // + width/Pixels_per_line
                        for (int row = 0; row < height - 1; row = row + height / Pixels_per_column) { //  + height/Pixels_per_column
                            //Log.d("xy " + f, ":" + col + " " + row);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                                //version 29+
                                Hue += (bitmap.getColor(col, row).red() + bitmap.getColor(col, row).green() + bitmap.getColor(col, row).blue());
                            } else {
                                // lower versions
                                Hue += (Color.red(bitmap.getPixel(col, row)) + Color.green(bitmap.getPixel(col, row)) + Color.blue(bitmap.getPixel(col, row)));
                            }
                        }
                    }
                    Hue /= (Pixels_per_column * Pixels_per_line * 3);
                    Log.d("Hue of frame " + f + " on thread " + ThreadIndex, ":" + Hue);
                    hueValues[f] = Hue;
                } catch (Exception e){
                    Log.d("loop Failed at " + f + " on thread " + ThreadIndex, "");
                }

            }

            Log.d("Thread " + ThreadIndex, " Has finished");


        }
    }



}