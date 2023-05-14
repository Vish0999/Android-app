package com.example.airlines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {
    ImageView tic1,tic2,tic3,tic4,tic5,tic6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main4);
        tic1=findViewById(R.id.tic1);
        tic2=findViewById(R.id.tic2);
        tic3=findViewById(R.id.tic3);
        tic4=findViewById(R.id.tic4);
        tic5=findViewById(R.id.tic5);
        tic6=findViewById(R.id.tic6);
        tic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity4.this,MainActivity5.class);
                startActivity(i);
            }
        });
        tic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity4.this,MainActivity5.class);
                startActivity(i);
            }
        });
        tic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity4.this,MainActivity5.class);
                startActivity(i);
            }
        });
        tic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity4.this,MainActivity5.class);
                startActivity(i);
            }
        });
        tic5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity4.this,MainActivity5.class);
                startActivity(i);
            }
        });
        tic6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity4.this,MainActivity5.class);
                startActivity(i);
            }
        });
    }
}