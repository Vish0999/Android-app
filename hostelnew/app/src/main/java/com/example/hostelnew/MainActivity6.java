package com.example.hostelnew;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {
    TextView textView51,textView52,textView53,meal;
    ImageView soundimg;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main6);

        meal= findViewById(R.id.meal);

        textView51= findViewById(R.id.textView51);
        textView51.setSelected(true);

        textView52= findViewById(R.id.second2);
        textView52.setSelected(true);

        textView53= findViewById(R.id.textView53);
        textView53.setSelected(true);


        videoView=findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" +getPackageName() +"/"+ R.raw.hostelvvv));

        MediaController mediaController= new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();

        soundimg= findViewById(R.id.soundimg);
        MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.sound);
        soundimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer.start();
            }
        });

        meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity6.this,MainActivity9.class);
                startActivity(i);
            }
        });
    }
}