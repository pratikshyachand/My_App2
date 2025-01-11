package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomViewAdapter extends ArrayAdapter<CustomViewBind>{
    public CustomViewAdapter(@NonNull Context context, ArrayList<CustomViewBind> customViewBinds) {
        super(context,R.layout.custom_list ,customViewBinds);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        CustomViewBind customViewBind = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.custom_list, parent, false);
        }



        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView1 = view.findViewById(R.id.tv1);
        TextView textView2 = view.findViewById(R.id.tv2);

        imageView.setImageResource(customViewBind.getImgId());
        textView1.setText(customViewBind.getTitleText());
        textView2.setText(customViewBind.getDetailText());
        return view;
    }


}
