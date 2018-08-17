


package com.techlabs.paresh.expensemanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class ExpenseService extends AppCompatActivity {
    List<Expense> expenses = new ArrayList<>();

    int count;
    Context context;
    SharedPreferences pref;

    public ExpenseService(Context context) {
        this.context = context;
        pref = context.getSharedPreferences("Expense_list1", 0);
    }

    public void addExpense(Expense e) {
        expenses = getExpenses();
        expenses.add(e);
        Gson gson = new Gson();
        String json = gson.toJson(expenses);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("expenses", json);
        editor.commit();
    }

    public List<Expense> getExpenses() {

        Gson gson = new Gson();
        String json = pref.getString("expenses", "null");
        if (!json.equals("null")) {
            Type type = new TypeToken<List<Expense>>() {
            }.getType();
            List<Expense> e = gson.fromJson(json, type);
            expenses = e;
        } else {
            expenses = new ArrayList<>();
        }
        return expenses;
    }

    public int getLength() {
        return expenses.size();
    }

    public void deleteExpense(String id) {
        int count=0;
        int del=0;
        expenses = getExpenses();
        for(Expense expense:expenses){

            if(expense.getId().equals(id)){
                del=count;
            }
            count++;
        }
//        Log.d("IDTO DELETE",""+idToDelete);
        expenses.remove(del);
        Gson gson = new Gson();
        String json = gson.toJson(expenses);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("expenses", json);
        editor.commit();
    }

    public void updateExpense(String amount, String description, String date, String category, String id) {
        expenses = getExpenses();
        for (Expense expense : expenses) {

            if (expense.getId().equals(id)) {
                expense.setId(Integer.parseInt(id));
                expense.setAmount(Integer.parseInt(amount));
                expense.setCategory(category);
                expense.setDate(date);
                expense.setDescription(description);
            }
        }
        Gson gson = new Gson();
        String json = gson.toJson(expenses);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("expenses", json);
        editor.commit();
    }
}

