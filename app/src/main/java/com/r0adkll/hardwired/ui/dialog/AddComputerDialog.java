package com.r0adkll.hardwired.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ftinc.kit.util.BuildUtils;
import com.ftinc.kit.util.RxUtils;
import com.ftinc.kit.util.Utils;
import com.r0adkll.hardwired.HardwiredApp;
import com.r0adkll.hardwired.R;
import com.r0adkll.hardwired.data.OpenHardwareMonitor;
import com.r0adkll.hardwired.data.model.Computer;
import com.trello.rxlifecycle.components.support.RxDialogFragment;

import java.util.regex.Pattern;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import butterknife.Unbinder;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.ui.dialog
 * Created by drew.heavner on 1/13/16.
 */
public class AddComputerDialog extends RxDialogFragment {

    /***********************************************************************************************
     *
     * Constants
     *
     */

    private static final Pattern PARTIAl_IP_ADDRESS =
            Pattern.compile("^((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])\\.){0,3}"+
                    "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])){0,1}$");

    /***********************************************************************************************
     *
     * Variables
     *
     */

    @BindView(R.id.input_ip_address)
    EditText inputIpAddress;
    @BindView(R.id.input_port)
    EditText inputPort;

    @BindView(R.id.action_positive)
    TextView actionPositive;

    @BindView(R.id.loading)
    ProgressBar loading;
    @BindView(R.id.error_message)
    TextView errorMessage;

    @Inject
    OpenHardwareMonitor monitor;

    private Unbinder unbinder;
    private PublishSubject<Computer> mSubject = PublishSubject.create();

    /***********************************************************************************************
     *
     * Lifecycle Methods
     *
     */

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof AddComputerInterface){
            ((AddComputerInterface) activity).subscribe(mSubject);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HardwiredApp.get(getActivity()).inject(this);

        inputIpAddress.addTextChangedListener(new TextWatcher() {
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void beforeTextChanged(CharSequence s,int start,int count,int after) {}

            private String mPreviousText = "";
            @Override
            public void afterTextChanged(Editable s) {
                if(PARTIAl_IP_ADDRESS.matcher(s).matches()) {
                    mPreviousText = s.toString();
                } else {
                    s.replace(0, s.length(), mPreviousText);
                }

                checkInputs();
            }
        });

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (BuildUtils.isLollipop()) {
            setStyle(STYLE_NORMAL, android.R.style.Theme_Material_Light_Dialog_Alert);
        }
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle(R.string.dialog_add_computer_title);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_computer, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    private void checkInputs(){
        if(inputIpAddress.getText().length() == 0 ||
                inputPort.getText().length() == 0){
            actionPositive.setEnabled(false);
        }else{
            actionPositive.setEnabled(true);
        }
    }

    /***********************************************************************************************
     *
     * Listener Methods
     *
     */

    @OnTextChanged(callback = OnTextChanged.Callback.TEXT_CHANGED, value = R.id.input_port)
    void onPortTextChanged(){
        checkInputs();
    }

    @OnClick({R.id.action_positive, R.id.action_cancel})
    void onActionClicked(View v){
        switch (v.getId()){
            case R.id.action_positive:

                String ipAddress = inputIpAddress.getText().toString().trim();
                int port = Utils.parseInt(inputPort.getText().toString().trim(), 0);

                loading.setVisibility(View.VISIBLE);
                actionPositive.setEnabled(false);
                errorMessage.setVisibility(View.GONE);
                inputIpAddress.setEnabled(false);
                inputPort.setEnabled(false);
                monitor.test(ipAddress, port)
                        .doOnNext(computer -> computer.save())
                        .compose(bindToLifecycle())
                        .compose(RxUtils.applyIOSchedulers())
                        .subscribe(computer -> {
                            mSubject.onNext(computer);
                            mSubject.onCompleted();
                            dismiss();
                        }, throwable -> {
                            errorMessage.setVisibility(View.VISIBLE);
                            errorMessage.setText(throwable.getLocalizedMessage());
                            actionPositive.setEnabled(true);
                            inputIpAddress.setEnabled(true);
                            inputPort.setEnabled(true);
                            loading.setVisibility(View.GONE);
                        });

                break;
            case R.id.action_cancel:
                dismiss();
                break;
        }
    }

    public interface AddComputerInterface{
        void subscribe(Observable<Computer> observable);
    }

}
