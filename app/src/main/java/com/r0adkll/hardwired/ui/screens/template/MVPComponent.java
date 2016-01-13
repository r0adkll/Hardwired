
package com.r0adkll.hardwired.ui.screens.template;

import com.r0adkll.hardwired.util.scope.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by r0adkll on 7/22/15.
 */
@ActivityScope
@Subcomponent(modules = MVPModule.class)
public interface MVPComponent {
    void inject(MVPActivity activity);
}
