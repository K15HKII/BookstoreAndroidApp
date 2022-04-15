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
import com.example.libraryapp.HomeRecycleView.OrderItem;
import com.example.libraryapp.HomeRecycleView.OrderView;
import com.example.libraryapp.HomeRecycleView.OrderViewAdapter;
import com.example.libraryapp.ViewModel.RatingViewViewModel;

import java.util.ArrayList;
import java.util.List;

public class rating_view extends Fragment {

    private RatingViewViewModel mViewModel;
    private RecyclerView rcvOrderView;
    private OrderViewAdapter orderViewAdapter;

    public static rating_view newInstance() {
        return new rating_view();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rating_view_fragment, container, false);
        rcvOrderView = view.findViewById(R.id.rcvRatingOrderView);
        orderViewAdapter = new OrderViewAdapter(getListBook(),rating_view.this.getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rating_view.this.getContext());
        rcvOrderView.setLayoutManager(linearLayoutManager);
        rcvOrderView.setAdapter(orderViewAdapter);
        return view;
    }

    private List<OrderView> getListBook() {
        List<OrderView> lsOrder = new ArrayList<>();

        List<OrderItem> lsBook1 = new ArrayList<>();
        lsBook1.add(new OrderItem("Dac Nhan Tam"));
        lsBook1.add(new OrderItem("hello"));


        List<OrderItem> lsBook2 = new ArrayList<>();
        lsBook2.add(new OrderItem("Dac Nhan Tam"));

        lsOrder.add(new OrderView("200.000d","nothing",lsBook1));
        lsOrder.add(new OrderView("120.000d","nothing",lsBook2));

        return lsOrder;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RatingViewViewModel.class);
        // TODO: Use the ViewModel
    }

}
