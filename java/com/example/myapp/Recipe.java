package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recipe extends AppCompatActivity {
    public ArrayList<RecipeItem> mExampleList;

    public RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);

        createExampleList();
        buildRecyclerView();

        buttonInsert = findViewById(R.id.button_add);
        buttonRemove = findViewById(R.id.button_remove);
        editTextRemove = findViewById(R.id.edittext_remove);


        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddItem.class);
                startActivity(intent);

            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position-1);
            }
        });

    }


    public void removeItem(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new RecipeItem(R.drawable.salad, "Ceasar Salad", "Ingredients: lettuce, cheese, tomatoes", "Steps:\n 1) cut lettuce and tomatos into bite size pieces " +
                "\n 2) add dressing and grate cheese over salad \n 3) mix till combined"));
        mExampleList.add(new RecipeItem(R.drawable.cheeseburger, "Cheeseburger", "Ingredients: bread, ground beef, lettuce, " +
                "tomatoes, cheese (optional: pickles and onion)", "Steps:\n 1) season ground beef patties with salt and pepper" +
                "\n2) grill patty until cooked 3)"));
        mExampleList.add(new RecipeItem(R.drawable.fries, "French Fries", "Ingredients: potatoes, salt, oil", "Steps: \n" +
                "1) cut potatoes into 1/2 inch thick strips\n2) pat dry with paper towels\n 3) deep fry until golden and sprinkle with salt"));
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RecipeAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }


}

