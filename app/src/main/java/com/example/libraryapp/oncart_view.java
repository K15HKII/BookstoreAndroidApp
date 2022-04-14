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
import com.example.libraryapp.HomeRecycleView.BookView;
import com.example.libraryapp.HomeRecycleView.oncart_item;
import com.example.libraryapp.HomeRecycleView.oncart_itemAdapter;
import com.example.libraryapp.ViewModel.OncartViewViewModel;

import java.util.ArrayList;
import java.util.List;

public class oncart_view extends Fragment {

    private OncartViewViewModel mViewModel;
    RecyclerView rcvListOncart;
    oncart_itemAdapter oncartItemAdapter;

    public static oncart_view newInstance() {
        return new oncart_view();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.oncart_view_fragment, container, false);

        rcvListOncart = view.findViewById(R.id.lvOnCartViewListItems);
        String[] names = {"Sách Đắc Nhân Tâm","Sách Công Nghệ","Danh Nghiệp","Giải tích AKA Giải thích"};

        List<oncart_item> arrayName = new ArrayList<oncart_item>();
        for(int i=0;i<names.length;i++){
            arrayName.add(new oncart_item(names[i]));
        }

        oncartItemAdapter = new oncart_itemAdapter(getActivity(),arrayName);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        rcvListOncart.setLayoutManager(linearLayoutManager);
        rcvListOncart.setAdapter(oncartItemAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(OncartViewViewModel.class);
        // TODO: Use the ViewModel
    }

}
