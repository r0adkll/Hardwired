package com.r0adkll.hardwired.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.ftinc.kit.widget.EmptyView;
import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.ui.adapter.ComponentRecyclerAdapter;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


import org.lucasr.twowayview.widget.TwoWayView;

import butterknife.Bind;
import butterknife.ButterKnife;

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
    }



}
