package com.r0adkll.hardwired.ui.screens.screens;

import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.View;

import com.r0adkll.hardwired.AppComponent;
import com.r0adkll.hardwired.BuildConfig;
import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.ui.model.BaseActivity;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * Created by r0adkll on 1/14/16.
 */
public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.activity_settings);
        getAppBar().setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void setupComponent(AppComponent appGraph) {}

    /***********************************************************************************************
     *
     * Setting Fragment
     *
     */

    public static class SettingFragment extends PreferenceFragmentCompat{

        @Override
        public void onCreatePreferences(Bundle bundle, String s) {
            addPreferencesFromResource(R.xml.setting_preferences);
        }

        @Override
        protected void onBindPreferences() {

            Preference version = findPreference("pref_version");
            version.setSummary(BuildConfig.VERSION_NAME);

        }

        @Override
        public boolean onPreferenceTreeClick(Preference preference) {
            switch (preference.getKey()){
                case "pref_author_by":

                    return true;
                case "pref_author_support":

                    return true;
                case "pref_licenses":

                    return true;
            }
            return super.onPreferenceTreeClick(preference);
        }
    }

}
