package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class SignupActivity extends AppCompatActivity {
    TextView tvLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        tvLink = findViewById(R.id.loginBtn);
        tvLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToLogin();
            }
        });
    }

public void navigateToLogin()
{
    Intent intent = new Intent(this, LoginActivity.class);
    startActivity(intent);
    finish();
}

    public void forwardLogin(View view)
    {

        Button signupBtn=findViewById(R.id.signupBtn);
        EditText etFirstName=findViewById(R.id.etFirstName);
        EditText etLastName=findViewById(R.id.etLastName);
        EditText etSignupEmail=findViewById(R.id.etSignupEmail);
        EditText etSignupPassword=findViewById(R.id.etSignupPassword);
        EditText etSignupConfirm=findViewById(R.id.etSignupConfirmPass);

        String firstName= etFirstName.getText().toString();
        String lastName= etLastName.getText().toString();
        String email= etSignupEmail.getText().toString();
        String password= etSignupPassword.getText().toString();
        String confirmPass= etSignupConfirm.getText().toString();

        Intent intent= new Intent(this,LoginActivity.class);
        //Log.i("KEY",firstName);
        startActivity(intent);
        finish();
    }



}