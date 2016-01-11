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
 * Package: com.r0adkll.hardwired.ui.adapter
 * Created by drew.heavner on 1/11/16.
 */
public class MotherboardDelegate extends ComponentDelegate<MotherboardDelegate.MotherboardViewHolder> {


    /***********************************************************************************************
     *
     * Variables
     *
     */

    /**
     * Constructor
     */
    public MotherboardDelegate() {
        super(Component.MOTHERBOARD);
    }

    /***********************************************************************************************
     *
     * Delegate Methods
     *
     */

    @Override
    public MotherboardViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return MotherboardViewHolder.create(inflater, parent);
    }

    @Override
    public void onBindViewHolder(MotherboardViewHolder viewHolder, Component item, int position) {
        viewHolder.bind(item);
    }

    /***********************************************************************************************
     *
     * View Holder
     *
     */

    static class MotherboardViewHolder extends RecyclerView.ViewHolder{

        public static MotherboardViewHolder create(LayoutInflater inflater, ViewGroup parent){
            View view = inflater.inflate(R.layout.item_layout_motherboard, parent, false);
            return new MotherboardViewHolder(view);
        }

        public MotherboardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Component component){

        }

    }
}
