package k15hkii.se114.bookstore.views.notificationnews;

import androidx.lifecycle.ViewModelProvider;
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
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderItem;
import k15hkii.se114.bookstore.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationPage extends BaseFragment<NotificationPageFragmentBinding, NotificationPageViewModel> implements NotificationPageNavigator {

    private NotificationPageFragmentBinding notificationPageFragmentBinding;
    private NotificationPageViewModel mViewModel;
    private RecyclerView rcvView;
    private ListDataNotificationAdapter listDataNotificationAdapter;

    public static NotificationPage newInstance() {
        return new NotificationPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.NotificationPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.notification_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        notificationPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        rcvView = view.findViewById(R.id.rcvNotificationView);
        listDataNotificationAdapter = new ListDataNotificationAdapter(NotificationPage.this.getContext(), GetListDataNotification());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NotificationPage.this.getContext());
        rcvView.setLayoutManager(linearLayoutManager);
        rcvView.setAdapter(listDataNotificationAdapter);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    private List<ListDataNotification> GetListDataNotification() {
        List<ListDataNotification> lsDATA = new ArrayList<>();
        List<OrderItem> lsBook1 = new ArrayList<>();
        lsBook1.add(new OrderItem("Dac Nhan Tam"));
        lsBook1.add(new OrderItem("hello"));

        List<NotificationOrderView> lsOrder = new ArrayList<>();
        lsOrder.add(new NotificationOrderView("Đơn hàng 1","200.000đ","Đã được xác nhận",lsBook1));

        List<NotificationInfo> lsInfo = new ArrayList<>();
        lsInfo.add(new NotificationInfo("Chào mừng bạn đến với bookstore","Hello"));

        lsDATA.add(new ListDataNotification(ListDataNotificationAdapter.TYPE_ORDERVIEW,null,lsOrder));
        lsDATA.add(new ListDataNotification(ListDataNotificationAdapter.TYPE_INFO,lsInfo,lsOrder));
        return lsDATA;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NotificationPageViewModel.class);
        // TODO: Use the ViewModel
    }

}
