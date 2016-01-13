package com.r0adkll.hardwired.ui.model;

import rx.Observable;

/**
 * Created by r0adkll on 7/28/15.
 */
public interface IRxView {

    /**
     * This is absolutely necessary when using RxJava in views to bind
     * them to the UI lifecycles (i.e.; Activity, Fragment, etc) so
     * that they can properly be unsubscribed and prevent memory leaks
     *
     * @param observable        the observable to bind
     * @return                  the bound observable
     */
    <T> Observable<T> bindObservable(Observable<T> observable);

}
