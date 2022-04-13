package com.example.libraryapp;

import android.widget.Spinner;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.libraryapp.SpinnerAdapter.CityAdapter;
import com.example.libraryapp.ViewModel.EditAddressViewModel;

import java.util.ArrayList;
import java.util.List;

public class edit_address extends Fragment {

    private EditAddressViewModel mViewModel;
    private Spinner spCity, spDistrict,spVillage;
    private CityAdapter cityadapter,districtAdapter,villageadapter;

    public static edit_address newInstance() {
        return new edit_address();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_address_fragment, container, false);

        spCity = view.findViewById(R.id.spEditAddressCity);
        spDistrict = view.findViewById(R.id.spEditAddressDistrict);
        spVillage = view.findViewById(R.id.spEditAddressVillage);

        List<String> lsCity = new ArrayList<>();
        lsCity.add("Hồ Chí Minh");
        lsCity.add("Hà Nội");
        lsCity.add("Hải Phòng");

        List<String> lsDistrict = new ArrayList<>();
        lsDistrict.add("Quận 7");
        lsDistrict.add("Quận 2");
        lsDistrict.add("Quận 1");

        List<String> lsVillage = new ArrayList<>();
        lsVillage.add("Tân Kiểng");
        lsVillage.add("Tân Quy");
        lsVillage.add("Phường 7");

        cityadapter = new CityAdapter(getActivity(),lsCity);
        spCity.setAdapter(cityadapter);

        districtAdapter = new CityAdapter(getActivity(),lsDistrict);
        spDistrict.setAdapter(districtAdapter);

        villageadapter = new CityAdapter(getActivity(),lsVillage);
        spVillage.setAdapter(villageadapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EditAddressViewModel.class);
        // TODO: Use the ViewModel
    }

}
