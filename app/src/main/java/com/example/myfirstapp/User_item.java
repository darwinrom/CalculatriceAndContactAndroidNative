package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class User_item extends AppCompatActivity {
    private TextView tel;
    private Button cal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_item);

        Bundle bundle = getIntent().getExtras();
        this.setTitle("Détails de l'utilisateur");
        if (bundle != null) {
            TextView fn = (TextView) findViewById(R.id.txt_user_fn);
            TextView ln = (TextView) findViewById(R.id.user_ln);
            tel = (TextView) findViewById(R.id.user_phone);
            TextView ugender = (TextView) findViewById(R.id.user_gender);


            String first_name =  bundle.getString("user_first_name");
            String last_name =  bundle.getString("user_last_name");
            String gender =  bundle.getString("user_sexe");
            String phone =  bundle.getString("user_phone");

            fn.setText(first_name);
            ln.setText(last_name);
            tel.setText(phone);
            ugender.setText(gender);


        }
    }


    public  void makeCall(View view) {
        int id = view.getId();
        if(id==R.id.btnCall){
            TextView tel = (TextView) findViewById(R.id.user_phone);
            Intent callIntent =new Intent(Intent.ACTION_CALL);
            String p = "tel:" + tel.getText().toString();
            callIntent.setData(Uri.parse(p));
            if (ActivityCompat.checkSelfPermission(User_item.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            startActivity(callIntent);

      }
    }


}
