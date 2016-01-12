package com.r0adkll.hardwired.ui.adapter.delegates;

import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.data.model.Component;
import com.r0adkll.hardwired.data.model.MOBO;
import com.r0adkll.hardwired.ui.adapter.ComponentDelegate;
import com.r0adkll.hardwired.ui.adapter.ComponentViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.adapter
 * Created by drew.heavner on 1/11/16.
 */
public class MotherboardDelegate extends ComponentDelegate<MOBO, MotherboardDelegate.MotherboardViewHolder> {


    /***********************************************************************************************
     *
     * Variables
     *
     */

    /**
     * Constructor
     */
    public MotherboardDelegate() {
        super(Component.MOTHERBOARD, MOBO.class);
    }

    /***********************************************************************************************
     * Delegate Methods
     */

    @Override
    public MotherboardViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return new MotherboardViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(MotherboardViewHolder viewHolder, MOBO item, int position) {
        viewHolder.bindData(item);
    }

    /***********************************************************************************************
     * View Holder
     */

    static class MotherboardViewHolder extends ComponentViewHolder<MOBO> {

        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.card)
        CardView card;

        public MotherboardViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater, parent, R.layout.item_layout_motherboard);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public int getColumnSpan() {
            return 2;
        }

        @Override
        protected void bind(MOBO item) {
            title.setText(item.title);
        }
    }
}
