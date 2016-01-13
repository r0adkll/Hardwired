package com.r0adkll.hardwired;

import android.content.Context;

import com.r0adkll.hardwired.HardwiredApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Project: Hardwired
 * Package: PACKAGE_NAME
 * Created by drew.heavner on 1/13/16.
 */
@Module
public class AppModule {

    private HardwiredApp app;

    public AppModule(HardwiredApp app){
        this.app = app;
    }

    @Provides @Singleton
    Context provideApplicationContext(){
        return app;
    }



}
