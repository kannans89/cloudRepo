package com.techlabs.paresh.expensemanager;


import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import static android.widget.GridLayout.HORIZONTAL;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    public ExpenseService service;
    List<Expense> expenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = new ExpenseService(getApplicationContext());
        expenses = service.getExpenses();

        recyclerView = findViewById(R.id.recycler);
        try {

            adapter = new Adapter(expenses, recyclerView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        adapter.setSvc(service);
        Intent intent = new Intent(getApplicationContext(), UpdateActivity.class);
        adapter.setIntent(intent);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String amount = data.getStringExtra("amount");
                String description = data.getStringExtra("description");
                String date = data.getStringExtra("date");
                String category = data.getStringExtra("category");
                int id = service.getLength();
                id++;
                Expense expense = new Expense(date, Integer.parseInt(amount), description, category, id);
                service.addExpense(expense);
//                expenses.clear();
                expenses=service.getExpenses();
                adapter.updateExpenseList(expenses);


            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        } else if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                Log.d("req code", "2");
                String amount = data.getStringExtra("amount");
                String description = data.getStringExtra("description");
                String date = data.getStringExtra("date");
                String category = data.getStringExtra("category");
                String id = data.getStringExtra("id");

                try {
                    service.updateExpense(amount, description, date, category, id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                expenses=service.getExpenses();
                adapter.updateExpenseList(expenses);


            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
            if (resultCode == Activity.RESULT_FIRST_USER) {

                String id = data.getStringExtra("id");
                Log.d("delete", "del"+id);
                service.deleteExpense(id);
                expenses=service.getExpenses();
                adapter.updateExpenseList(expenses);
            }
        }
    }

}
