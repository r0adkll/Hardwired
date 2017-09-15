package com.r0adkll.hardwired.ui.screens.detail.adapter;

import android.app.Activity;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.ListUpdateCallback;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates.AdapterDelegatesManager;
import com.r0adkll.hardwired.data.model.Component;
import com.r0adkll.hardwired.ui.screens.detail.adapter.delegates.CpuDelegate;
import com.r0adkll.hardwired.ui.screens.detail.adapter.delegates.GraphicsDelegate;
import com.r0adkll.hardwired.ui.screens.detail.adapter.delegates.MemoryDelegate;
import com.r0adkll.hardwired.ui.screens.detail.adapter.delegates.MotherboardDelegate;
import com.r0adkll.hardwired.ui.screens.detail.adapter.delegates.StorageDelegate;
import com.r0adkll.hardwired.util.ListRecyclerAdapter;

import java.util.List;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui
 * Created by drew.heavner on 1/11/16.
 */
public class ComponentRecyclerAdapter extends ListRecyclerAdapter<Component, RecyclerView.ViewHolder> {

    /***********************************************************************************************
     *
     * Variables
     *
     */

    private AdapterDelegatesManager<List<Component>> delegatesManager;

    /**
     * Constructor
     */
    public ComponentRecyclerAdapter(Activity activity){
        super(activity);

        delegatesManager = new AdapterDelegatesManager<>();
        delegatesManager.addDelegate(new MotherboardDelegate());
        delegatesManager.addDelegate(new CpuDelegate());
        delegatesManager.addDelegate(new MemoryDelegate());
        delegatesManager.addDelegate(new GraphicsDelegate());
        delegatesManager.addDelegate(new StorageDelegate());

    }

    public void setComponents(List<Component> components) {
        DiffUtil.DiffResult diff = DiffUtil.calculateDiff(new ComponentDiffCallback(items, components));
        items.clear();
        items.addAll(components);
        diff.dispatchUpdatesTo(new ComponentUpdateCallback());
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

    static class ComponentDiffCallback extends DiffUtil.Callback {

        private final List<Component> oldItems;
        private final List<Component> newItems;

        public ComponentDiffCallback(List<Component> oldItems, List<Component> newItems) {
            this.oldItems = oldItems;
            this.newItems = newItems;
        }

        @Override
        public int getOldListSize() {
            return oldItems.size();
        }

        @Override
        public int getNewListSize() {
            return newItems.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            Component oldItem = oldItems.get(oldItemPosition);
            Component newItem = newItems.get(newItemPosition);
            return oldItem.isSameItem(newItem);
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            Component oldItem = oldItems.get(oldItemPosition);
            Component newItem = newItems.get(newItemPosition);
            return oldItem.isContentSame(newItem);
        }
    }

    class ComponentUpdateCallback implements ListUpdateCallback {
        @Override
        public void onInserted(int position, int count) {
            notifyItemRangeInserted(position, count);
            checkIfEmpty();
        }

        @Override
        public void onRemoved(int position, int count) {
            notifyItemRangeRemoved(position, count);
            checkIfEmpty();
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
            notifyItemMoved(fromPosition, toPosition);
        }

        @Override
        public void onChanged(int position, int count, Object payload) {
            notifyItemRangeChanged(position, count, payload);
        }
    }
}
