package k15hkii.se114.bookstore.ui.dialog.logincheck;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.LoginCheckDialogBinding;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.ui.base.BaseDialog;

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

    public static LoginCheckDialog newInstance(FragmentManager supportFragmentManager, Bundle bundle) {
        LoginCheckDialog fragment = new LoginCheckDialog();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LoginCheckDialogBinding binding = DataBindingUtil.inflate(inflater, R.layout.login_check_dialog, container, false);
        View view = binding.getRoot();
        binding.setViewModel(loginCheckViewModel);
        Bundle bundle = getArguments();
        if (bundle != null) {
            binding.tvSuccessLogin.setText(bundle.getString("check"));
        }
        loginCheckViewModel.setNavigator(this);
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

}
