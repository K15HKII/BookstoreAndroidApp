package k15hkii.se114.bookstore.ui.auth.loginscreen;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.LoginFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.auth.forgotpassword.ForgotPasswordPage;
import k15hkii.se114.bookstore.ui.auth.register.Register;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.dialog.failedcheck.FailedCheckDialog;
import k15hkii.se114.bookstore.ui.dialog.logincheck.LoginCheckDialog;
import k15hkii.se114.bookstore.ui.dialog.missingdata.MissingDataDialog;
import k15hkii.se114.bookstore.ui.mainscreen.HomeLayout;
//import k15hkii.se114.bookstore.databinding.LoginFragmentBinding;

public class Login extends BaseFragment<LoginFragmentBinding, LoginViewModel> implements LoginNavigator {

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.login_fragment;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        LoginFragmentBinding binding = getViewDataBinding();
        viewModel.setNavigator(this);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void login(Object obj) {

    }

    @Override
    public void openHomeView(Object... obj) {
        createTransaction(R.id.fragmentContainerView, HomeLayout.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openPasswordForget(Object... obj) {
        createTransaction(R.id.fragmentContainerView, ForgotPasswordPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).addToBackStack(null).commit();
    }

    @Override
    public void openRegister(Object... obj) {
        createTransaction(R.id.fragmentContainerView, Register.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).addToBackStack(null).commit();
    }

    @Override
    public void openWrongDialog() {
        FailedCheckDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openCorrectDialog(Object obj, String check) {
        Bundle bundle = new Bundle();
        bundle.putString("check", check);
        LoginCheckDialog dialog = new LoginCheckDialog().newInstance(getActivity().getSupportFragmentManager(), bundle);
        dialog.show(getActivity().getSupportFragmentManager());
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                dialog.dismissDialog();
                openHomeView(obj);
            }
        }, 500);
    }

    @Override
    public void openMissingDataDialog() {
        MissingDataDialog dialog = new MissingDataDialog();
        dialog.show(getActivity().getSupportFragmentManager());
    }

}
