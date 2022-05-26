package k15hkii.se114.bookstore.ui.forgotpassscreen;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.ForgotPasswordFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;

public class ForgotPasswordPage extends BaseFragment<ForgotPasswordFragmentBinding, ForgotPasswordViewModel>implements ForgotPassNavigator {

    private ForgotPasswordFragmentBinding forgotPasswordFragmentBinding;
    private ForgotPasswordViewModel mViewModel;
    private Button btnNext, btnBackward;
    private TextView tvRegister;
    private EditText etRegister;

    public static ForgotPasswordPage newInstance() {
        return new ForgotPasswordPage();
    }

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ForgotPasswordViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
