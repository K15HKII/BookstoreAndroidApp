package k15hkii.se114.bookstore.ui.dialog.changebirth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.BookstoreApp;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.ChangeBirthDialogBinding;
import k15hkii.se114.bookstore.di.component.DaggerDialogComponent;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.di.module.DialogModule;
import k15hkii.se114.bookstore.ui.base.BaseDialog;

import javax.inject.Inject;

public class ChangeBirthDialog extends BaseDialog implements ChangeBirthCallBack {

    private static final String TAG = "ChangeBirthDialog";

    @Inject
    ChangeBirthViewModel changeBirthViewModel;

    public static ChangeBirthDialog newInstance() {
        ChangeBirthDialog fragment = new ChangeBirthDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ChangeBirthDialogBinding binding = DataBindingUtil.inflate( inflater, R.layout.change_birth_dialog, container, false);
        View view =binding.getRoot();

        binding.setViewModel(changeBirthViewModel);
        changeBirthViewModel.setNavigator(this);

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
    }
}
