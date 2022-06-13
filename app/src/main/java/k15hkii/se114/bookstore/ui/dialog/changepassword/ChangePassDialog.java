package k15hkii.se114.bookstore.ui.dialog.changepassword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.ChangePasswordDialogBinding;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.ui.base.BaseDialog;
import k15hkii.se114.bookstore.ui.components.CloseReturnCallback;
import k15hkii.se114.bookstore.ui.dialog.errordata.ErrorDataDialog;
import k15hkii.se114.bookstore.ui.dialog.missingdata.MissingDataDialog;

import javax.inject.Inject;

public class ChangePassDialog extends BaseDialog implements ChangePassCallBack {

    public final String TAG = "ChangePassDialog";

    @Inject
    ChangePassDialogViewModel changePassDialogViewModel;

    private final CloseReturnCallback closeCallback;

    public ChangePassDialog(CloseReturnCallback closeCallback) {
        this.closeCallback = closeCallback;
    }

    public static ChangePassDialog newInstance(CloseReturnCallback closeCallback) {
        ChangePassDialog fragment = new ChangePassDialog(closeCallback);
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ChangePasswordDialogBinding binding = DataBindingUtil.inflate(inflater, R.layout.change_password_dialog, container, false);
        View view = binding.getRoot();

        binding.setViewModel(changePassDialogViewModel);
        changePassDialogViewModel.setNavigator(this);
        this.getDialog().setCanceledOnTouchOutside(true);

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    public void performDependencyInjection(DialogComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void dismissDialog() {
        dismissDialog(TAG);
    }

    @Override
    public void openMissingDataDialog(String error) {
        Bundle bundle = new Bundle();
        bundle.putString("error", error);
        MissingDataDialog.newInstance(getActivity().getSupportFragmentManager(), bundle).
                show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openInvalidPasswordDialog(String error) {
        Bundle bundle = new Bundle();
        bundle.putString("error", error);
        ErrorDataDialog.newInstance(getActivity().getSupportFragmentManager(), bundle).
                show(getActivity().getSupportFragmentManager());
    }

}
