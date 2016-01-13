
package com.r0adkll.hardwired.ui.screens.detail;

import com.r0adkll.hardwired.util.scope.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by r0adkll on 7/22/15.
 */
@ActivityScope
@Subcomponent(modules = DetailModule.class)
public interface DetailComponent {
    void inject(DetailActivity activity);
}
