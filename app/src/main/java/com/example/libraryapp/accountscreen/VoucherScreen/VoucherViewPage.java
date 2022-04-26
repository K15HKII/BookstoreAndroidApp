package com.example.libraryapp.accountscreen.VoucherScreen;

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
import com.example.libraryapp.viewmodel.VoucherViewViewModel;

import java.util.ArrayList;
import java.util.List;

public class VoucherViewPage extends Fragment {

    private VoucherViewViewModel mViewModel;
    private RecyclerView rcvVoucherList;
    private VoucherViewAdapter voucherViewAdapter;

    public static VoucherViewPage newInstance() {
        return new VoucherViewPage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.voucher_view_fragment, container, false);

        String[] names = {"20% Giảm giá","30% Giảm giá","10% Giảm giá"};

        List<Voucher> arrayName = new ArrayList<Voucher>();
        for(int i=0;i<names.length;i++){
            arrayName.add(new Voucher(names[i]));
        }
        rcvVoucherList = view.findViewById(R.id.rcvVoucherViewVoucherList);
        voucherViewAdapter = new VoucherViewAdapter(arrayName,getActivity());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        rcvVoucherList.setLayoutManager(layoutManager);
        rcvVoucherList.setAdapter(voucherViewAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VoucherViewViewModel.class);
        // TODO: Use the ViewModel
    }

}
