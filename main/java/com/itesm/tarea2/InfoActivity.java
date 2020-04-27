package com.itesm.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {
    private Amigos amigo;
    private String name, hobby, age, phone, address;
    private TextView txtName, txtHobby, txtAge, txtPhone, txtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        getData();
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtName = findViewById(R.id.txtName);
        txtHobby = findViewById(R.id.txtHobby);
        txtAge = findViewById(R.id.txtAge);
        txtPhone = findViewById(R.id.txtPhone);
        txtAddress = findViewById(R.id.txtAddress);

        setData();
    }

    public void getData(){
        if(
                getIntent().hasExtra("name") &&
                getIntent().hasExtra("age") &&
                getIntent().hasExtra("hobby") &&
                getIntent().hasExtra("phone") &&
                getIntent().hasExtra("address")
        ) {
            name = getIntent().getStringExtra("name");
            age = getIntent().getStringExtra("age");
            hobby = getIntent().getStringExtra("hobby");
            phone = getIntent().getStringExtra("phone");
            address = getIntent().getStringExtra("address");
        }else{
            Toast.makeText(this, "Error al cargar los datos", Toast.LENGTH_SHORT).show();
        }
    }
    public void setData(){
        txtName.setText(name);
        txtHobby.setText(hobby);
        txtAge.setText(age);
        txtPhone.setText(phone);
        txtAddress.setText(address);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
