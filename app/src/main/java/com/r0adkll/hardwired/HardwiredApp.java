package com.r0adkll.hardwired;

import android.app.Application;
import android.app.Service;
import android.content.Context;

import com.r0adkll.hardwired.data.DataModule;

import ollie.Ollie;
import timber.log.Timber;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired
 * Created by drew.heavner on 1/11/16.
 */
public class HardwiredApp extends Application {

    /***********************************************************************************************
     *
     * Constants
     *
     */

    public static final String DB_NAME = "hardwired.db";
    public static final int DB_VERSION = 1;

    /***********************************************************************************************
     *
     * Variables
     *
     */

    private AppComponent component;

    /***********************************************************************************************
     *
     * Lifecycle Methods
     *
     */

    @Override
    public void onCreate() {
        super.onCreate();

        Ollie.init(this, DB_NAME, DB_VERSION, Ollie.LogLevel.BASIC);

        setupLogging();
        setupDagger();

    }

    private void setupDagger(){
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule())
                .build();
        component.inject(this);
    }

    private void setupLogging(){

        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }else{
            // TODO: 1/11/16 Implement Crashlytics Tree

        }
    }


    /***********************************************************************************************
     *
     * Dagger Methods
     *
     */

    public static AppComponent get(Context ctx){
        return ((HardwiredApp) ctx.getApplicationContext()).component;
    }

    public static AppComponent get(Service ctx){
        return ((HardwiredApp) ctx.getApplication()).component;
    }

}
