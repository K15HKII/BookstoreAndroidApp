package com.example.libraryapp.mainscreen.page;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Handler;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.example.libraryapp.R;
import com.example.libraryapp.loginscreen.LoadingDialog;
import com.example.libraryapp.mainscreen.RentScreen.RentBookMenuTabAdapter;
import com.example.libraryapp.mainscreen.ShipmentScreen.OrderMenuTabAdapter;
import com.example.libraryapp.viewmodel.RentPageViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class RentPage extends Fragment {

    private RentPageViewModel mViewModel;
    private TabLayout tabMenuNav;
    private FloatingActionButton btnAdd;
    private ViewPager RentView;

    public static RentPage newInstance() {
        return new RentPage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rent_page_fragment, container, false);

//        final LoadingDialog loadingDialog = new LoadingDialog(getActivity());
//        loadingDialog.startLoadingDialog();
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                loadingDialog.dismissDialog();
//            }
//        },500);

        btnAdd = view.findViewById(R.id.btnRentBookAdd);
        tabMenuNav = view.findViewById(R.id.tabMenuRentNav);
        RentView = view.findViewById(R.id.vpRentBookView);

        btnAdd.setImageTintList(ColorStateList.valueOf(Color.rgb(255,255,255)));

        RentBookMenuTabAdapter rentBookView = new RentBookMenuTabAdapter(
                getActivity().getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        RentView.setAdapter(rentBookView);
        tabMenuNav.setupWithViewPager(RentView);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RentPageViewModel.class);
        // TODO: Use the ViewModel
    }

}
