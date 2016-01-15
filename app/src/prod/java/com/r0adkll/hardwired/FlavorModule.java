package com.r0adkll.hardwired;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by r0adkll on 1/14/16.
 */
@Module
public class FlavorModule {

    @Provides @Singleton
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }

}
