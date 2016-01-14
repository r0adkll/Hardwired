package com.r0adkll.hardwired.ui.screens.detail;

import com.f2prateek.rx.preferences.Preference;
import com.r0adkll.hardwired.data.OpenHardwareMonitor;
import com.r0adkll.hardwired.util.qualifiers.RefreshInterval;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {

    private DetailView view;

    public DetailModule(DetailView view) {
        this.view = view;
    }

    @Provides
    DetailView provideView(){
        return view;
    }

    @Provides
    DetailPresenter providePresenter(DetailView v,
                                     @RefreshInterval Preference<Long> refreshInterval,
                                     OpenHardwareMonitor monitor){
        return new DetailPresenterImpl(v, refreshInterval, monitor);
    }

}
