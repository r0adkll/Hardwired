package com.r0adkll.hardwired.ui.screens.detail.adapter.delegates;

import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.data.model.Clock;
import com.r0adkll.hardwired.data.model.Component;
import com.r0adkll.hardwired.data.model.Fan;
import com.r0adkll.hardwired.data.model.GPU;
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
public class GraphicsDelegate extends ComponentDelegate<GPU, GraphicsDelegate.GraphicsViewHolder> {

    public GraphicsDelegate() {
        super(Component.GRAPHICS, GPU.class);
    }

    /***********************************************************************************************
     * Delegate Methods
     */

    @Override
    public GraphicsViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return new GraphicsViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(GraphicsViewHolder viewHolder, GPU item, int position) {
        viewHolder.bindData(item);
    }


    /***********************************************************************************************
     * ViewHolder
     */

    static class GraphicsViewHolder extends ComponentViewHolder<GPU> {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.load_total)
        TextView loadTotal;

        @BindView(R.id.core_clock_speed)
        TextView coreClockSpeed;
        @BindView(R.id.memory_clock_speed)
        TextView memoryClockSpeed;
        @BindView(R.id.temperature)
        TextView temperature;
        @BindView(R.id.fan_speed)
        TextView fanSpeed;

        @BindView(R.id.card)
        CardView card;

        public GraphicsViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater, parent, R.layout.item_layout_graphics);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public int getColumnSpan() {
            return 2;
        }

        @Override
        protected void bind(GPU item) {

            title.setText(item.title);

            Load load = item.getLoad();
            if(load != null){
                loadTotal.setText(String.format("%.1f%%", load.getValue()));
            }

            Clock core = item.getCoreClock();
            if(core != null){
                coreClockSpeed.setText(core.value);
            }else{
                coreClockSpeed.setText(R.string.n_a);
            }

            Clock memory = item.getMemoryClock();
            if(memory != null){
                memoryClockSpeed.setText(memory.value);
            }else{
                memoryClockSpeed.setText(R.string.n_a);
            }

            Temperature temp = item.getTemperature();
            if(temp != null){
                temperature.setText(temp.value);
            }else{
                temperature.setText(R.string.n_a);
            }

            Fan fan = item.getFan();
            if (fan != null) {
                fanSpeed.setText(fan.value);
            }else{
                fanSpeed.setText(R.string.n_a);
            }

        }
    }
}
