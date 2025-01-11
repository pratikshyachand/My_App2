package com.example.myapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_list_view);

        //toolbar

        Toolbar toolbar1=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        //customView
        ArrayList<CustomViewBind> arrayList=new ArrayList<>();
        arrayList.add(new CustomViewBind(R.drawable.account,"Baba","9876543210"));
        arrayList.add(new CustomViewBind(R.drawable.account,"Maa","9876543210"));
        arrayList.add(new CustomViewBind(R.drawable.account,"Dijju","9876543210"));
        arrayList.add(new CustomViewBind(R.drawable.account,"Bhaai","9876543210"));



        CustomViewAdapter customViewAdapter=new CustomViewAdapter(this,arrayList);

        ListView listView=findViewById(R.id.customlist);
        listView.setAdapter(customViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),arrayList.get(position).getDetailText(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_contact,menu);
        return super.onCreateOptionsMenu(menu);
    }
}