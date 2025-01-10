package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void forward(View view)
    {   Button btnLogin= findViewById(R.id.btnLogin);
        Button btnSignup= findViewById(R.id.btnSignup);
        EditText username= findViewById(R.id.etUsername);
        EditText password= findViewById(R.id.etPassword);

        String user= (username.getText()).toString();
        String pass= (password.getText()).toString();
        if(user.equals("pogo@gmail.com") && pass.equals("pogo"))
        {
            Intent intent= new Intent(this, MainActivity.class);
            intent.putExtra("userName",user);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(getApplicationContext(),"Invalid credentials",Toast.LENGTH_SHORT).show();
        }

    }

   public void forwardSignup(View view)
    {
        Intent i= new Intent(this, SignupActivity.class);
        startActivity(i);
        finish();
   }

}
