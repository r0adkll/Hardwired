package com.r0adkll.hardwired;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired
 * Created by drew.heavner on 1/14/16.
 */
@Module
public class FlavorModule {

    @Provides @Singleton
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .build();
    }

}
