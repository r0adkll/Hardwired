package com.r0adkll.hardwired.ui.model;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ftinc.kit.font.Face;
import com.ftinc.kit.font.FontLoader;
import com.ftinc.kit.util.BuildUtils;
import com.r0adkll.hardwired.AppComponent;
import com.r0adkll.hardwired.HardwiredApp;
import com.r0adkll.hardwired.R;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import pocketknife.PocketKnife;
import rx.Observable;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.screens
 * Created by drew.heavner on 1/13/16.
 */
public abstract class BaseActivity extends RxAppCompatActivity{

    /***********************************************************************************************
     *
     * Variables
     *
     */

    private Toolbar mAppBar;

    /***********************************************************************************************
     *
     * Lifecycle Methods
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setupComponent(HardwiredApp.get(this));
        super.onCreate(savedInstanceState);
        PocketKnife.bindExtras(this);
        PocketKnife.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        getAppBar();
        checkShadow();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PocketKnife.saveInstanceState(this, outState);
    }

    /**
     * Bind an observable to this activities lifecycle
     *
     * @param observable        the observable to bind
     */
    public <T> Observable<T> bindObservable(Observable<T> observable) {
        return observable.compose(bindToLifecycle());
    }

    public void showSnackBar(String msg){
        Snackbar.make(getWindow().getDecorView().getRootView(), msg, Snackbar.LENGTH_SHORT).show();
    }

    public void showSnackBar(@StringRes int resId){
        Snackbar.make(getWindow().getDecorView().getRootView(), resId, Snackbar.LENGTH_SHORT).show();
    }

    /***********************************************************************************************
     *
     * Helper Methods
     *
     */

    @SuppressLint("NewApi")
    @ColorInt
    protected int color(@ColorRes int resId){
        if(BuildUtils.isMarshmellow()){
            return getColor(resId);
        }else {
            return getResources().getColor(resId);
        }
    }

    @SuppressLint("NewApi")
    protected Drawable drawable(@DrawableRes int resId){
        if(BuildUtils.isLollipop()) {
            return getDrawable(resId);
        }else{
            return getResources().getDrawable(resId);
        }
    }

    /***********************************************************************************************
     *
     * Base Methods
     *
     */

    private void checkShadow(){
        View compatShadow = ButterKnife.findById(this, R.id.compat_shadow);
        if(compatShadow != null){
            compatShadow.setVisibility(BuildUtils.isLollipop() ? View.GONE : View.VISIBLE);
        }
    }

    /**
     * Get the {@link Toolbar} from the layout automatically if it exists
     *
     * @return      the toolbar in the layout
     */
    protected Toolbar getAppBar() {
        if(this.mAppBar == null) {
            this.mAppBar = ButterKnife.findById(this, R.id.appbar);
            if(this.mAppBar != null) {
                this.setSupportActionBar(this.mAppBar);

                // FIXME: 9/6/15 This is a Dirty, Dirty Hack. I Should feel bad, but Google should properly style their compatibility elements >:(
                if(!BuildUtils.isLollipop()) {
                    for (int i = 0; i < mAppBar.getChildCount(); i++) {
                        View child = mAppBar.getChildAt(i);
                        if (child instanceof TextView) {
                            TextView title = (TextView) child;
                            FontLoader.apply(title, Face.ROBOTO_MEDIUM);
                        }
                    }
                }

            }
        }

        return this.mAppBar;
    }

    /**
     * Override this method to setup the component/subcomponent
     * for the subclassed activity
     *
     * @param appGraph      the application graph to inject with
     */
    protected abstract void setupComponent(AppComponent appGraph);

}
