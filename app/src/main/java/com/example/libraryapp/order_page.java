package com.example.libraryapp;

import android.widget.ListView;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.libraryapp.ListView.OrderBooksListViewAdapter;
import com.example.libraryapp.ViewModel.OrderPageViewModel;

public class order_page extends Fragment {

    private OrderPageViewModel mViewModel;
    private ListView lvListBooks;

    public static order_page newInstance() {
        return new order_page();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_page_fragment, container, false);

        String[] items = {"Dac nhan tam", "Nguoi phan xu", "Kteam"};

        lvListBooks = view.findViewById(R.id.lvOrderPageListBooks);

        OrderBooksListViewAdapter adapter = new OrderBooksListViewAdapter(items,getActivity());
        lvListBooks.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(OrderPageViewModel.class);
        // TODO: Use the ViewModel
    }

}