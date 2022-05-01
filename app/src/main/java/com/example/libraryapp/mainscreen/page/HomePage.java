package com.example.libraryapp.mainscreen.page;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.libraryapp.*;
import com.example.libraryapp.mainscreen.HomeScreen.HomeChipNavigation.*;
import com.example.libraryapp.viewmodel.HomeViewViewModel;
import com.google.android.material.chip.Chip;

public class HomePage extends Fragment {

    private HomeViewViewModel mViewModel;
//    private ChipGroup chipNavi;
    private Chip chipAllTopics, chipAllBooks, chipPoppularBooks, chipFamiliarBooks, chipForYouBooks;
    private Button btnFilter;


    public static HomePage newInstance() {
        return new HomePage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_page_fragment, container, false);

        btnFilter = v.findViewById(R.id.etHomeFilterbox);

//        chipNavi = v.findViewById(R.id.chipgrpHomeChipNavigation);
        chipAllTopics = v.findViewById(R.id.chipHomeAllTopics);
        chipAllBooks = v.findViewById(R.id.chipHomeAllBooks);
        chipPoppularBooks = v.findViewById(R.id.chipHomePopularBooks);
        chipFamiliarBooks = v.findViewById(R.id.chipHomeFamiliarBooks);
        chipForYouBooks = v.findViewById(R.id.chipHomeForYouBooks);


        chipAllTopics.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerHomeView, AllTopicPage.class,null).commit();
                return false;
            }
        });

        chipAllBooks.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerHomeView, AllBooksPage.class,null).commit();
                return false;
            }
        });

        chipPoppularBooks.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerHomeView, PopularBooksPage.class,null).commit();
                return false;
            }
        });

        chipFamiliarBooks.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerHomeView, FamiliarBooksPage.class,null).commit();
                return false;
            }
        });

        chipForYouBooks.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerHomeView, ForYouBooksPage.class,null).commit();
                return false;
            }
        });

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChangeName(Gravity.TOP);
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

    private void openChangeName(int gravity){
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.filter_search_dialog);

        Window window = dialog.getWindow();
        if(window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAtributes = window.getAttributes();
        windowAtributes.gravity = gravity;
        window.setAttributes(windowAtributes);

        if(Gravity.TOP == gravity);
        {
            dialog.setCancelable(true);
        }

        dialog.show();
    }

    void AllTopicFragmentChange(){
        FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerHomeView, AllBooksPage.class,null).commit();
    }

}
