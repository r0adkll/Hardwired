package com.r0adkll.hardwired.ui.screens.detail;

import com.r0adkll.hardwired.data.model.Component;
import com.r0adkll.hardwired.ui.model.IRxView;
import com.r0adkll.hardwired.ui.model.ISnackbarView;

import java.util.List;

public interface DetailView extends IRxView, ISnackbarView{


    void updateComponents(List<Component> components);
}
