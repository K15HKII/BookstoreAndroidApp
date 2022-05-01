package com.example.libraryapp.mainscreen.page;

import android.os.Handler;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.example.libraryapp.loginscreen.LoadingDialog;
import com.example.libraryapp.mainscreen.ShipmentScreen.OrderMenuTabAdapter;
import com.example.libraryapp.R;
import com.example.libraryapp.viewmodel.ReceiptViewViewModel;
import com.google.android.material.tabs.TabLayout;

public class ShippingPage extends Fragment {

    private ReceiptViewViewModel mViewModel;
    private TabLayout tabmenuNav;
    private ViewPager orderView;

    public static ShippingPage newInstance() {
        return new ShippingPage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shipping_page_fragment, container, false);

        tabmenuNav = view.findViewById(R.id.tabMenuReceiptNav);
        orderView = view.findViewById(R.id.vpReceiptOrderView);

        final LoadingDialog loadingDialog = new LoadingDialog(getActivity());
        loadingDialog.startLoadingDialog();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.dismissDialog();
            }
        },500);

        OrderMenuTabAdapter orderMenuTabAdapter = new OrderMenuTabAdapter(getActivity().getSupportFragmentManager(),
                                                    FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        orderView.setAdapter(orderMenuTabAdapter);
        tabmenuNav.setupWithViewPager(orderView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ReceiptViewViewModel.class);
        // TODO: Use the ViewModel
    }

}
