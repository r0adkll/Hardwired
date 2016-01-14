package com.r0adkll.hardwired.ui.screens.directory.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ftinc.kit.adapter.BetterRecyclerAdapter;
import com.ftinc.kit.util.UIUtils;
import com.ftinc.kit.util.Utils;
import com.r0adkll.hardwired.data.model.Computer;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.screens.detail.adapter
 * Created by drew.heavner on 1/12/16.
 */
public class ComputerRecyclerAdapter extends BetterRecyclerAdapter<Computer, ComputerRecyclerAdapter.ComputerViewHolder> {

    @Override
    public ComputerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = new TextView(parent.getContext());
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        textView.setTextColor(UIUtils.getColorAttr(parent.getContext(), android.R.attr.textColorPrimary));
        int padding = Utils.dipToPx(parent.getContext(), 16);
        textView.setPadding(padding, padding, padding, padding);
        textView.setMinHeight(Utils.dipToPx(parent.getContext(), 56));
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setBackground(UIUtils.getSelectableItemBackground(parent.getContext()));
        return new ComputerViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(ComputerViewHolder computerViewHolder, int i) {
        super.onBindViewHolder(computerViewHolder, i);
        computerViewHolder.bind(getItem(i));
    }

    static class ComputerViewHolder extends RecyclerView.ViewHolder{

        TextView title;

        public ComputerViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView;
        }

        public void bind(Computer item){
            title.setText(item.name);
        }

    }

}
