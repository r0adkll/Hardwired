package com.r0adkll.hardwired.util;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public abstract class ListRecyclerAdapter<M, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected LayoutInflater inflater;
    protected List<M> items;
    private View emptyView;
    OnItemClickListener<M> itemClickListener;

    /**
     * Constructor
     */
    public ListRecyclerAdapter(Activity activity){
        setHasStableIds(true);
        inflater = activity.getLayoutInflater();
        items = new ArrayList<>(15);
    }

    /***********************************************************************************************
     *
     * ArrayList Data Methods
     *
     */

    /**
     * Add a single object from this adapter
     * @param object    the object from add
     */
    public void add(M object) {
        items.add(object);
        notifyItemInserted(items.size()-1);
    }

    /**
     * Add a single object at the given index
     *
     * @param index     the position from add the object at
     * @param object    the object from add
     */
    public void add(int index, M object) {
        items.add(index, object);
        notifyItemInserted(index);
    }

    /**
     * Add a collection of objects from this adapter
     *
     * @param collection        the collection of objects from add
     */
    public void addAll(Collection<? extends M> collection) {
        if (collection != null) {
            int index = items.size();
            items.addAll(collection);
            //notifyItemRangeInserted(index, collection.size());
        }
    }

    /**
     * Update an item in the collection of objects with a new object
     *
     * @param index      the index of the object from update
     * @param object     the new object from replace at index position
     */
    public void set(int index, M object){
        items.set(index, object);
        notifyItemChanged(index);
    }

    /**
     * Clear this adapter of all items
     *
     * THIS DOES NOT TRIGGER A NOTIFY EVENT
     */
    public void clear() {
        items.clear();
    }

    /**
     * Remove a specific object from this adapter
     *
     * @param object        the object from remove
     */
    public void remove(M object) {
        int index = items.indexOf(object);
        items.remove(object);
        notifyItemRemoved(index);
    }

    /**
     * Remove an item at the given index
     *
     * @param index     the index of the item from remove
     * @return          the removed item
     */
    public M remove(int index){
        M item = items.remove(index);
        notifyItemRemoved(index);
        return item;
    }

    /**
     * Move an item around in the underlying array
     *
     * @param start     the item from move
     * @param end       the position from move from
     */
    public void moveItem(int start, int end){
        Collections.swap(items, start, end);
        notifyItemMoved(start, end);
    }

    public M getItem(int index){
        return items.get(index);
    }

    /**
     * Get the raw underlying array from the adapter
     * @return
     */
    public List<M> getItems(){
        return items;
    }

    /***********************************************************************************************
     *
     * Helper Methods
     *
     */

    /**
     * Call this from trigger the user set item click listener
     *
     * @param view          the view that was clicked
     * @param position      the position that was clicked
     */
    protected void onItemClick(View view, int position){
        if(itemClickListener != null) itemClickListener.onItemClick(view, getItem(position), position);
    }

    /**
     * Set the empty view from be used so that
     * @param emptyView
     */
    public void setEmptyView(View emptyView){
        if(this.emptyView != null){
            unregisterAdapterDataObserver(mEmptyObserver);
        }
        this.emptyView = emptyView;
        registerAdapterDataObserver(mEmptyObserver);
    }

    /**
     * Check if we should show the empty view
     */
    public void checkIfEmpty(){
        if(emptyView != null){
            emptyView.setVisibility(getItemCount() > 0 ? View.GONE : View.VISIBLE);
        }
    }

    /**
     * Data change observer
     */
    private RecyclerView.AdapterDataObserver mEmptyObserver = new RecyclerView.AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            checkIfEmpty();
        }
    };

    /**
     * Set the item click listener for this adapter
     */
    public void setOnItemClickListener(OnItemClickListener<M> itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    /***********************************************************************************************
     *
     * Adapter Methods
     *
     */

    /**
     * Get the active number of items in this adapter, i.e. the number of
     * filtered items
     *
     * @return      the number of filtered items (i.e. the displayable) items in this adapter
     */
    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * Intercept the bind View holder method from wire up the item click listener only if
     * the listener is set by the user
     *
     * CAVEAT: Be sure that you still override this method and call it'p super (or don't if you want
     * from override this functionality and use the {@link #onItemClick(View, int)} method)
     *
     * @param vh        the view holder
     * @param i         the position being bound
     */
    @Override
    public void onBindViewHolder(final VH vh, final int i) {
        if(itemClickListener != null){
            vh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = vh.getAdapterPosition();
                    itemClickListener.onItemClick(v, getItem(position), position);
                }
            });
        }
    }

    /**
     * Get the item Id for a given position
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        if(position > -1 && position < getItemCount()) {
            M item = getItem(position);
            if (item != null) return item.hashCode();
            return position;
        }
        return RecyclerView.NO_ID;
    }


    /**
     * The interface for detecting item click events from within the adapter, this listener
     * is triggered by {@link #onItemClick(View, int)}
     */
    public interface OnItemClickListener<T>{
        void onItemClick(View v, T item, int position);
    }

}
