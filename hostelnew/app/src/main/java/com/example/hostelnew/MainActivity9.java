package com.example.hostelnew;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity9 extends AppCompatActivity {
    Button first,second,third;
    LinearLayout layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main9);
        first=findViewById(R.id.first);
        second=findViewById(R.id.second);
        third=findViewById(R.id.third);
        layout1=findViewById(R.id.layout1);
      first.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              MealFragment mealFragment=new MealFragment();
              FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
              transaction.replace(R.id.layout1,mealFragment);
              transaction.commit();

          }
      });


        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment=new SecondFragment();
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout1,secondFragment);
                transaction.commit();

            }
        });

        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThirdFragment thirdFragment=new ThirdFragment();
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout1,thirdFragment);
                transaction.commit();

            }
        });
    }
}