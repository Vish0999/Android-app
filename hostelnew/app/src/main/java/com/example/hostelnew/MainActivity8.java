package com.example.hostelnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class MainActivity8 extends AppCompatActivity {
    EditText inputPerson, email1, add1, roomno, roomno1;
    Button book1;
    TextView help;
    Spinner spinner, spinner2;
    String[] gender={"Male","Female"};
    String[] room={"single","double","Triple"};

    private static final String url = "http://192.168.168.151/hostel2023/api/booking.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main8);
        
        help=findViewById(R.id.help);
        help.setSelected(true);
        spinner=findViewById(R.id.spinner);


        ArrayAdapter<String> adapter= new ArrayAdapter<String>(MainActivity8.this, android.R.layout.simple_spinner_item,gender);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity8.this,value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2=findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(MainActivity8.this, android.R.layout.simple_spinner_item,room);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int j, long l) {
                String value=adapterView.getItemAtPosition(j).toString();
                Toast.makeText(MainActivity8.this,value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        //Go to Login
        book1 = findViewById(R.id.book1);
        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adduser();
            }
        });
    }

    //check number here
    private void adduser() {
        inputPerson = findViewById(R.id.inputPerson);
        email1 = findViewById(R.id.emai1);
        add1 = findViewById(R.id.add1);
        roomno=findViewById(R.id.roomno);
        roomno1=findViewById(R.id.roomno1);







        final String rname = inputPerson.getText().toString().trim();
        final String remail = email1.getText().toString().trim();
        final String radd1 = add1.getText().toString().trim();
        final String rroomno = roomno.getText().toString().trim();
        final String rroomno1 = roomno1.getText().toString().trim();






        if (rname.isEmpty() || remail.isEmpty() || radd1.isEmpty()||rroomno.isEmpty()||rroomno1.isEmpty()) {
            Toast.makeText(MainActivity8.this, "Some Field Is Empty", Toast.LENGTH_SHORT).show();

        } else {
            if (rroomno.equals(rroomno1)) {


                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        inputPerson.setText("");
                        email1.setText("");
                        add1.setText("");
                        roomno.setText("");
                        roomno1.setText("");

                        Intent intent = new Intent(MainActivity8.this, MainActivity5.class);
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
                        param.put("bname", rname);
                        param.put("email", remail);
                        param.put("address", radd1);
                        param.put("room_no", rroomno);
                        param.put("reroom_no", rroomno1);
                        return param;
                    }
                };

            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            queue.add(request);

        } else {
            Toast.makeText(MainActivity8.this, "room no Does not Match", Toast.LENGTH_SHORT).show();
        }
    }
}


}
