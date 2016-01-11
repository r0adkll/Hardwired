package com.r0adkll.hardwired.ui.adapter.delegates;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.data.model.Component;
import com.r0adkll.hardwired.data.model.Component.Components;
import com.r0adkll.hardwired.ui.adapter.ComponentDelegate;

import butterknife.ButterKnife;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.adapter.delegates
 * Created by drew.heavner on 1/11/16.
 */
public class CpuDelegate extends ComponentDelegate<CpuDelegate.CpuViewHolder>{

    public CpuDelegate() {
        super(Component.CPU);
    }

    /***********************************************************************************************
     *
     * Delegate Methods
     *
     */

    @Override
    public CpuViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return CpuViewHolder.create(inflater, parent);
    }

    @Override
    public void onBindViewHolder(CpuViewHolder viewHolder, Component item, int position) {
        viewHolder.bind(item);
    }

    /***********************************************************************************************
     *
     * ViewHolder
     *
     */

    static class CpuViewHolder extends RecyclerView.ViewHolder{

        public static CpuViewHolder create(LayoutInflater inflater, ViewGroup parent){
            View view = inflater.inflate(R.layout.item_layout_cpu, parent, false);
            return new CpuViewHolder(view);
        }

        public CpuViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Component item){

        }

    }

}
