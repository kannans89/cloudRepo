package com.techlabs.paresh.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> items=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createItemSet();

        RecyclerView recyclerView=findViewById(R.id.recycler);
        ItemAdapter adapter=new ItemAdapter(items,recyclerView,getApplicationContext());

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    private void createItemSet() {
        items.add("Colgate");
        items.add("Sprite");
        items.add("Bread");
        items.add("Coke");
        items.add("Jam");
        items.add("Banana");
        items.add("Butter");
        items.add("Cheese");
        items.add("Tomatoes");
        items.add("Apple");
        items.add("Grapes");
        items.add("Sprite");
        items.add("Bread");
        items.add("Coke");
        items.add("Jam");
        items.add("Banana");
        items.add("Butter");
        items.add("Cheese");
        items.add("Tomatoes");
        items.add("Apple");
        items.add("Grapes");
        items.add("Sprite");
        items.add("Bread");
        items.add("Coke");
        items.add("Jam");
        items.add("Banana");
        items.add("Butter");
        items.add("Cheese");
        items.add("Tomatoes");
        items.add("Apple");
        items.add("Grapes");
    }
}
