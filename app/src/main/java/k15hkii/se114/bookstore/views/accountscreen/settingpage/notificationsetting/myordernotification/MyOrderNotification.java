package k15hkii.se114.bookstore.views.accountscreen.settingpage.notificationsetting.myordernotification;

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
import k15hkii.se114.bookstore.databinding.MyOrderNotificationFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;

public class MyOrderNotification extends BaseFragment<MyOrderNotificationFragmentBinding, MyOrderNotificationViewModel> implements MyOrderNotificationNavigator {

    private MyOrderNotificationFragmentBinding myOrderNotificationFragmentBinding;
    private MyOrderNotificationViewModel mViewModel;

    public static MyOrderNotification newInstance() {
        return new MyOrderNotification();
    }

    @Override
    public int getBindingVariable() {
        return BR.MyOrderNotificationViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.my_order_notification_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        myOrderNotificationFragmentBinding = getViewDataBinding();
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
        mViewModel = new ViewModelProvider(this).get(MyOrderNotificationViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
