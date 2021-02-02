package com.example.passwordcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private TextView message;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.editTextLogin);
        password = (EditText) findViewById(R.id.editTextPassword);
        message = (TextView) findViewById(R.id.textViewMessage);
        login = (Button) findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources resources = getResources();
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("12345678")){
                    message.setTextColor(resources.getColor(R.color.green));
                    message.setText(resources.getText(R.string.right_login));
                }

                else {
                    Intent registrationIntent = new Intent(MainActivity.this, RegistrationActivity.class);
                    Toast.makeText(getApplicationContext() , resources.getText(R.string.wrong_login) , Toast.LENGTH_SHORT).show();
                    startActivity(registrationIntent);
                }
            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent restartIntent = getIntent();

        username = (EditText) findViewById(R.id.editTextLogin);
        password = (EditText) findViewById(R.id.editTextPassword);

        username.setText(restartIntent.getStringExtra("login"));
        password.setText(restartIntent.getStringExtra("password"));

    }


}

