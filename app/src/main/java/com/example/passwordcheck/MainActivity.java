package com.example.passwordcheck;

import androidx.appcompat.app.AppCompatActivity;

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
    private String right;
    private String wrong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.editTextLogin);
        password = (EditText) findViewById(R.id.editTextPassword);
        message = (TextView) findViewById(R.id.textViewMessage);
        right = getString(R.string.right_login);
        wrong = getString(R.string.wrong_login);

    }

    public void Login(View view){
        Resources resources = getResources();
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("12345678")){
            Toast.makeText(getApplicationContext() , "Вход выполнен!" , Toast.LENGTH_SHORT).show();
            message.setTextColor(resources.getColor(R.color.green));
            message.setText(right);
        }

        else {
            Toast.makeText(getApplicationContext() , "Неправильный логин или пароль!" , Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
            message.setTextColor(resources.getColor(R.color.red));
            message.setText(wrong);
        }
    }


}