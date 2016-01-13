package com.r0adkll.hardwired.ui.screens.detail.adapter;

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
 * Package: com.r0adkll.hardwired.ui.screens.detail.adapter
 * Created by drew.heavner on 1/11/16.
 */
public abstract class ComponentDelegate<T extends Component, VH extends ComponentViewHolder<T>> implements AdapterDelegate<List<Component>> {

    @Components
    protected int viewType = Component.UNKNOWN;

    protected Class<T> clazz;

    protected ComponentDelegate(int viewType, Class<T> clazz){
        this.viewType = viewType;
        this.clazz = clazz;
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
        int itemType = items.get(position).getType();
        return (viewType & itemType) == itemType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return onCreateViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(@NonNull List<Component> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        onBindViewHolder((VH) holder, items.get(position).getComponent(clazz), position);
    }

    /***********************************************************************************************
     *
     * Abstract Methods
     *
     */

    public abstract VH onCreateViewHolder(LayoutInflater inflater, ViewGroup parent);

    public abstract void onBindViewHolder(VH viewHolder, T item, int position);

}
