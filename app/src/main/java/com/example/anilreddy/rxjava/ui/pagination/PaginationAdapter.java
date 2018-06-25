package com.example.anilreddy.rxjava.ui.pagination;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anilreddy.rxjava.R;

import java.util.ArrayList;
import java.util.List;

class PaginationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<String> items = new ArrayList<>();

    public PaginationAdapter() {

    }

    void addItems(List<String> items) {
        this.items.addAll(items);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ItemViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder) holder).bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(View itemView) {
            super(itemView);
        }

        static ItemViewHolder create(ViewGroup parent) {
            return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pagination, parent, false));
        }

        void bind(String context) {
            ((TextView) itemView).setText(context);
        }
    }

}
