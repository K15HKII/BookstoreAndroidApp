package k15hkii.se114.bookstore.views.orderinfoscreen;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.PaymentMethodFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;

public class PaymentMethodPage extends BaseFragment<PaymentMethodFragmentBinding, PaymentMethodViewModel> implements PaymentMethodPageNavigator {

    private PaymentMethodFragmentBinding paymentMethodFragmentBinding;
    private PaymentMethodViewModel mViewModel;

    public static PaymentMethodPage newInstance() {
        return new PaymentMethodPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.PaymentMethodPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.payment_method_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        paymentMethodFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PaymentMethodViewModel.class);
        // TODO: Use the ViewModel
    }

}
