package com.r0adkll.hardwired.ui.screens.directory;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ftinc.kit.adapter.BetterRecyclerAdapter;
import com.ftinc.kit.widget.EmptyView;
import com.r0adkll.hardwired.AppComponent;
import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.data.model.Computer;
import com.r0adkll.hardwired.ui.dialog.AddComputerDialog;
import com.r0adkll.hardwired.ui.model.BaseActivity;
import com.r0adkll.hardwired.ui.screens.detail.DetailActivity;
import com.r0adkll.hardwired.ui.screens.directory.adapter.ComputerRecyclerAdapter;
import com.r0adkll.hardwired.ui.screens.screens.SettingsActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import timber.log.Timber;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui
 * Created by drew.heavner on 1/12/16.
 */
public class DirectoryActivity extends BaseActivity implements DirectoryView,
        BetterRecyclerAdapter.OnItemClickListener<Computer>,
        AddComputerDialog.AddComputerInterface {

    /***********************************************************************************************
     *
     * Static Intent Creators
     *
     */



    /***********************************************************************************************
     *
     * Constants
     *
     */



    /***********************************************************************************************
     *
     * Variables
     *
     */

    @BindView(R.id.recycler) RecyclerView recycler;
    @BindView(R.id.empty_view) EmptyView emptyView;
    @BindView(R.id.action_add) FloatingActionButton actionAdd;

    @Inject DirectoryPresenter presenter;

    private ComputerRecyclerAdapter adapter;

    /***********************************************************************************************
     *
     * Lifecycle Methods
     *
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_directory, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_settings){
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadComputers();

        // Register connectivity listener
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mConnectivityReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mConnectivityReceiver);
    }

    /***********************************************************************************************
     *
     * Helper Methods
     *
     */

    /**
     * Initialize this activity by setting up the initial state of all
     * the needed view elements
     */
    private void init(){
        adapter = new ComputerRecyclerAdapter(this);
        adapter.setEmptyView(emptyView);
        adapter.setOnItemClickListener(this);

        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    /***********************************************************************************************
     *
     * Listener Methods
     *
     */

    @OnClick(R.id.action_add)
    void onAddClicked(){
        // Show dialog to prompt user to enter IP + Port
        new AddComputerDialog()
                .show(getSupportFragmentManager(), "add-computer");
    }

    @Override
    public void onItemClick(View v, Computer item, int position) {
        // Open the hardwired activity
        Intent intent = DetailActivity.createIntent(this, item);
        startActivity(intent);
    }

    @Override
    public void subscribe(Observable<Computer> observable) {
        observable.compose(bindToLifecycle())
                .subscribe(computer -> {
                    presenter.loadComputers();
                });
    }

    private BroadcastReceiver mConnectivityReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Timber.d("Connectivity Change!");
            adapter.notifyDataSetChanged();
        }
    };

    /***********************************************************************************************
     *
     * Base Methods
     *
     */

    @Override
    protected void setupComponent(AppComponent appGraph) {
        appGraph.plus(new DirectoryModule(this))
                .inject(this);
    }

    /***********************************************************************************************
     *
     * View Methods
     *
     */

    @Override
    public void updateComputers(List<Computer> computers) {
        adapter.clear();
        adapter.addAll(computers);
        adapter.notifyDataSetChanged();
    }



}
