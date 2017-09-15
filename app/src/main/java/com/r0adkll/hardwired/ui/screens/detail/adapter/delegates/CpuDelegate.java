package com.r0adkll.hardwired.ui.screens.detail.adapter.delegates;

import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.data.model.CPU;
import com.r0adkll.hardwired.data.model.Component;
import com.r0adkll.hardwired.data.model.Load;
import com.r0adkll.hardwired.ui.screens.detail.adapter.ComponentDelegate;
import com.r0adkll.hardwired.ui.screens.detail.adapter.ComponentViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.screens.detail.adapter.delegates
 * Created by drew.heavner on 1/11/16.
 */
public class CpuDelegate extends ComponentDelegate<CPU, CpuDelegate.CpuViewHolder> {

    public CpuDelegate() {
        super(Component.CPU, CPU.class);
    }

    /***********************************************************************************************
     * Delegate Methods
     */

    @Override
    public CpuViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return new CpuViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(CpuViewHolder viewHolder, CPU item, int position) {
        viewHolder.bindData(item);
    }

    /***********************************************************************************************
     * ViewHolder
     */

    public static class CpuViewHolder extends ComponentViewHolder<CPU> {

        @BindView(R.id.title)
        TextView title;

        @BindView(R.id.load_total)
        TextView loadTotal;

        @BindView(R.id.cores_layout)
        LinearLayout coresLayout;

        @BindView(R.id.card)
        CardView card;

        public CpuViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater, parent, R.layout.item_layout_cpu);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public int getColumnSpan() {
            return 2;
        }

        @Override
        protected void bind(CPU item) {
            title.setText(item.title);

            Load total = item.getTotalLoad();
            if(total != null){
                loadTotal.setText(String.format("%.1f%%", total.getValue()));
            }

            coresLayout.removeAllViews();
            List<Load> cores = item.getCoreLoads();
            for (Load core : cores) {
                CoreViewHolder vh = new CoreViewHolder(inflater, coresLayout);
                vh.bind(core);
                coresLayout.addView(vh.itemView);
            }

        }

        static class CoreViewHolder{

            View itemView;

            TextView title, load;
            ProgressBar progress;

            public CoreViewHolder(LayoutInflater inflater, ViewGroup parent){
                itemView = inflater.inflate(R.layout.item_layout_cpu_core, parent, false);
                title = ButterKnife.findById(itemView, R.id.title);
                load = ButterKnife.findById(itemView, R.id.load);
                progress = ButterKnife.findById(itemView, R.id.progress);
            }

            public void bind(Load item){
                title.setText(item.getLabel());
                load.setText(item.value);

                int _progress = (int) item.getValue();
                progress.setProgress(_progress);
            }

        }


    }

}
