/*
 * Copyright © 52inc 2015.
 * All rights reserved.
 */

package com.r0adkll.hardwired.ui.screens.template;

import android.os.Bundle;

import com.r0adkll.hardwired.AppComponent;
import com.r0adkll.hardwired.ui.model.BaseActivity;

import javax.inject.Inject;

public class MVPActivity extends BaseActivity implements MVPView {

    /***********************************************************************************************
     *
     * Static Intent Creators
     *
     */



    /***********************************************************************************************
     *
     * Constants
     *
     */



    /***********************************************************************************************
     *
     * Variables
     *
     */

    @Inject
    MVPPresenter presenter;

    /***********************************************************************************************
     *
     * Lifecycle Methods
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(0);
        init();
    }

    /***********************************************************************************************
     *
     * Helper Methods
     *
     */

    /**
     * Initialize this activity by setting up the initial state of all
     * the needed view elements
     */
    private void init(){

    }

    /***********************************************************************************************
     *
     * Base Methods
     *
     */

    @Override
    protected void setupComponent(AppComponent graph) {

    }


    /***********************************************************************************************
     *
     * View Methods
     *
     */


}
