package com.r0adkll.hardwired.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ftinc.kit.adapter.BetterRecyclerAdapter;
import com.ftinc.kit.widget.EmptyView;
import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.data.model.Computer;
import com.r0adkll.hardwired.ui.adapter.ComputerRecyclerAdapter;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui
 * Created by drew.heavner on 1/12/16.
 */
public class ComputersActivity extends RxAppCompatActivity implements BetterRecyclerAdapter.OnItemClickListener<Computer> {

    @Bind(R.id.recycler)
    RecyclerView recycler;
    @Bind(R.id.empty_view)
    EmptyView emptyView;
    @Bind(R.id.action_add)
    FloatingActionButton actionAdd;

    private ComputerRecyclerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computers);
        ButterKnife.bind(this);

        adapter = new ComputerRecyclerAdapter();
        adapter.setEmptyView(emptyView);
        adapter.setOnItemClickListener(this);

        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onItemClick(View v, Computer item, int position) {

        // Open the hardwired activity

    }
}
