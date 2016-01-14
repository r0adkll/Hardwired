package com.r0adkll.hardwired;

import com.r0adkll.hardwired.data.MockIntercepter;

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
                .addInterceptor(new MockIntercepter())
                .build();
    }


}
