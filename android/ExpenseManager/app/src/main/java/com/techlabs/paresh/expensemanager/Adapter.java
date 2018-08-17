package com.techlabs.paresh.expensemanager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivityForResult;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private static List<Expense> expenses=new ArrayList<>();
    RecyclerView recycle;
    ExpenseService svc;
    Intent intent;

    public void setSvc(ExpenseService svc) {
        this.svc = svc;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView date, category, amount, description;
        private final Context context;
        private final View.OnClickListener mOnClickListener = new
                View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Intent intent;
                        intent =  new Intent(context, UpdateActivity.class);
                        Expense e = expenses.get(getAdapterPosition());
                        intent.putExtra("id",e.getId());
                        intent.putExtra("date",e.getDate());
                        intent.putExtra("amount",e.getAmount().substring(3));
                        intent.putExtra("description",e.getDescription());
                        intent.putExtra("category",e.getCategory());
                        Log.d("click", e.getAmount());
                        ((Activity) context).startActivityForResult(intent, 2);
                    }
                };

        public ViewHolder(View v) {
            super(v);
            context = v.getContext();
            category = v.findViewById(R.id.category);
            date = v.findViewById(R.id.date);
            amount = v.findViewById(R.id.amount);
            description = v.findViewById(R.id.description);
            v.setClickable(true);
            v.setOnClickListener(mOnClickListener);
        }

    }

    public Adapter(List<Expense> myDataset, RecyclerView recycler) {
        expenses = myDataset;
        recycle = recycler;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_template, parent, false);
        return new ViewHolder(itemView);
    }
    public void updateExpenseList(List<Expense> newlist) {
        expenses.clear();
        expenses.addAll(newlist);
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Expense expense = expenses.get(position);

        holder.date.setText(expense.getDate());
        holder.description.setText(expense.getDescription());
        holder.category.setText(expense.getCategory());
        holder.amount.setText(expense.getAmount());

    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }
}
