package k15hkii.se114.bookstore.ui.dialog.changeemail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.ChangeEmailDialogBinding;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.ui.base.BaseDialog;
import k15hkii.se114.bookstore.ui.components.CloseReturnCallback;
import k15hkii.se114.bookstore.ui.dialog.changebirth.ChangeBirthDialog;
import k15hkii.se114.bookstore.ui.dialog.errordata.ErrorDataDialog;
import k15hkii.se114.bookstore.ui.dialog.missingdata.MissingDataDialog;

import javax.inject.Inject;

public class ChangeEmailDialog extends BaseDialog implements ChangeEmailCallBack {
    private static final String TAG = "ChangeEmailDialog";

    @Inject
    ChangeEmailViewModel viewModel;

    private final CloseReturnCallback closeCallback;

    public ChangeEmailDialog(CloseReturnCallback closeCallback) {
        this.closeCallback = closeCallback;
    }

    public static ChangeBirthDialog newInstance(CloseReturnCallback closeCallback) {
        ChangeBirthDialog fragment = new ChangeBirthDialog(closeCallback);
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ChangeEmailDialogBinding binding = DataBindingUtil.inflate( inflater, R.layout.change_email_dialog, container, false);
        View view =binding.getRoot();

        binding.setViewModel(viewModel);
        viewModel.setNavigator(this);

        this.getDialog().setCanceledOnTouchOutside(true);

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    public void performDependencyInjection(DialogComponent buildComponent){
        buildComponent.inject(this);
    }

    @Override
    public void dismissDialog() {
        dismissDialog(TAG);
        closeCallback.onClose(null);
    }

    @Override
    public void openMissingEmailDialog(String error) {
        Bundle bundle = new Bundle();
        bundle.putString("error", error);
        MissingDataDialog.newInstance(getActivity().getSupportFragmentManager(),bundle).
                show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openInvalidEmailDialog(String error) {
        Bundle bundle = new Bundle();
        bundle.putString("error", error);
        ErrorDataDialog.newInstance(getActivity().getSupportFragmentManager(),bundle).
                show(getActivity().getSupportFragmentManager());
    }
}
