package com.example.libraryapp;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.libraryapp.HomeRecycleView.*;
import com.example.libraryapp.ViewModel.NotificationPageViewModel;

import java.util.ArrayList;
import java.util.List;

public class notification_page extends Fragment {

    private NotificationPageViewModel mViewModel;
    private RecyclerView rcvView;
    private ListDataNotificationAdapter listDataNotificationAdapter;

    public static notification_page newInstance() {
        return new notification_page();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notification_page_fragment, container, false);
        rcvView = view.findViewById(R.id.rcvNotificationView);
        listDataNotificationAdapter = new ListDataNotificationAdapter(notification_page.this.getContext(), GetListDataNotification());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(notification_page.this.getContext());
        rcvView.setLayoutManager(linearLayoutManager);
        rcvView.setAdapter(listDataNotificationAdapter);
        return view;
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
