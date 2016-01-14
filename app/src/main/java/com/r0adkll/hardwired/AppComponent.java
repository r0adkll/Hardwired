package com.r0adkll.hardwired;

import com.r0adkll.hardwired.data.DataModule;
import com.r0adkll.hardwired.ui.dialog.AddComputerDialog;
import com.r0adkll.hardwired.ui.screens.detail.DetailComponent;
import com.r0adkll.hardwired.ui.screens.detail.DetailModule;
import com.r0adkll.hardwired.ui.screens.directory.DirectoryComponent;
import com.r0adkll.hardwired.ui.screens.directory.DirectoryModule;
import com.r0adkll.hardwired.ui.screens.directory.adapter.ComputerRecyclerAdapter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired
 * Created by drew.heavner on 1/13/16.
 */
@Singleton
@Component(
    modules = {
        AppModule.class,
        DataModule.class,
        InfoModule.class,
        FlavorModule.class
    }
)
public interface AppComponent {

    void inject(HardwiredApp app);
    void inject(AddComputerDialog dialog);
    void inject(ComputerRecyclerAdapter adapter);

    DirectoryComponent plus(DirectoryModule module);
    DetailComponent plus(DetailModule module);
}
