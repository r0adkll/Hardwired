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
public class StorageDelegate extends ComponentDelegate<StorageDelegate.GraphicsViewHolder> {

    public StorageDelegate() {
        super(Component.GRAPHICS);
    }

    /***********************************************************************************************
     *
     * Delegate Methods
     *
     */

    @Override
    public GraphicsViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return GraphicsViewHolder.create(inflater, parent);
    }

    @Override
    public void onBindViewHolder(GraphicsViewHolder viewHolder, Component item, int position) {
        viewHolder.bind(item);
    }

    /***********************************************************************************************
     *
     * ViewHolder
     *
     */

    static class GraphicsViewHolder extends RecyclerView.ViewHolder{

        public static GraphicsViewHolder create(LayoutInflater inflater, ViewGroup parent){
            View view = inflater.inflate(R.layout.item_layout_storage, parent, false);
            return new GraphicsViewHolder(view);
        }

        public GraphicsViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Component item){

        }

    }
}
