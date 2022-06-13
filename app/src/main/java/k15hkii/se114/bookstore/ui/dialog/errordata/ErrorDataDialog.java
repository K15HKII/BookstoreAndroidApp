package k15hkii.se114.bookstore.ui.dialog.errordata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.ErrorDataDialogBinding;
import k15hkii.se114.bookstore.databinding.MissingInfoDialogBinding;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.ui.base.BaseDialog;
import k15hkii.se114.bookstore.ui.dialog.missingdata.MissingDataDialog;
import k15hkii.se114.bookstore.ui.dialog.missinginfo.MissingInfoDialog;
import k15hkii.se114.bookstore.ui.dialog.missinginfo.MissingInfoNavigator;
import k15hkii.se114.bookstore.ui.dialog.missinginfo.MissingInfoViewModel;

import javax.inject.Inject;

public class ErrorDataDialog extends BaseDialog implements ErrorDataNavigator {

    private static final String TAG = "ErrorDataDialog";

    @Inject
    ErrorDataViewModel errorDataViewModel;

    public static ErrorDataDialog newInstance() {
        ErrorDataDialog fragment = new ErrorDataDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    public static ErrorDataDialog newInstance(FragmentManager supportFragmentManager, Bundle bundle) {
        ErrorDataDialog fragment = new ErrorDataDialog();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ErrorDataDialogBinding binding = DataBindingUtil.inflate(inflater, R.layout.error_data_dialog, container, false);
        View view = binding.getRoot();
        binding.setViewModel(errorDataViewModel);
        Bundle bundle = getArguments();
        if (bundle != null) {
            binding.tvErrorMess.setText(bundle.getString("error"));
        }
        errorDataViewModel.setNavigator(this);
        this.getDialog().setCanceledOnTouchOutside(true);
        return view;
    }

    @Override
    public void performDependencyInjection(DialogComponent buildComponent) {
        buildComponent.inject(this);
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    @Override
    public void dismissDialog() {
        dismissDialog(TAG);
    }
}
