package com.example.libraryapp;

import android.view.MotionEvent;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.libraryapp.ViewModel.HomeViewViewModel;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;

public class home_view extends Fragment {

    private HomeViewViewModel mViewModel;
//    private ChipGroup chipNavi;
    private Chip chipAllTopics, chipAllBooks, chipPoppularBooks, chipFamiliarBooks, chipForYouBooks;


    public static home_view newInstance() {
        return new home_view();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_view_fragment, container, false);

//        chipNavi = v.findViewById(R.id.chipgrpHomeChipNavigation);
        chipAllTopics = v.findViewById(R.id.chipHomeAllTopics);
        chipAllBooks = v.findViewById(R.id.chipHomeAllBooks);
        chipPoppularBooks = v.findViewById(R.id.chipHomePopularBooks);
        chipFamiliarBooks = v.findViewById(R.id.chipHomeFamiliarBooks);
        chipForYouBooks = v.findViewById(R.id.chipHomeForYouBooks);


        chipAllTopics.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FragmentManager fragmentManager = home_view.this.getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerHomeView,all_topic.class,null).commit();
                return false;
            }
        });

        chipAllBooks.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FragmentManager fragmentManager = home_view.this.getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerHomeView,all_books_view.class,null).commit();
                return false;
            }
        });

        chipPoppularBooks.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FragmentManager fragmentManager = home_view.this.getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerHomeView,popular_books.class,null).commit();
                return false;
            }
        });

        chipFamiliarBooks.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FragmentManager fragmentManager = home_view.this.getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerHomeView,familiar_books.class,null).commit();
                return false;
            }
        });

        chipForYouBooks.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FragmentManager fragmentManager = home_view.this.getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerHomeView,for_you_books.class,null).commit();
                return false;
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewViewModel.class);
        // TODO: Use the ViewModel
    }

    void AllTopicFragmentChange(){
        FragmentManager fragmentManager = home_view.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerHomeView,all_books_view.class,null).commit();
    }

}
