package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_cal =(Button) findViewById(R.id.btn_cal);
        Button btn_user =(Button) findViewById(R.id.btn_user);

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent page_cal = new Intent(MainActivity.this,CalculatriceActivity.class);
                startActivity(page_cal);

            }
        });

        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent page_user = new Intent(MainActivity.this,UserActivity.class);
                startActivity(page_user);

            }
        });
    }

}
