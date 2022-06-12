package k15hkii.se114.bookstore.ui.notificationnews;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.databinding.NotificationPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemViewModel;
import k15hkii.se114.bookstore.R;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class NotificationPage extends BaseFragment<NotificationPageFragmentBinding, NotificationPageViewModel> implements NotificationPageNavigator {

    @Inject protected
    ListDataNotificationAdapter listDataNotificationAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.notification_page_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        NotificationPageFragmentBinding notificationPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NotificationPage.this.getContext());
        notificationPageFragmentBinding.rcvNotificationView.setLayoutManager(linearLayoutManager);
        notificationPageFragmentBinding.rcvNotificationView.setAdapter(listDataNotificationAdapter);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    private List<ListDataNotificationViewModel> GetListDataNotification() {
        List<ListDataNotificationViewModel> lsDATA = new ArrayList<>();
        List<OrderItemViewModel> lsBook1 = new ArrayList<>();
//        lsBook1.add(new OrderItemViewModel());
//        lsBook1.add(new OrderItemViewModel());

        List<NotificationOrderViewModel> lsOrder = new ArrayList<>();
        lsOrder.add(new NotificationOrderViewModel("Đơn hàng 1", "200.000đ", "Đã được xác nhận", lsBook1));

        List<NotificationInfoViewModel> lsInfo = new ArrayList<>();
        lsInfo.add(new NotificationInfoViewModel("Chào mừng bạn đến với bookstore", "Hello"));

        lsDATA.add(new ListDataNotificationViewModel(ListDataNotificationAdapter.TYPE_ORDERVIEW, null, lsOrder));
        lsDATA.add(new ListDataNotificationViewModel(ListDataNotificationAdapter.TYPE_INFO, lsInfo, lsOrder));
        return lsDATA;

    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
