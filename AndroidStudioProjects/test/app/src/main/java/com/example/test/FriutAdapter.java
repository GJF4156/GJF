package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FriutAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FriutAdapter(@NonNull Context context, int resource, List<Fruit> objects) {
        super(context, resource,objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Fruit fruit=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView imgView=view.findViewById(R.id.imgView);
        TextView textView=view.findViewById(R.id.textView);
        imgView.setImageResource(fruit.getImageid());
        textView.setText(fruit.getName());

        return view;
    }
}
