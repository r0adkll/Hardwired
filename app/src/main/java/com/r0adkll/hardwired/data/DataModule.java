package com.r0adkll.hardwired.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.f2prateek.rx.preferences.Preference;
import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.google.gson.Gson;
import com.r0adkll.hardwired.util.qualifiers.RefreshInterval;

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

    public static final String PREF_REFRESH_INTERVAL = "pref_refresh_interval";

    @Provides @Singleton
    Gson provideGson(){
        return new Gson();
    }

    @Provides @Singleton
    SharedPreferences provideSharedPreferences(Context ctx){
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    @Provides @Singleton
    RxSharedPreferences provideRxSharedPreferences(SharedPreferences prefs){
        return RxSharedPreferences.create(prefs);
    }

    @Provides @Singleton @RefreshInterval
    Preference<Long> provideRefreshIntervalPreference(RxSharedPreferences prefs){
        return prefs.getLong(PREF_REFRESH_INTERVAL, 5L);
    }

}
