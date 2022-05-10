package k15hkii.se114.bookstore.views.mainscreen.page;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.*;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import k15hkii.se114.bookstore.*;
import k15hkii.se114.bookstore.views.SearchBookView;
import k15hkii.se114.bookstore.views.address.RecycleViewAddressSelector.SelectorAddressPage;
import k15hkii.se114.bookstore.views.bankscreen.RecycleViewBankSelector.SelectorBankPage;
import k15hkii.se114.bookstore.views.mainscreen.HomeScreen.HomeChipNavigation.*;
import k15hkii.se114.bookstore.viewmodel.HomeViewViewModel;
import com.google.android.material.chip.Chip;

public class HomePage extends Fragment {

    private HomeViewViewModel mViewModel;
//    private ChipGroup chipNavi;
    private Chip chipAllTopics, chipAllBooks, chipPoppularBooks, chipFamiliarBooks, chipForYouBooks;
    private Button btnFilter, btnNotification, btnOncart;
    private TextView tvSearch;


    public static HomePage newInstance() {
        return new HomePage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_page_fragment, container, false);

        btnFilter = v.findViewById(R.id.etHomeFilterbox);
        btnNotification = v.findViewById(R.id.btnHomeNotification);
        btnOncart = v.findViewById(R.id.btnHomeShoppingCart);
        tvSearch = v.findViewById(R.id.tvHomeSearchBox);

//        chipNavi = v.findViewById(R.id.chipgrpHomeChipNavigation);
        chipAllTopics = v.findViewById(R.id.chipHomeAllTopics);
        chipAllBooks = v.findViewById(R.id.chipHomeAllBooks);
        chipPoppularBooks = v.findViewById(R.id.chipHomePopularBooks);
        chipFamiliarBooks = v.findViewById(R.id.chipHomeFamiliarBooks);
        chipForYouBooks = v.findViewById(R.id.chipHomeForYouBooks);

        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerView, SearchBookView.class,null).addToBackStack("").commit();
            }
        });

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
                openFilter(Gravity.TOP);
            }
        });

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerView, SelectorBankPage.class,null).addToBackStack("").commit();
            }
        });

        btnOncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerView, SelectorAddressPage.class,null).addToBackStack("").commit();
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

    private void openFilter(int gravity){
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.filter_search_dialog);

        SeekBar skPrice = dialog.findViewById(R.id.skbarFilterSearchPrice);
        TextView tvPrice = dialog.findViewById(R.id.tvFilterSearchPrice);

        skPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvPrice.setText("" + String.format("%,.0f",(double)i) + "đ - 2.000.000đ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

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
