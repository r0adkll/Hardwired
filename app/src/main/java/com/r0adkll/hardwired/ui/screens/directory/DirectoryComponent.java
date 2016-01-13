package com.r0adkll.hardwired.ui.screens.directory;

import dagger.Subcomponent;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.screens.directory
 * Created by drew.heavner on 1/13/16.
 */
@Subcomponent(modules = DirectoryModule.class)
public interface DirectoryComponent {

    void inject(DirectoryActivity activity);

}
