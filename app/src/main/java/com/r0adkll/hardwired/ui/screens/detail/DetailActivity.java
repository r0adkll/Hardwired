package com.r0adkll.hardwired.ui.screens.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

import com.ftinc.kit.util.RxUtils;
import com.ftinc.kit.widget.EmptyView;
import com.r0adkll.hardwired.AppComponent;
import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.data.model.Component;
import com.r0adkll.hardwired.data.model.Computer;
import com.r0adkll.hardwired.ui.model.BaseActivity;
import com.r0adkll.hardwired.ui.screens.detail.adapter.ComponentRecyclerAdapter;

import org.lucasr.twowayview.widget.TwoWayView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.Bind;
import pocketknife.BindExtra;
import pocketknife.SaveState;
import timber.log.Timber;

public class DetailActivity extends BaseActivity implements DetailView {

    /***********************************************************************************************
     *
     * Static Intent Creators
     *
     */

    public static Intent createIntent(Context ctx, Computer computer){
        Intent intent = new Intent(ctx, DetailActivity.class);
        intent.putExtra(EXTRA_COMPUTER, computer);
        return intent;
    }

    /***********************************************************************************************
     *
     * Constants
     *
     */

    public static final String EXTRA_COMPUTER = "com.r0adkll.hardwired.intent.EXTRA_COMPUTER";

    /***********************************************************************************************
     *
     * Variables
     *
     */

    @Bind(R.id.twowayview)
    TwoWayView recycler;

    @Bind(R.id.empty_layout)
    EmptyView emptyLayout;

    @SaveState
    @BindExtra(EXTRA_COMPUTER)
    Computer computer;

    @Inject
    DetailPresenter presenter;

    private ComponentRecyclerAdapter adapter;

    /***********************************************************************************************
     *
     * Lifecycle Methods
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.connect(computer);
    }

    /***********************************************************************************************
     *
     * Helper Methods
     *
     */

    private void init(){
        adapter = new ComponentRecyclerAdapter();
        recycler.setAdapter(adapter);
        adapter.setEmptyView(emptyLayout);

        RecyclerView.ItemAnimator animator = recycler.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
    }


    /***********************************************************************************************
     *
     * Base Methods
     *
     */

    @Override
    protected void setupComponent(AppComponent graph) {
        graph.plus(new DetailModule(this))
                .inject(this);
    }

    /***********************************************************************************************
     *
     * View Methods
     *
     */

    @Override
    public void updateComponents(List<Component> components) {
        adapter.clear();
        adapter.addAll(components);
        adapter.notifyDataSetChanged();
    }


}
