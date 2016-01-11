package com.r0adkll.hardwired.ui.adapter.delegates;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.data.model.Component;
import com.r0adkll.hardwired.ui.adapter.ComponentDelegate;

import butterknife.ButterKnife;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.adapter.delegates
 * Created by drew.heavner on 1/11/16.
 */
public class MemoryDelegate extends ComponentDelegate<MemoryDelegate.MemoryViewHolder> {

    public MemoryDelegate() {
        super(Component.MEMORY);
    }

    /***********************************************************************************************
     *
     * Delegate Methods
     *
     */

    @Override
    public MemoryViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return MemoryViewHolder.create(inflater, parent);
    }

    @Override
    public void onBindViewHolder(MemoryViewHolder viewHolder, Component item, int position) {
        viewHolder.bind(item);
    }

    /***********************************************************************************************
     *
     * ViewHolder
     *
     */

    static class MemoryViewHolder extends RecyclerView.ViewHolder{

        public static MemoryViewHolder create(LayoutInflater inflater, ViewGroup parent){
            View view = inflater.inflate(R.layout.item_layout_memory, parent, false);
            return new MemoryViewHolder(view);
        }

        public MemoryViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Component item){

        }

    }
}
