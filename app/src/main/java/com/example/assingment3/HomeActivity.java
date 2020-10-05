package com.example.assingment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class HomeActivity extends AppCompatActivity {


    private ImageView imageView_glide;
    private TextView et_name,et_phn,et_email;
    private Button website,update_passwrd,edit_profile,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setTitle("Profile");

        et_name = findViewById(R.id.tv_show_name);
        et_phn = findViewById(R.id.tv_show_phn);
        et_email = findViewById(R.id.tv_show_email);

        edit_profile = findViewById(R.id.btn_edit_profile);
        logout = findViewById(R.id.btn_logout);

        imageView_glide = findViewById(R.id.iv_glid);
        website = findViewById(R.id.btn_website);

        Glide.with(HomeActivity.this)
        //.load("https://i.imgur.com/qpr5LR2.jpg")
        .load("https://i.imgur.com/Vth6CBz.gif")
         .diskCacheStrategy(DiskCacheStrategy.NONE)
         .into(imageView_glide);


        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                String registeredUrl = sharedPreferences.getString("user_url","");
                String url=registeredUrl;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
        String registeredname = sharedPreferences.getString("username","");
        String registeredphone = sharedPreferences.getString("userphone","");
        String registeredemail = sharedPreferences.getString("useremail","");

        et_name.setText(registeredname);
        et_phn.setText(registeredphone);
        et_email.setText(registeredemail);

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,Register.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Toast.makeText(HomeActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
