package com.example.passwordcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = (EditText) findViewById(R.id.registrationLogin);
        password = (EditText) findViewById(R.id.registrationPassword);
        registration = (Button) findViewById(R.id.registrationButton);

        registration.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String userNameEntered = username.getText().toString();
                String passwordEntered = password.getText().toString();

                Resources resources = getResources();
                Toast.makeText(getApplicationContext() , resources.getText(R.string.registration_toast) , Toast.LENGTH_SHORT).show();

                Intent backIntent = new Intent(RegistrationActivity.this, MainActivity.class);

                backIntent.putExtra("login" , userNameEntered);
                backIntent.putExtra("password" , passwordEntered);

                startActivity(backIntent);
            }

         });

    }


}