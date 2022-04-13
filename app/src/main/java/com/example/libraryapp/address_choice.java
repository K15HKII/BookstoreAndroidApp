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
import com.example.libraryapp.ListView.OtherAddressAdapter;
import com.example.libraryapp.ViewModel.AddressChoiceViewModel;

import java.util.ArrayList;
import java.util.List;

public class address_choice extends Fragment {

    private AddressChoiceViewModel mViewModel;
    private ListView lvOtherAddress;
    private OtherAddressAdapter otherAddressAdapter;

    public static address_choice newInstance() {
        return new address_choice();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.address_choice_fragment, container, false);

        lvOtherAddress = view.findViewById(R.id.lvAddressChoiceOtherAddress);

        ArrayList<String> lsOtherAddress = new ArrayList<>();
        lsOtherAddress.add("Biên Hòa, Đồng Nai");
        lsOtherAddress.add("Vạn Ninh, Khánh Hòa");

        otherAddressAdapter = new OtherAddressAdapter(lsOtherAddress,getActivity());
        lvOtherAddress.setAdapter(otherAddressAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddressChoiceViewModel.class);
        // TODO: Use the ViewModel
    }

}
