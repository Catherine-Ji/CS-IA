package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItem extends Recipe {
    private Button buttonAdd;
    private EditText editTextName;
    private EditText editTextIngredients;
    private EditText editTextSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);


        buttonAdd = findViewById(R.id.button_add);
        editTextName = findViewById(R.id.edittext_name);
        editTextIngredients = findViewById(R.id.edittext_ingredients);
        editTextSteps = findViewById(R.id.edittext_steps);
        final String name = editTextName.getText().toString();
        final String ingredients = editTextIngredients.getText().toString();
        final String steps = editTextSteps.getText().toString();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertItem(name, ingredients, steps);
            }
        });

    }

    public void insertItem(String name, String ingredients, String steps) {
        mExampleList.add(0, new RecipeItem(R.drawable.ic_fiber_new_black_24dp, name + 0,
                "Ingredients: " + ingredients + 0, "Steps: \n" + steps));
        mAdapter.notifyItemInserted(0);
    }
}
