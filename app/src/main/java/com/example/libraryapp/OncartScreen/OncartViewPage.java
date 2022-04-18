package com.example.libraryapp.OncartScreen;

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
import com.example.libraryapp.R;
import com.example.libraryapp.ViewModel.OncartViewViewModel;

import java.util.ArrayList;
import java.util.List;

public class OncartViewPage extends Fragment {

    private OncartViewViewModel mViewModel;
    RecyclerView rcvListOncart;
    OncartItemAdapter oncartItemAdapter;

    public static OncartViewPage newInstance() {
        return new OncartViewPage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.oncart_view_fragment, container, false);

        rcvListOncart = view.findViewById(R.id.lvOnCartViewListItems);
        String[] names = {"Sách Đắc Nhân Tâm","Sách Công Nghệ","Danh Nghiệp","Giải tích AKA Giải thích"};

        List<OncartItem> arrayName = new ArrayList<OncartItem>();
        for(int i=0;i<names.length;i++){
            arrayName.add(new OncartItem(names[i]));
        }

        oncartItemAdapter = new OncartItemAdapter(getActivity(),arrayName);
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
