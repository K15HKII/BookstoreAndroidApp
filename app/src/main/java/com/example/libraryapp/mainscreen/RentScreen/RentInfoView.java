package com.example.libraryapp.mainscreen.RentScreen;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.libraryapp.R;
import com.example.libraryapp.viewmodel.RentInfoViewViewModel;

public class RentInfoView extends Fragment {

    private RentInfoViewViewModel mViewModel;

    public static RentInfoView newInstance() {
        return new RentInfoView();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rent_info_view_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RentInfoViewViewModel.class);
        // TODO: Use the ViewModel
    }

}
