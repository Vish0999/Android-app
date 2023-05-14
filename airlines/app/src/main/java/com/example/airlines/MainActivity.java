package com.example.airlines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView marq1, textView6;

    Button login;

    EditText iu, passs;


    private static final String url = "http://192.168.168.151/manmeet_airline/Api/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        marq1=findViewById(R.id.marq12);
        marq1.setSelected(true);
        iu=findViewById(R.id.iu);
        passs=findViewById(R.id.passs);
        login=findViewById(R.id.login);
        textView6=findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String muname = iu.getText().toString().trim();
                String mpass = passs.getText().toString().trim();

                if (!muname.isEmpty() || !mpass.isEmpty()) {
                    Login(muname, mpass);
                } else {
                    iu.setError("Please Insert Username");
                    passs.setError("Please Insert Password");
                }
            }
        });


    }

    private void Login(String muname, String mpass) {

//        btnlogin.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String success = response;
                        if (success.equals("Login Successful")) {
//                            PreferenceUtils.saveEmail(memail,context);
//                            PreferenceUtils.savePassword(mpassword,context);

                            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Invalid User name password", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", muname);
                params.put("password", mpass);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
