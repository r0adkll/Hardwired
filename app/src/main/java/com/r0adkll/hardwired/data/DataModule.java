package com.r0adkll.hardwired.data;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data
 * Created by drew.heavner on 1/13/16.
 */
@Module
public class DataModule {

    @Provides @Singleton
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .build();
    }

    @Provides @Singleton
    Gson provideGson(){
        return new Gson();
    }



}
