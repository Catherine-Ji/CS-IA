package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button loginBtn = (Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = (EditText)findViewById(R.id.usernameEditText);
                EditText password = (EditText)findViewById(R.id.passwordEditText);
                String userstr = username.getText().toString();
                String pass1 = password.getText().toString();

                //username gets used to search in database through the dbhelper
                String passwrd = helper.searchPass(userstr);
                //if the entered password is the same as the stored password
                if(pass1.equals(passwrd)){
                    Intent welcomeIntent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    welcomeIntent.putExtra("com.example.myapp.SOMETHING", userstr);
                    startActivity(welcomeIntent);
                }else{
                    Toast pass = Toast.makeText(Login.this, "Username and password don't match!", Toast.LENGTH_SHORT);
                    pass.show();
                }

            }
        });

    }
}
