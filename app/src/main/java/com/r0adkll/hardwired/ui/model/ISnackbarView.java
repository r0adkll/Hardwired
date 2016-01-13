package com.r0adkll.hardwired.ui.model;

import android.support.annotation.StringRes;

/**
 * Project: TradeVersity
 * Package: com.ftinc.tradeversity.ui.model
 * Created by drew.heavner on 8/17/15.
 */
public interface ISnackbarView {
    void showSnackBar(String msg);
    void showSnackBar(@StringRes int resId);
}
