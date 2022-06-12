package k15hkii.se114.bookstore.ui.dialog.changepassword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.BookstoreApp;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.ChangePasswordDialogBinding;
import k15hkii.se114.bookstore.di.component.DaggerDialogComponent;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.di.module.DialogModule;
import k15hkii.se114.bookstore.ui.base.BaseDialog;

import javax.inject.Inject;

public class ChangePassDialog extends BaseDialog implements ChangePassCallBack {

    public final String TAG = "ChangePassDialog";

    @Inject ChangePassDialogViewModel changePassDialogViewModel;

    public static ChangePassDialog newInstance() {
        ChangePassDialog fragment = new ChangePassDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ChangePasswordDialogBinding binding = DataBindingUtil.inflate( inflater, R.layout.change_password_dialog, container, false);
        View view =binding.getRoot();

        binding.setViewModel(changePassDialogViewModel);
        changePassDialogViewModel.setNavigator(this);
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
    public void onSubmitPass() {
        dismissDialog(TAG);
    }
}
