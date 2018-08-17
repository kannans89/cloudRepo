package com.techlabs.paresh.numberapi;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class NumberAdapter extends RecyclerView.Adapter<com.techlabs.paresh.numberapi.NumberAdapter.ViewHolder> {
    private List<String> numbers;
    RecyclerView recycle;
    Context context;

//    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            int itemPosition = recycle.getChildLayoutPosition(view);
//            String item = numbers.get(itemPosition);
//            Toast.makeText(context, "You clicked "+item,
//                    Toast.LENGTH_SHORT).show();
//        }
//    };
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public ViewHolder(View v) {
            super(v);
            text = v.findViewById(R.id.fact);
        }
    }

    public NumberAdapter(List<String> myDataset,RecyclerView recycler) {
        numbers = myDataset;
        recycle=recycler;
    }

    @Override
    public com.techlabs.paresh.numberapi.NumberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                                        int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.numberi_api_template, parent, false);
//        itemView.setOnClickListener(mOnClickListener);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.text.setText(numbers.get(position));

    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public void dataSetUpdated(List<String> numbers){

        this.numbers=numbers;
        this.notifyDataSetChanged();
    }
}
