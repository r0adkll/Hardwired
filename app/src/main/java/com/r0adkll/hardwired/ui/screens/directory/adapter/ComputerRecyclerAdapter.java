package com.r0adkll.hardwired.ui.screens.directory.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ftinc.kit.adapter.BetterRecyclerAdapter;
import com.ftinc.kit.util.RxUtils;
import com.ftinc.kit.util.UIUtils;
import com.ftinc.kit.util.Utils;
import com.r0adkll.hardwired.HardwiredApp;
import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.data.OpenHardwareMonitor;
import com.r0adkll.hardwired.data.model.Computer;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.screens.detail.adapter
 * Created by drew.heavner on 1/12/16.
 */
public class ComputerRecyclerAdapter extends BetterRecyclerAdapter<Computer, ComputerRecyclerAdapter.ComputerViewHolder> {

    @Inject
    OpenHardwareMonitor monitor;

    private RxAppCompatActivity activity;

    public ComputerRecyclerAdapter(RxAppCompatActivity activity){
        super();
        this.activity = activity;
        HardwiredApp.get(activity).inject(this);
    }

    @Override
    public ComputerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ComputerViewHolder.create(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ComputerViewHolder computerViewHolder, int i) {
        super.onBindViewHolder(computerViewHolder, i);
        computerViewHolder.bind(activity, monitor, getItem(i));
    }

    static class ComputerViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.avatar)
        ImageView avatar;
        @Bind(R.id.line_1)
        TextView title;
        @Bind(R.id.line_2)
        TextView subtitle;

        public static ComputerViewHolder create(LayoutInflater inflater, ViewGroup parent) {
            View view = inflater.inflate(R.layout.layout_two_line_list_item_avatar, parent, false);
            return new ComputerViewHolder(view);
        }

        public ComputerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            title.setTextColor(UIUtils.getColorAttr(itemView.getContext(), android.R.attr.textColorPrimary));
            subtitle.setTextColor(UIUtils.getColorAttr(itemView.getContext(), android.R.attr.textColorSecondary));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
            params.leftMargin = Utils.dipToPx(itemView.getContext(), 16);
            avatar.setLayoutParams(params);
        }

        public void bind(RxAppCompatActivity activity, OpenHardwareMonitor monitor, Computer item) {
            title.setText(item.name);
            subtitle.setText(String.format("%s:%d", item.ipAddress, item.port));
            avatar.setImageResource(R.drawable.ic_lan_connect_black_24dp);
            avatar.setAlpha(0.56f);

            monitor.test(item.ipAddress, item.port)
                    .compose(activity.bindToLifecycle())
                    .compose(RxUtils.applyIOSchedulers())
                    .subscribe(computer -> {
                        avatar.setImageResource(R.drawable.ic_lan_connect_black_24dp);
                        avatar.clearColorFilter();
                    }, throwable -> {
                        avatar.setImageResource(R.drawable.ic_lan_disconnect_black_24dp);
                        avatar.setColorFilter(activity.getResources().getColor(R.color.red_600));
                    });

        }

    }

}
