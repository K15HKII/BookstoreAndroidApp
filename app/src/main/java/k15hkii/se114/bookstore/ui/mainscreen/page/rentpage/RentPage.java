package k15hkii.se114.bookstore.ui.mainscreen.page.rentpage;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.*;
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
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.dialog.filtersearch.FilterSearchDialog;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add.AddRentBookDetail;
import k15hkii.se114.bookstore.ui.searchbook.SearchBookView;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add.AddRentBookView;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.RentBookMenuTabAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import k15hkii.se114.bookstore.ui.notificationnews.NotificationPage;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartViewPage;

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
        createTransaction(R.id.fragmentContainerView, SearchBookView.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openNotificationView() {
        createTransaction(R.id.fragmentContainerView, NotificationPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openOnCartView() {
        createTransaction(R.id.fragmentContainerView, OncartViewPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openAddRentBill() {
        createTransaction(R.id.fragmentContainerView, AddRentBookDetail.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openFilterDialog() {
        FilterSearchDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }
}
