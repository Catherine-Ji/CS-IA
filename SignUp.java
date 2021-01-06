package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        Button createAccountBtn = (Button)findViewById(R.id.createAccountBtn);
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = (EditText)findViewById(R.id.usernameEditText);
                EditText password1 = (EditText)findViewById(R.id.passwordEditText1);
                EditText password2 = (EditText)findViewById(R.id.passwordEditText2);
                String userstr = username.getText().toString();
                String pass1 = password1.getText().toString();
                String pass2 = password2.getText().toString();


                if(!pass1.equals(pass2)){
                    //pop up message when passwords are different
                    Toast pass = Toast.makeText(SignUp.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                    pass.show();
                }else{
                    //insert the details in database
                    Contact c = new Contact();
                    c.setUsername(userstr);
                    c.setPassword(pass1);
                    helper.insertContact(c);
                    Toast account = Toast.makeText(SignUp.this, "New Account Created!", Toast.LENGTH_SHORT);
                    account.show();

                }
            }
        });

    }


}
