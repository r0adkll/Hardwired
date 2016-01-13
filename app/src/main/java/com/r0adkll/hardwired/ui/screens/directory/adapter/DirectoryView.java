package com.r0adkll.hardwired.ui.screens.directory.adapter;

import com.r0adkll.hardwired.data.model.Computer;
import com.r0adkll.hardwired.ui.model.IRxView;
import com.r0adkll.hardwired.ui.model.ISnackbarView;

import java.util.List;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.screens.directory.adapter
 * Created by drew.heavner on 1/13/16.
 */
public interface DirectoryView extends IRxView, ISnackbarView {

    void updateComputers(List<Computer> computers);
}
