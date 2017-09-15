package com.r0adkll.hardwired.ui.screens.detail.adapter.delegates;

import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.data.model.Component;
import com.r0adkll.hardwired.data.model.HDD;
import com.r0adkll.hardwired.data.model.Load;
import com.r0adkll.hardwired.data.model.Temperature;
import com.r0adkll.hardwired.ui.screens.detail.adapter.ComponentDelegate;
import com.r0adkll.hardwired.ui.screens.detail.adapter.ComponentViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.screens.detail.adapter.delegates
 * Created by drew.heavner on 1/11/16.
 */
public class StorageDelegate extends ComponentDelegate<HDD, StorageDelegate.GraphicsViewHolder> {

    public StorageDelegate() {
        super(Component.HDD | Component.SSD, HDD.class);
    }

    /***********************************************************************************************
     * Delegate Methods
     */

    @Override
    public GraphicsViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return new GraphicsViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(GraphicsViewHolder viewHolder, HDD item, int position) {
        viewHolder.bindData(item);
    }

    /***********************************************************************************************
     * ViewHolder
     */

    static class GraphicsViewHolder extends ComponentViewHolder<HDD> {


        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.load_total)
        TextView loadTotal;
        @BindView(R.id.temperature)
        TextView temperature;
        @BindView(R.id.card)
        CardView card;

        public GraphicsViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater, parent, R.layout.item_layout_storage);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public int getColumnSpan() {
            return 1;
        }

        @Override
        protected void bind(HDD item) {
            title.setText(item.title);

            Load load = item.getLoad();
            if(load != null){
                loadTotal.setText(String.format("%.1f%%", load.getValue()));
            }

            Temperature temp = item.getTemperature();
            if(temp != null){
                temperature.setText(temp.value);
            }else{
                temperature.setText(R.string.n_a);
            }

        }
    }
}
