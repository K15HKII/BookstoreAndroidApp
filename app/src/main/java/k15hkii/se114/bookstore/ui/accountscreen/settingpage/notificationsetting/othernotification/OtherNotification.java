package k15hkii.se114.bookstore.ui.accountscreen.settingpage.notificationsetting.othernotification;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.OtherNotificationFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;

public class OtherNotification extends BaseFragment<OtherNotificationFragmentBinding, OtherNotificationViewModel> implements OtherNotificationNavigator {

    private OtherNotificationFragmentBinding otherNotificationFragmentBinding;
    private OtherNotificationViewModel mViewModel;

    public static OtherNotification newInstance() {
        return new OtherNotification();
    }

    @Override
    public int getBindingVariable() {
        return BR.OtherNotificationViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.other_notification_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        otherNotificationFragmentBinding = getViewDataBinding();
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
        mViewModel = new ViewModelProvider(this).get(OtherNotificationViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
