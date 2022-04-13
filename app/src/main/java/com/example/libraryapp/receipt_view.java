package com.example.libraryapp;

import android.widget.TableLayout;
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
import com.example.libraryapp.MenuTab.OrderMenuTabAdapter;
import com.example.libraryapp.ViewModel.ReceiptViewViewModel;
import com.google.android.material.tabs.TabLayout;

public class receipt_view extends Fragment {

    private ReceiptViewViewModel mViewModel;
    private TabLayout tabmenuNav;
    private ViewPager orderView;

    public static receipt_view newInstance() {
        return new receipt_view();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.receipt_view_fragment, container, false);

        tabmenuNav = view.findViewById(R.id.tabMenuReceiptNav);
        orderView = view.findViewById(R.id.vpReceiptOrderView);

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
