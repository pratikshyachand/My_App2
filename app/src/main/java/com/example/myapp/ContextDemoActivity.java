package com.example.myapp;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContextDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_context_demo);

        TextView tvName=findViewById(R.id.tvName);
        EditText etContact=findViewById(R.id.etContact);

        registerForContextMenu(tvName);
        registerForContextMenu(etContact);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v.getId()==R.id.tvName)
        {
            getMenuInflater().inflate(R.menu.context_menu1,menu);
        }
        else if(v.getId()==R.id.etContact)
        {
            getMenuInflater().inflate(R.menu.context_menu2,menu);
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }
}