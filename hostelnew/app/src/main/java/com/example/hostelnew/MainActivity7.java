package com.example.hostelnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity7 extends AppCompatActivity {
    TextView textView12, textView14, textView16,textView20;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main7);
        textView12=findViewById(R.id.textView12);
        textView12.setSelected(true);
        textView14=findViewById(R.id.textView14);
        textView14.setSelected(true);
        textView16=findViewById(R.id.textView16);
        textView16.setSelected(true);
        textView20=findViewById(R.id.textView20);
        textView20.setSelected(true);
        button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity7.this,MainActivity8.class);
                startActivity(intent);
            }
        });
    }
}