package com.r0adkll.hardwired.ui.screens.detail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.f2prateek.rx.preferences.Preference;
import com.ftinc.kit.util.RxUtils;
import com.ftinc.kit.widget.EmptyView;
import com.r0adkll.hardwired.AppComponent;
import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.data.model.Component;
import com.r0adkll.hardwired.data.model.Computer;
import com.r0adkll.hardwired.ui.model.BaseActivity;
import com.r0adkll.hardwired.ui.screens.detail.adapter.ComponentRecyclerAdapter;
import com.r0adkll.hardwired.util.qualifiers.RefreshInterval;
import com.r0adkll.hardwired.util.qualifiers.ScreenLock;

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

    @Bind(R.id.recycler)
    RecyclerView recycler;

    @Bind(R.id.empty_layout)
    EmptyView emptyLayout;

    @SaveState
    @BindExtra(EXTRA_COMPUTER)
    Computer computer;

    @Inject
    DetailPresenter presenter;

    @Inject @RefreshInterval
    Preference<Long> refreshIntervalPreference;

    @Inject @ScreenLock
    Preference<Boolean> screenLockPreference;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        long interval = refreshIntervalPreference.get();
        switch ((int) interval){
            case 1:
                menu.findItem(R.id.refresh_1sec).setChecked(true);
                break;
            case 2:
                menu.findItem(R.id.refresh_2sec).setChecked(true);
                break;
            case 3:
                menu.findItem(R.id.refresh_3sec).setChecked(true);
                break;
            case 4:
                menu.findItem(R.id.refresh_4sec).setChecked(true);
                break;
            case 5:
                menu.findItem(R.id.refresh_5sec).setChecked(true);
        }

        MenuItem screenLock = menu.findItem(R.id.action_screen_lock);
        screenLock.setIcon(screenLockPreference.get() ?
                R.drawable.ic_lock_white_24dp : R.drawable.ic_lock_open_white_24dp);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()){
            case R.id.refresh_1sec:
                presenter.updateRefreshInterval(1);
                return true;
            case R.id.refresh_2sec:
                presenter.updateRefreshInterval(2);
                return true;
            case R.id.refresh_3sec:
                presenter.updateRefreshInterval(3);
                return true;
            case R.id.refresh_4sec:
                presenter.updateRefreshInterval(4);
                return true;
            case R.id.refresh_5sec:
                presenter.updateRefreshInterval(5);
                return true;
            case R.id.action_screen_lock:
                boolean isScreenLocked = screenLockPreference.get();
                screenLockPreference.set(!isScreenLocked);
                supportInvalidateOptionsMenu();

                if(isScreenLocked){
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                }else{
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                }

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /***********************************************************************************************
     *
     * Helper Methods
     *
     */

    private void init(){
        getSupportActionBar().setTitle(computer.name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getAppBar().setNavigationOnClickListener(v -> {
            supportFinishAfterTransition();
        });

        GridLayoutManager layoutManager = new GridLayoutManager(this, getResources().getInteger(R.integer.grid_columns));
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Component cmp = adapter.getItem(position);
                switch (cmp.getType()){
                    case Component.MOTHERBOARD:
                        return getResources().getInteger(R.integer.grid_columns);
                    case Component.CPU:
                    case Component.GRAPHICS:
                        return 2;
                    case Component.HDD:
                    case Component.SSD:
                    case Component.MEMORY:
                        return 1;
                }
                return 1;
            }
        });

        adapter = new ComponentRecyclerAdapter();
        adapter.setEmptyView(emptyLayout);

        recycler.setAdapter(adapter);
        recycler.setLayoutManager(layoutManager);

        RecyclerView.ItemAnimator animator = recycler.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }

        if (screenLockPreference.get()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
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
