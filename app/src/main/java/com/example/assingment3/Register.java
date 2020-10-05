package com.example.assingment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText et_name,et_phone,et_email,et_userID,et_password,et_re_password,et_url;
    private Button btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Register");

        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        et_userID = findViewById(R.id.et_id);
        et_password = findViewById(R.id.et_password);
        et_re_password = findViewById(R.id.et_re_password);
        et_url = findViewById(R.id.et_web_site);
        btn_register = findViewById(R.id.btn_register);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);

                String name = et_name.getText().toString();
                String phn = et_phone.getText().toString();
                String email = et_email.getText().toString();
                String userId = et_userID.getText().toString();
                String password = et_password.getText().toString();
                String re_password = et_re_password.getText().toString();
                String url = et_url.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (password.equals(re_password)){
                    editor.putString("username",name);
                    editor.putString("userphone",phn);
                    editor.putString("useremail",email);
                    editor.putString("userid",userId);
                    editor.putString("userpassword",password);
                    editor.putString("user_re_password",re_password);
                    editor.putString("user_url",url);
                    editor.apply();
                    Toast.makeText(Register.this, "User registered!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Register.this,MainActivity.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(Register.this, "Password are not Match Password", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}
