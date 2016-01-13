package com.r0adkll.hardwired.ui.screens.template;

import dagger.Module;
import dagger.Provides;

@Module
public class MVPModule {

    private MVPView view;

    public MVPModule(MVPView view) {
        this.view = view;
    }

    @Provides
    MVPView provideView(){
        return view;
    }

    @Provides
    MVPPresenter providePresenter(MVPView v){
        return new MVPPresenterImpl(v);
    }

}
