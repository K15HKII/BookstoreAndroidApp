package com.example.libraryapp;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.example.libraryapp.ViewModel.HomeViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends Fragment {

    private HomeViewModel mViewModel;

    public static Home newInstance() {
        return new Home();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_navigation, container, false);

        View navView = view.findViewById(R.id.navView);

        BottomNavigationView navBottomNavigation = view.findViewById(R.id.BotNavi);
        NavController ctrl = Navigation.findNavController(navView);
        NavigationUI.setupWithNavController(navBottomNavigation, ctrl);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

}