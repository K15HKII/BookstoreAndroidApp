package k15hkii.se114.bookstore.ui.dialog.changephone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.ChangePhoneNumberDialogBinding;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.ui.base.BaseDialog;
import k15hkii.se114.bookstore.ui.components.CloseReturnCallback;
import k15hkii.se114.bookstore.ui.dialog.errordata.ErrorDataDialog;
import k15hkii.se114.bookstore.ui.dialog.missingdata.MissingDataDialog;

import javax.inject.Inject;

public class ChangePhoneNumDialog extends BaseDialog implements ChangePhoneNumCallBack {

    private final String TAG = "ChangePhoneNumberDialog";

    @Inject ChangePhoneNumViewModel changePhoneNumViewModel;

    private final CloseReturnCallback closeCallback;

    public ChangePhoneNumDialog(CloseReturnCallback closeCallback) {
        this.closeCallback = closeCallback;
    }

    public static ChangePhoneNumDialog newInstance(CloseReturnCallback closeCallback) {
        ChangePhoneNumDialog fragment = new ChangePhoneNumDialog(closeCallback);
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ChangePhoneNumberDialogBinding binding = DataBindingUtil.inflate( inflater, R.layout.change_phone_number_dialog, container, false);
        View view =binding.getRoot();

        binding.setViewModel(changePhoneNumViewModel);
        changePhoneNumViewModel.setNavigator(this);
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
    public void openMissingPhoneDialog(String error) {
        Bundle bundle = new Bundle();
        bundle.putString("error", error);
        MissingDataDialog.newInstance(getActivity().getSupportFragmentManager(), bundle).
                show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openInvalidPhoneDialog(String error) {
        Bundle bundle = new Bundle();
        bundle.putString("error", error);
        ErrorDataDialog.newInstance(getActivity().getSupportFragmentManager(), bundle).
                show(getActivity().getSupportFragmentManager());
    }
}
