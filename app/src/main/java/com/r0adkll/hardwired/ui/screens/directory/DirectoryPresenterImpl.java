package com.r0adkll.hardwired.ui.screens.directory;

import com.ftinc.kit.util.RxUtils;
import com.r0adkll.hardwired.data.model.Computer;
import com.r0adkll.hardwired.ui.screens.directory.adapter.DirectoryView;

import java.util.List;

import ollie.query.Select;
import rx.functions.Action1;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.screens.directory
 * Created by drew.heavner on 1/13/16.
 */
public class DirectoryPresenterImpl implements DirectoryPresenter {

    private DirectoryView view;

    public DirectoryPresenterImpl(DirectoryView view){
        this.view = view;
    }

    @Override
    public void loadComputers() {

        view.bindObservable(Select.from(Computer.class).observable())
                .compose(RxUtils.applyIOSchedulers())
                .subscribe(computers -> {
                    view.updateComputers(computers);
                }, throwable -> {
                    view.showSnackBar(throwable.getLocalizedMessage());
                });


    }

}
