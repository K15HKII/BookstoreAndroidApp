package k15hkii.se114.bookstore.ui.dialog.logincheck;

import android.app.Dialog;
import android.os.Bundle;
import android.view.*;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.FilterSearchDialogBinding;
import k15hkii.se114.bookstore.databinding.LoginCheckDialogBinding;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.ui.base.BaseDialog;
import k15hkii.se114.bookstore.ui.dialog.filtersearch.FilterSearchCallBack;
import k15hkii.se114.bookstore.ui.dialog.filtersearch.FilterSearchDialog;
import k15hkii.se114.bookstore.ui.dialog.filtersearch.FilterSearchViewModel;
import k15hkii.se114.bookstore.ui.searchbook.SearchBookViewResult;

import javax.inject.Inject;

public class LoginCheckDialog extends BaseDialog implements LoginCheckCallBack {
    private static final String TAG = "LoginCheckDialog";

    @Inject
    LoginCheckViewModel loginCheckViewModel;

    public static LoginCheckDialog newInstance() {
        LoginCheckDialog fragment = new LoginCheckDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LoginCheckDialogBinding binding = DataBindingUtil.inflate( inflater, R.layout.login_check_dialog, container, false);
        View view =binding.getRoot();
        binding.setViewModel(loginCheckViewModel);
        loginCheckViewModel.setNavigator(this);
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
