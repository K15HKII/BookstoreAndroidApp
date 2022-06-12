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
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayoutMediator;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.RentPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.dialog.filtersearch.FilterSearchDialog;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add.AddRentBookDetail;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.OrderMenuTabAdapter;
import k15hkii.se114.bookstore.ui.searchbook.SearchBookView;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add.AddRentBookView;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.RentBookMenuTabAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import k15hkii.se114.bookstore.ui.notificationnews.NotificationPage;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartViewPage;

public class RentPage extends BaseFragment<RentPageFragmentBinding, RentPageViewModel> implements RentPageNavigator {

    private TabLayout tabMenuNav;
    private FloatingActionButton btnAdd;
    private ViewPager2 RentView;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.rent_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        RentPageFragmentBinding binding = getViewDataBinding();
        viewModel.setNavigator(this);
        btnAdd = binding.btnRentBookAdd;
        tabMenuNav = binding.tabMenuRentNav;
        RentView = binding.vpRentBookView;

        //TODO: set position cho menutab

        btnAdd.setImageTintList(ColorStateList.valueOf(Color.rgb(255,255,255)));

        RentBookMenuTabAdapter rentBookView = new RentBookMenuTabAdapter(getActivity().getSupportFragmentManager(),
                this.getLifecycle());
        RentView.setAdapter(rentBookView);
        new TabLayoutMediator(tabMenuNav, RentView,
                (tab, position) -> {
                    String title = "";
                    switch (position){
                        case 0:
                            title = "Đang thuê";
                            break;
                        case 1:
                            title = "Đã thuê";
                            break;
                    }
                    tab.setText(title);
                }
        ).attach();
        if (getArguments() != null) {
            int position = getArguments().getInt("position", 0);
            RentView.setCurrentItem(position);
        }
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
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
}
