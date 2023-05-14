package com.example.hostelnew;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity5 extends AppCompatActivity {
    EditText date, firstname,surname,emails,cdno,ccdno;
    Button button2;
    int DD;
    int MM;
    int YY;
    Spinner spinner3,spinner4, spinner5;
    String[] genders={"male","female"};
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July"};

    private static final String url = "http://192.168.168.151/hostel2023/api/Payment.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main5);
        button2=findViewById(R.id.button2);
        date=findViewById(R.id.date);
        final Calendar calendar= Calendar.getInstance();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DD=calendar.get(Calendar.DATE);
                MM=calendar.get(Calendar.DAY_OF_MONTH);
                YY=calendar.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity5.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));

                    }
                },DD,MM,YY);
                datePickerDialog.show();

            }
        });
        spinner3 = findViewById(R.id.spinner3);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity5.this, android.R.layout.simple_spinner_item, genders);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity5.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner4 = findViewById(R.id.spinner4);


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity5.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.days));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter2);

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity5.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner5 = findViewById(R.id.spinner5);


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity5.this, android.R.layout.simple_spinner_item, months);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter1);

        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity5.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adduser();
            }
        });
    }

    //check number here
    private void adduser() {
        firstname = findViewById(R.id.firstname);
        surname = findViewById(R.id.surname);
        emails = findViewById(R.id.emails);
        cdno=findViewById(R.id.cdno);
        ccdno=findViewById(R.id.ccdno);








        final String rfname = firstname.getText().toString().trim();
        final String rsname = surname.getText().toString().trim();
        final String remail = emails.getText().toString().trim();
        final String rcardno = cdno.getText().toString().trim();
        final String rccardno = ccdno.getText().toString().trim();






        if (rfname.isEmpty() || remail.isEmpty() || rsname.isEmpty()||remail.isEmpty()||rcardno.isEmpty()||rccardno.isEmpty()) {
            Toast.makeText(MainActivity5.this, "Some Field Is Empty", Toast.LENGTH_SHORT).show();

        } else {
            if (rcardno.equals(rccardno)) {


                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        firstname.setText("");
                        surname.setText("");
                        emails.setText("");
                        cdno.setText("");
                        ccdno.setText("");

                        Intent intent = new Intent(MainActivity5.this, MainActivity12.class);
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
                        param.put("fname", rfname);
                        param.put("sname", rsname);
                        param.put("email", remail);
                        param.put("cardno", rcardno);
                        param.put("Ccardnos", rccardno);
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
