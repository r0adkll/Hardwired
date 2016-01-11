package com.r0adkll.hardwired.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates.AdapterDelegate;
import com.r0adkll.hardwired.data.model.Component;
import com.r0adkll.hardwired.data.model.Component.Components;

import java.util.List;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.adapter
 * Created by drew.heavner on 1/11/16.
 */
public abstract class ComponentDelegate<VH extends RecyclerView.ViewHolder> implements AdapterDelegate<List<Component>> {

    @Components
    protected int viewType = Component.UNKNOWN;

    protected ComponentDelegate(@Components int viewType){
        this.viewType = viewType;
    }

    /***********************************************************************************************
     *
     * Delegate Methods
     *
     */

    @Override
    public int getItemViewType() {
        return viewType;
    }

    @Override
    public boolean isForViewType(@NonNull List<Component> items, int position) {
        return items.get(position).getType() == viewType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return onCreateViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(@NonNull List<Component> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        onBindViewHolder((VH) holder, items.get(position), position);
    }

    /***********************************************************************************************
     *
     * Abstract Methods
     *
     */

    public abstract VH onCreateViewHolder(LayoutInflater inflater, ViewGroup parent);

    public abstract void onBindViewHolder(VH viewHolder, Component item, int position);

}
