package k15hkii.se114.bookstore.ui.loginscreen;

import android.annotation.SuppressLint;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.databinding.LoginFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.forgotpassscreen.ForgotPasswordPage;
import k15hkii.se114.bookstore.ui.mainscreen.HomeLayout;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.ui.registerscreen.Register;
//import k15hkii.se114.bookstore.databinding.LoginFragmentBinding;

public class Login extends BaseFragment<LoginFragmentBinding, LoginViewModel> implements LoginNavigator {

    private LoginFragmentBinding loginFragmentBinding;
    private LoginViewModel loginViewModel;
    private EditText etUsername,etPassword;
    private Button btnLogin, btnLoginWithGoogle, btnLoginWithFacebook;
    private TextView tvPassforget,tvRegister;
    private boolean passwordVisible;

    public static Login newInstance() {
        return new Login();
    }

    @Override
    public int getBindingVariable() {
        return BR.LoginViewModel;
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
        loginFragmentBinding = getViewDataBinding();
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
    public void login() {

    }

    @Override
    public void openHomeView() {
        FragmentManager fragmentManager = Login.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, HomeLayout.class,null).commit();
    }

    @Override
    public void openPasswordForget() {
        FragmentManager fragmentManager = Login.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, ForgotPasswordPage.class,null).addToBackStack(null).commit();
    }

    @Override
    public void openRegister() {
        FragmentManager fragmentManager = Login.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, Register.class,null).addToBackStack(null).commit();
    }
}
