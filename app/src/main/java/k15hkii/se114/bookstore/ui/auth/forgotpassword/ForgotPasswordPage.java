package k15hkii.se114.bookstore.ui.auth.forgotpassword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.ForgotPasswordFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.auth.register.Register;
import k15hkii.se114.bookstore.ui.base.BaseFragment;

public class ForgotPasswordPage extends BaseFragment<ForgotPasswordFragmentBinding, ForgotPasswordViewModel> implements ForgotPassNavigator {

    private ForgotPasswordFragmentBinding forgotPasswordFragmentBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.forgot_password_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        forgotPasswordFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(ForgotPasswordPage.this);


        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void OpenRegister() {
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, Register.class, null)
                .addToBackStack(null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

}
