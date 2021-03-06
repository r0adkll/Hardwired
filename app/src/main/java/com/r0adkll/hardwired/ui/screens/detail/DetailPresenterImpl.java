package com.r0adkll.hardwired.ui.screens.detail;

import com.f2prateek.rx.preferences.Preference;
import com.ftinc.kit.util.RxUtils;
import com.r0adkll.hardwired.data.OpenHardwareMonitor;
import com.r0adkll.hardwired.data.model.Computer;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;
import timber.log.Timber;

public class DetailPresenterImpl implements DetailPresenter {

    /***********************************************************************************************
     *
     * Variables
     *
     */

    private DetailView view;
    private OpenHardwareMonitor monitor;
    private Preference<Long> refreshIntervalPreference;

    public DetailPresenterImpl(DetailView view,
                               Preference<Long> refreshInterval,
                               OpenHardwareMonitor monitor) {
        this.view = view;
        this.refreshIntervalPreference = refreshInterval;
        this.monitor = monitor;
    }

    /***********************************************************************************************
     *
     * Presenter Methods
     *
     */

    @Override
    public void connect(Computer computer) {
        view.bindObservable(monitor.read(computer.getBaseUri()))
                .repeatWhen(observable -> timer().repeat())
                .compose(RxUtils.applyIOSchedulers())
                .subscribe(component -> {
                    Timber.d("Updating Computer[%s]: %s", computer.name, component.components);
                    view.updateComponents(component.components);
                }, throwable -> {
                    view.showSnackBar(throwable.getLocalizedMessage());
                });
    }

    @Override
    public void updateRefreshInterval(long seconds) {
        refreshIntervalPreference.set(seconds);
    }

    private Observable<Long> timer(){
        return Observable.defer(new Func0<Observable<Long>>() {
            @Override
            public Observable<Long> call() {
                return Observable.timer(refreshIntervalPreference.get(), TimeUnit.SECONDS);
            }
        });
    }

}
