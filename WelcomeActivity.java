package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if(getIntent().hasExtra("com.example.myapp.SOMETHING")){
            TextView username = (TextView) findViewById(R.id.usermaneTextView);
            String text = getIntent().getExtras().getString("com.example.myapp.SOMETHING");
            username.setText(text);
        }

        Button welcomeBtn = (Button)findViewById(R.id.welcomeBtn);
        welcomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent groceryListIntent = new Intent(getApplicationContext(), GroceryList.class);
                startActivity(groceryListIntent);
            }
        });

    }
}
