package k15hkii.se114.bookstore.views.loginscreen;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
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
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.mainscreen.HomeLayout;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.viewmodel.LoginViewModel;
import k15hkii.se114.bookstore.views.registerscreen.Register;
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
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        loginFragmentBinding = getViewDataBinding();

        viewModel.setNavigator(Login.this);

        FragmentManager fragmentManager = Login.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

//        LoginFragmentBinding loginFragmentBinding = DataBindingUtil.setContentView(getActivity(), R.layout.login_fragment);
//        loginViewModel = new LoginViewModel(this);
//        loginFragmentBinding.setLoginViewModel(loginViewModel);
//        Tìm view
        etUsername = view.findViewById(R.id.etLoginUser);
        etPassword = view.findViewById(R.id.etLoginPassword);
        btnLogin = view.findViewById(R.id.btnLoginLogin);
        btnLoginWithGoogle = view.findViewById(R.id.btnLoginLoginWithGoogle);
        btnLoginWithFacebook = view.findViewById(R.id.btnLoginLoginWithFaceBook);
        tvRegister = view.findViewById(R.id.tvLoginRegister);
        tvPassforget = view.findViewById(R.id.tvLoginPassforget);
        final LoadingDialog loadingDialog = new LoadingDialog(getActivity());

//        Chức năng các nút

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final LoadingDialog loadingDialog = new LoadingDialog(getActivity());
                loadingDialog.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismissDialog();
                    }
                },500);
                Toast.makeText(getContext(), "Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                fragmentTransaction.replace(R.id.fragmentContainerView, HomeLayout.class,null).addToBackStack(null).commit();
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.replace(R.id.fragmentContainerView, Register.class,null).addToBackStack(null).commit();
            }
        });

        tvPassforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                fragmentTransaction.replace(R.id.fragmentContainerView, Forgot_password_page.class,null).addToBackStack(null).commit();
            }
        });

        btnLoginWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnLoginWithFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    public void LoginSucess(){
        FragmentManager fragmentManager = Login.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            final LoadingDialog loadingDialog = new LoadingDialog(getActivity());
            loadingDialog.startLoadingDialog();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadingDialog.dismissDialog();
                }
            },1000);
            Toast.makeText(getContext(), "Đăng nhập thành công",Toast.LENGTH_SHORT).show();
            fragmentTransaction.replace(R.id.fragmentContainerView, HomeLayout.class,null).addToBackStack(null).commit();
    }
    public void LoginFailed(){
        Toast.makeText(getContext(), "Đăng nhập không thành công",Toast.LENGTH_SHORT).show();
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
        fragmentTransaction.replace(R.id.fragmentContainerView, HomeLayout.class,null).addToBackStack(null).commit();
    }
}
