package com.r0adkll.hardwired.ui.screens.directory;

import com.r0adkll.hardwired.ui.screens.directory.adapter.DirectoryView;

import dagger.Module;
import dagger.Provides;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.screens.directory
 * Created by drew.heavner on 1/13/16.
 */
@Module
public class DirectoryModule {

    private DirectoryView view;

    public DirectoryModule(DirectoryView view){
        this.view = view;
    }

    @Provides
    DirectoryView provideView(){
        return view;
    }

    @Provides
    DirectoryPresenter providePresenter(DirectoryView v){
        return new DirectoryPresenterImpl(v);
    }

}
