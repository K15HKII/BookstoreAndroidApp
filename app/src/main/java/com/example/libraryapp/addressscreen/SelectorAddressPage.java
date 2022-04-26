package com.example.libraryapp.addressscreen;

import android.widget.ListView;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.libraryapp.R;
import com.example.libraryapp.viewmodel.AddressChoiceViewModel;

import java.util.ArrayList;

public class SelectorAddressPage extends Fragment {

    private AddressChoiceViewModel mViewModel;
    private ListView lvOtherAddress;
    private OtherAddressAdapter otherAddressAdapter;

    public static SelectorAddressPage newInstance() {
        return new SelectorAddressPage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.selector_address_fragment, container, false);

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
