package com.r0adkll.hardwired.ui.screens.detail.adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.r0adkll.hardwired.data.model.Component;

public abstract class ComponentViewHolder<T extends Component> extends RecyclerView.ViewHolder {

    protected LayoutInflater inflater;

    public ComponentViewHolder(LayoutInflater inflater, ViewGroup parent, @LayoutRes int layoutResId) {
        super(inflater.inflate(layoutResId, parent, false));
        this.inflater = inflater;
    }

    public abstract int getColumnSpan();
    protected abstract void bind(T item);

    public void bindData(T item){
        bind(item);
    }
}