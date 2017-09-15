package com.r0adkll.hardwired.ui.screens.detail.adapter.delegates;

import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.data.model.Component;
import com.r0adkll.hardwired.data.model.Data;
import com.r0adkll.hardwired.data.model.Load;
import com.r0adkll.hardwired.data.model.RAM;
import com.r0adkll.hardwired.ui.screens.detail.adapter.ComponentDelegate;
import com.r0adkll.hardwired.ui.screens.detail.adapter.ComponentViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.screens.detail.adapter.delegates
 * Created by drew.heavner on 1/11/16.
 */
public class MemoryDelegate extends ComponentDelegate<RAM, MemoryDelegate.MemoryViewHolder> {

    public MemoryDelegate() {
        super(Component.MEMORY, RAM.class);
    }

    /***********************************************************************************************
     * Delegate Methods
     */

    @Override
    public MemoryViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return new MemoryViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(MemoryViewHolder viewHolder, RAM item, int position) {
        viewHolder.bindData(item);
    }

    /***********************************************************************************************
     * ViewHolder
     */

    static class MemoryViewHolder extends ComponentViewHolder<RAM> {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.load_total)
        TextView loadTotal;
        @BindView(R.id.usage)
        TextView usage;
        @BindView(R.id.card)
        CardView card;

        public MemoryViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater, parent, R.layout.item_layout_memory);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public int getColumnSpan() {
            return 1;
        }

        @Override
        protected void bind(RAM item) {

            title.setText(item.title);

            Load load = item.getLoad();
            if(load != null){
                loadTotal.setText(String.format("%.1f%%", load.getValue()));
            }

            Data used = item.getUsedMemory();
            if(used != null){
                usage.setText(String.format("%.1f GB / %.1f GB", used.getAmount(), item.getTotalMemory()));
            }else{
                usage.setText(R.string.n_a);
            }

        }
    }
}
