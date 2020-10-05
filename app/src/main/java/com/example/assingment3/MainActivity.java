package com.example.assingment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_id,et_password;
    private Button btn_login;
    private TextView tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        et_id = findViewById(R.id.et_id);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        tv_register = findViewById(R.id.tv_register);




        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);

                 String id = et_id.getText().toString();
                 String password = et_password.getText().toString();

                 String registeredId = sharedPreferences.getString("userid","");
                 String registeredpassword = sharedPreferences.getString("userpassword","");

                 if(id.equals(registeredId) && password.equals(registeredpassword)){
                     Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                     startActivity(intent);
                     Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                 }
                 else {
                     Toast.makeText(MainActivity.this, "Incorrect and Password ", Toast.LENGTH_SHORT).show();
                 }

                }


        });
    }
}
