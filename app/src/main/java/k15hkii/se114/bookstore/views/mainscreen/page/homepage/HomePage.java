package k15hkii.se114.bookstore.views.mainscreen.page.homepage;

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
import k15hkii.se114.bookstore.*;
import k15hkii.se114.bookstore.databinding.HomePageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.SearchBookView;
import k15hkii.se114.bookstore.views.address.RecycleViewAddressSelector.SelectorAddressPage;
import k15hkii.se114.bookstore.views.mainscreen.HomeScreen.HomeChipNavigation.*;
import com.google.android.material.chip.Chip;
import k15hkii.se114.bookstore.views.notificationnews.NotificationPage;
import k15hkii.se114.bookstore.views.oncartscreen.OncartViewPage;

public class HomePage extends BaseFragment<HomePageFragmentBinding,HomePageViewModel> implements HomePageNavigator {

    private HomePageFragmentBinding homePageFragmentBinding;
    private HomePageViewModel mViewModel;
//    private ChipGroup chipNavi;
    private Chip chipAllTopics, chipAllBooks, chipPoppularBooks, chipFamiliarBooks, chipForYouBooks;
    private Button btnFilter, btnNotification, btnOncart;


    public static HomePage newInstance() {
        return new HomePage();
    }

    @Override
    public int getBindingVariable() {
        return BR.HomePageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        homePageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(HomePage.this);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomePageViewModel.class);
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

    @Override
    public void openSearchView() {
        FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, SearchBookView.class,null).addToBackStack(null).commit();
    }

    @Override
    public void openNotificationView() {
        FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, NotificationPage.class,null).addToBackStack(null).commit();
    }

    @Override
    public void openOnCartView() {
        FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, OncartViewPage.class,null).addToBackStack(null).commit();
    }

    @Override
    public void openFilterDialog() {
        openFilter(Gravity.TOP);
    }

    @Override
    public void openAllTopicView() {
        FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerHomeView, AllTopicPage.class,null).commit();
    }

    @Override
    public void openAllBooksView() {
        FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerHomeView, AllBooksPage.class,null).commit();
    }

    @Override
    public void openPoppularBooksView() {
        FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerHomeView, PopularBooksPage.class,null).commit();
    }

    @Override
    public void openFamiliarBooksView() {
        FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerHomeView, FamiliarBooksPage.class,null).commit();
    }

    @Override
    public void openForYouBooksView() {
        FragmentManager fragmentManager = HomePage.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerHomeView, ForYouBooksPage.class,null).commit();
    }
}
