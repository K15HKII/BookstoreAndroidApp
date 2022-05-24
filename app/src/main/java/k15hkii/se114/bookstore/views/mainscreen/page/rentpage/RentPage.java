package k15hkii.se114.bookstore.views.mainscreen.page.rentpage;

import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.*;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.RentPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.dialog.filtersearch.FilterSearchDialog;
import k15hkii.se114.bookstore.views.searchbook.SearchBookView;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.add.AddRentBookView;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.RentBookMenuTabAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import k15hkii.se114.bookstore.views.notificationnews.NotificationPage;
import k15hkii.se114.bookstore.views.oncartscreen.OncartViewPage;

public class RentPage extends BaseFragment<RentPageFragmentBinding, RentPageViewModel> implements RentPageNavigator {

    private RentPageFragmentBinding rentPageFragmentBinding;
    private RentPageViewModel mViewModel;
    private TabLayout tabMenuNav;
    private FloatingActionButton btnAdd;
    private ViewPager RentView;

    public static RentPage newInstance() {
        return new RentPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.RentPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.rent_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        rentPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
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
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RentPageViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void openSearchView() {
        FragmentManager fragmentManager = RentPage.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, SearchBookView.class,null).addToBackStack(null).commit();
    }

    @Override
    public void openNotificationView() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, NotificationPage.class,null).addToBackStack(null).commit();
    }

    @Override
    public void openOnCartView() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, OncartViewPage.class,null).addToBackStack(null).commit();
    }

    @Override
    public void openAddRentBill() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, AddRentBookView.class,null).addToBackStack(null).commit();
    }

    @Override
    public void openFilterDialog() {
        FilterSearchDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }
}
