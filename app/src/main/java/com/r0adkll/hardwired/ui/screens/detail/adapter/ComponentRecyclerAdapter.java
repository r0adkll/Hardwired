package com.r0adkll.hardwired.ui.screens.detail.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ftinc.kit.adapter.BetterRecyclerAdapter;
import com.hannesdorfmann.adapterdelegates.AdapterDelegatesManager;
import com.r0adkll.hardwired.data.model.Component;
import com.r0adkll.hardwired.ui.screens.detail.adapter.delegates.CpuDelegate;
import com.r0adkll.hardwired.ui.screens.detail.adapter.delegates.GraphicsDelegate;
import com.r0adkll.hardwired.ui.screens.detail.adapter.delegates.MemoryDelegate;
import com.r0adkll.hardwired.ui.screens.detail.adapter.delegates.MotherboardDelegate;
import com.r0adkll.hardwired.ui.screens.detail.adapter.delegates.StorageDelegate;

import java.util.List;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui
 * Created by drew.heavner on 1/11/16.
 */
public class ComponentRecyclerAdapter extends BetterRecyclerAdapter<Component, RecyclerView.ViewHolder> {

    /***********************************************************************************************
     *
     * Variables
     *
     */

    private AdapterDelegatesManager<List<Component>> delegatesManager;

    /**
     * Constructor
     */
    public ComponentRecyclerAdapter(){
        super();

        delegatesManager = new AdapterDelegatesManager<>();
        delegatesManager.addDelegate(new MotherboardDelegate());
        delegatesManager.addDelegate(new CpuDelegate());
        delegatesManager.addDelegate(new MemoryDelegate());
        delegatesManager.addDelegate(new GraphicsDelegate());
        delegatesManager.addDelegate(new StorageDelegate());

    }

    /***********************************************************************************************
     *
     * Adapter Methods
     *
     */

    @Override
    public int getItemViewType(int position) {
        return delegatesManager.getItemViewType(getItems(), position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        delegatesManager.onBindViewHolder(getItems(), i, viewHolder);
    }

    @Override
    public long getItemId(int position) {
        Component item = getItem(position);
        if(item != null) return item.id;
        return super.getItemId(position);
    }
}
