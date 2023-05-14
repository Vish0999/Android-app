package com.example.hostelnew;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {
    TextView helpline;
    EditText inputUsername, inputPassword1;
    Button loginbtn, google, facebook;


    private static final String url = "http://192.168.168.151/hostel2023/api/login.php";

    Context context;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);
        helpline = findViewById(R.id.helpline);
        helpline.setSelected(true);
        inputUsername = findViewById(R.id.inputUsername);
        inputPassword1 = findViewById(R.id.inputPassword1);
        loginbtn = findViewById(R.id.loginbtn);


        google = findViewById(R.id.google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.google.com/");
            }

            private void goLink(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String muname = inputUsername.getText().toString().trim();
                String mpassword = inputPassword1.getText().toString().trim();

                if (!muname.isEmpty() || !mpassword.isEmpty()) {
                    Login(muname, mpassword);
                } else {
                    inputUsername.setError("Please Insert Username");
                    inputPassword1.setError("Please Insert Password");
                }
            }
        });


    }

    private void Login(String muname, String mpassword) {

//        btnlogin.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String success = response;
                        if (success.equals("Login Successful")) {
//                            PreferenceUtils.saveEmail(memail,context);
//                            PreferenceUtils.savePassword(mpassword,context);

                            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity2.this, "Invalid User name password", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity2.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", muname);
                params.put("password", mpassword);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
















//
//        facebook.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            goLink("http://www.facebook.com");
//        }
//    });
//}
//
//    private void goLink(String s) {
//        Uri uri=Uri.parse(s);
//        startActivity(new Intent(Intent.ACTION_VIEW,uri));
//    }
//    }

