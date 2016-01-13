package com.r0adkll.hardwired.ui.screens.detail;

import com.r0adkll.hardwired.data.OpenHardwareMonitor;

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
    DetailPresenter providePresenter(DetailView v, OpenHardwareMonitor monitor){
        return new DetailPresenterImpl(v, monitor);
    }

}
