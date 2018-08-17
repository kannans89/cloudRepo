package com.techlabs.paresh.recyclerview;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<String> items;
    RecyclerView recycle;
    Context context;

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int itemPosition = recycle.getChildLayoutPosition(view);
            String item = items.get(itemPosition);
            Toast.makeText(context, "You clicked "+item,
                    Toast.LENGTH_SHORT).show();
        }
    };
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public ViewHolder(View v) {
            super(v);
            text = v.findViewById(R.id.textView);
        }
    }

    public ItemAdapter(List<String> myDataset,RecyclerView recycler,Context context) {
        items = myDataset;
        recycle=recycler;
        this.context=context;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_template, parent, false);
        itemView.setOnClickListener(mOnClickListener);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.text.setText(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
