package com.r0adkll.hardwired.ui.screens.detail;

import com.ftinc.kit.util.RxUtils;
import com.r0adkll.hardwired.data.OpenHardwareMonitor;
import com.r0adkll.hardwired.data.model.Computer;

import java.util.concurrent.TimeUnit;

public class DetailPresenterImpl implements DetailPresenter {

    /***********************************************************************************************
     *
     * Variables
     *
     */

    private DetailView view;
    private OpenHardwareMonitor monitor;

    public DetailPresenterImpl(DetailView view, OpenHardwareMonitor monitor) {
        this.view = view;
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
                .delay(5, TimeUnit.SECONDS)
                .repeat()
                .compose(RxUtils.applyIOSchedulers())
                .subscribe(component -> {
                    view.updateComponents(component.components);
                }, throwable -> {
                    view.showSnackBar(throwable.getLocalizedMessage());
                });
    }



}
