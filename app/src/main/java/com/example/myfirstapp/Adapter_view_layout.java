package com.example.myfirstapp;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


public class Adapter_view_layout extends BaseAdapter {

    private Context context;
    private List<User> userList;
    private LayoutInflater inflater;

    public Adapter_view_layout(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public User getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.activity_adapter_view_layout, null);

        User current_user = getItem(position);
        String first_name = current_user.getFirst_name();
        String last_name = current_user.getLast_name();

        TextView first_name_view = convertView.findViewById(R.id.txt_first_name);
        TextView last_name_view = convertView.findViewById(R.id.txt_last_name);

        first_name_view.setText(first_name);
        last_name_view.setText(last_name);


        return  convertView;
    }
}
