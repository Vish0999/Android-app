package com.example.hostelnew;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView Alreadyhaveanaccount,firsttext;
    ImageView imageView18;


    private EditText inputUsername, inputPassword, inputEmail, inputConfirmPassword;
    Button button;
    private static final String url = "http://192.168.168.151/hostel2023/api/register.php";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        firsttext= findViewById(R.id.firsttext);
        firsttext.setSelected(true);
        imageView18=findViewById(R.id.imageView18);
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.already);
        imageView18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
        Alreadyhaveanaccount=findViewById(R.id.Alreadyhaveanaccount);
        Alreadyhaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });

        //Go to Login
        button = findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adduser();
            }
        });
    }

    //check number here
    private void adduser() {
        inputUsername = findViewById(R.id.username1);
        inputEmail = findViewById(R.id.usnmemail);
        inputPassword = findViewById(R.id.unmpassword);
        inputConfirmPassword = findViewById(R.id.unmcnfpassword);

        final String rusername = inputUsername.getText().toString().trim();
        final String runmemail = inputEmail.getText().toString().trim();
        final String runmpasswrd = inputPassword.getText().toString().trim();
        final String runmcnfpasswrd = inputConfirmPassword.getText().toString().trim();

        if (rusername.isEmpty() || runmemail.isEmpty() || runmpasswrd.isEmpty() || runmcnfpasswrd.isEmpty()) {
            Toast.makeText(MainActivity.this, "Some Field Is Empty", Toast.LENGTH_SHORT).show();

        } else {
            if (runmcnfpasswrd.equals(runmpasswrd)) {

                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        inputUsername.setText("");
                        inputEmail.setText("");
                        inputPassword.setText("");
                        inputConfirmPassword.setText("");
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();

                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> param = new HashMap<String, String>();
                        param.put("username", rusername);
                        param.put("password", runmpasswrd);
                        return param;
                    }
                };

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(request);

            } else {
                Toast.makeText(MainActivity.this, "Password Does not Match", Toast.LENGTH_SHORT).show();
            }
        }
    }


}

//        inputUsername = findViewById(R.id.inputUsername);
//        inputEmail = findViewById(R.id.inputPassword1);
//        inputPassword = findViewById(R.id.inputPassword);
//        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
//
//
//        button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (TextUtils.isEmpty(inputUsername.getText().toString())) {
//                    inputUsername.setError("username is compalsary");
//                    return;
//                }
//
//                if (TextUtils.isEmpty(inputEmail.getText().toString())) {
//                    inputEmail.setError("email is compalsary");
//                    return;
//                }
//
//
//                if (TextUtils.isEmpty(inputPassword.getText().toString())) {
//                    inputPassword.setError("enter valid password");
//                    return;
//                }
//                if (TextUtils.isEmpty(inputConfirmPassword.getText().toString())) {
//                    inputConfirmPassword.setError("confirm password");
//                    return;
//                }
//
//
//                Toast.makeText(MainActivity.this, "register succesfull", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//                startActivity(intent);
//            }
//        });
