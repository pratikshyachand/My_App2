package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Intent intent= getIntent();
        String name= intent.getStringExtra("userName");
        TextView message= findViewById(R.id.tvMessage);
        message.setText(name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.option_about) {
            Toast.makeText(getApplicationContext(), "Options clicked!", Toast.LENGTH_LONG).show();
        }
        if(item.getItemId()==R.id.option_help) {
            Toast.makeText(getApplicationContext(), "Help clicked!", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}