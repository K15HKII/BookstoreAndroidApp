package com.example.libraryapp.mainscreen.Shipment_screen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import org.jetbrains.annotations.NotNull;

public class OrderMenuTabAdapter extends FragmentStatePagerAdapter {

    public OrderMenuTabAdapter(@NonNull @NotNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new WaitingOrderViewPage();
            case 1:
                return new ShippingViewPage();
            case 2:
                return new ShipmentArrivedViewPage();
            case 3:
                return new RatingBookViewPage();
            default:
                return new WaitingOrderViewPage();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Chờ xác nhận";
                break;
            case 1:
                title = "Đang vận chuyển";
                break;
            case 2:
                title = "Đã vận chuyển";
                break;
            case 3:
                title = "Đánh giá";
                break;
        }
        return title;
    }
}
