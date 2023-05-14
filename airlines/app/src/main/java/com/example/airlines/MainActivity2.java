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

public class MainActivity2 extends AppCompatActivity {
    private EditText usernames, emailsss,passs,cpass;

    Button register;
    TextView marq12;

    private static final String url = "http://192.168.168.151/manmeet_airline/Api/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);
        marq12=findViewById(R.id.marq12);
        marq12.setSelected(true);



        register=findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adduser();
            }
        });
    }

    //check number here
    private void adduser() {
        usernames = findViewById(R.id.iu);
        emailsss= findViewById(R.id.emailsss);
        passs = findViewById(R.id.passs);
        cpass = findViewById(R.id.cpass);

        final String ausername = usernames.getText().toString().trim();
        final String aunmemail = emailsss.getText().toString().trim();
        final String aunmpasswrd = passs.getText().toString().trim();
        final String aunmcnfpasswrd = cpass.getText().toString().trim();

        if (ausername.isEmpty() || aunmemail.isEmpty() || aunmpasswrd.isEmpty() || aunmcnfpasswrd.isEmpty()) {
            Toast.makeText(MainActivity2.this, "Some Field Is Empty", Toast.LENGTH_SHORT).show();

        } else {
            if (aunmcnfpasswrd.equals(aunmpasswrd)) {

                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        usernames.setText("");
                        emailsss.setText("");
                        passs.setText("");
                        cpass.setText("");
                        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
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
                        param.put("username", ausername);
                        param.put("email", aunmemail);
                        param.put("password", aunmpasswrd);

                        param.put("ConfirmPassword", aunmcnfpasswrd);
                        return param;
                    }
                };

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(request);

            } else {
                Toast.makeText(MainActivity2.this, "Password Does not Match", Toast.LENGTH_SHORT).show();
            }
        }
    }


}