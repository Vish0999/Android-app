package com.example.airlines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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

public class MainActivity5 extends AppCompatActivity {
    private EditText id,cid,email1,uname,dist,secdist;
    Button btnbook;


    private static final String url = "http://192.168.168.151/manmeet_airline/Api/booking.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main5);
        btnbook=findViewById(R.id.btnbook);
        //Go to Login

        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adduser();
            }
        });
    }

    //check number here
    private void adduser() {
        id = findViewById(R.id.id);
        cid = findViewById(R.id.cid);
        email1 = findViewById(R.id.email1);
        uname = findViewById(R.id.uname);
        dist=findViewById(R.id.dist);
        secdist=findViewById(R.id.secdist);






        final String rid = id.getText().toString().trim();
        final String rcid= cid.getText().toString().trim();
        final String runame = uname.getText().toString().trim();
        final String remail1 = email1.getText().toString().trim();

        final String rdiatination= dist.getText().toString().trim();
        final String rseconddist = secdist.getText().toString().trim();






        if (rid.isEmpty() || rcid.isEmpty() || runame.isEmpty()||remail1.isEmpty()||rdiatination.isEmpty()||rseconddist.isEmpty()) {
            Toast.makeText(MainActivity5.this, "Some Field Is Empty", Toast.LENGTH_SHORT).show();

        } else {
            if (rid.equals(rcid)) {


                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        id.setText("");
                        cid.setText("");
                        uname.setText("");
                        email1.setText("");

                        dist.setText("");
                        secdist.setText("");

                        Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
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
                        param.put("id", rid);
                        param.put("cid", rcid);
                        param.put("uname", runame);
                        param.put("email1", remail1);
                        param.put("dist", rdiatination);
                        param.put("secdist", rseconddist);
                        return param;
                    }
                };

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(request);

            } else {
                Toast.makeText(MainActivity5.this, "room no Does not Match", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
