package com.example.hostelnew;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity11 extends AppCompatActivity {
    TextView textView30,textView31,textView19;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main11);
        textView30= findViewById(R.id.textView30);
        textView30.setSelected(true);

        textView31=findViewById(R.id.textView31);
        textView31.setSelected(true);

        textView19= findViewById(R.id.textView19);
        textView19.setSelected(true);
    }
}