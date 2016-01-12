package com.r0adkll.hardwired.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

import com.ftinc.kit.util.RxUtils;
import com.ftinc.kit.widget.EmptyView;
import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.data.OpenHardwareMonitor;
import com.r0adkll.hardwired.ui.adapter.ComponentRecyclerAdapter;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


import org.lucasr.twowayview.widget.StaggeredGridLayoutManager;
import org.lucasr.twowayview.widget.TwoWayView;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui
 * Created by drew.heavner on 1/11/16.
 */
public class Hardwired extends RxAppCompatActivity {

    /***********************************************************************************************
     *
     * Variables
     *
     */

    @Bind(R.id.twowayview)
    TwoWayView recycler;

    @Bind(R.id.empty_layout)
    EmptyView emptyLayout;

    private ComponentRecyclerAdapter adapter;

    /***********************************************************************************************
     *
     * Lifecycle Methods
     *
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardwired);
        ButterKnife.bind(this);

        adapter = new ComponentRecyclerAdapter();
        recycler.setAdapter(adapter);
        adapter.setEmptyView(emptyLayout);

        RecyclerView.ItemAnimator animator = recycler.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();


        OpenHardwareMonitor.readTest()
                .delay(5, TimeUnit.SECONDS)
                .repeat()
                .compose(RxUtils.applyIOSchedulers())
                .compose(bindToLifecycle())
                .subscribe(computer -> {
                    Timber.d("Updating Computer");
                    adapter.clear();
                    adapter.addAll(computer.components);
                    adapter.notifyDataSetChanged();
                }, throwable -> {
                    Timber.e(throwable, "Something went wrong");
                    Snackbar.make(recycler, throwable.getLocalizedMessage(), Snackbar.LENGTH_SHORT).show();
                });
    }
}
