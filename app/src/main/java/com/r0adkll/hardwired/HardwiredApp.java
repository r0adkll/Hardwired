package com.r0adkll.hardwired;

import android.app.Application;

import timber.log.Timber;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired
 * Created by drew.heavner on 1/11/16.
 */
public class HardwiredApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }else{
            // TODO: 1/11/16 Implement Crashlytics Tree

        }

    }
}
