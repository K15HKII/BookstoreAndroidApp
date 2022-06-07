package k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting.vouchernotification;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.VoucherNotificaitonFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;

public class VoucherNotificaiton extends BaseFragment<VoucherNotificaitonFragmentBinding, VoucherNotificaitonViewModel> implements VoucherNotificaitonNavigator {

    private VoucherNotificaitonFragmentBinding voucherNotificaitonFragmentBinding;

    @Override
    public int getBindingVariable() {
        return BR.VoucherNotificationViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.voucher_notificaiton_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        voucherNotificaitonFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
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
}
