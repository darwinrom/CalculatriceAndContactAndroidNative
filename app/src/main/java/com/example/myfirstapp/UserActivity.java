package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        this.setTitle("Liste des utilisateurs");

        List<User> UserList = new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.listUser) ;
        UserList.add(new User("MAGENGO", "Guttembert", 25,"Masculin","67712006"));
        UserList.add(new User("BELLO", "Kalam", 21,"Féminin","96192019"));
        UserList.add(new User("TOUPE", "Robert", 20,"Masculin","61720976"));
        UserList.add(new User("ASSOGBA", "Daniele", 24,"Féminin","67712006"));
        UserList.add(new User("ABIKOU", "Nene", 32,"Féminin","67712006"));

        listView.setAdapter(new Adapter_view_layout(this,UserList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User item = (User) parent.getItemAtPosition(position);
                Intent intent = new Intent(UserActivity.this, User_item.class);
                intent.putExtra("user_first_name", item.getFirst_name());
                intent.putExtra("user_last_name", item.getLast_name());
                intent.putExtra("user_phone", item.getPhone());
                intent.putExtra("user_sexe", item.getSexe());

                startActivity(intent);
            }
        });
    }
}

