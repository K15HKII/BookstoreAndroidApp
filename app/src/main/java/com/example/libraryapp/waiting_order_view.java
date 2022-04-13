package com.example.libraryapp;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.libraryapp.ViewModel.WaitingOrderViewViewModel;

public class waiting_order_view extends Fragment {

    private WaitingOrderViewViewModel mViewModel;

    public static waiting_order_view newInstance() {
        return new waiting_order_view();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.waiting_order_view_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WaitingOrderViewViewModel.class);
        // TODO: Use the ViewModel
    }

}
