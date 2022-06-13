package k15hkii.se114.bookstore.ui.mainscreen.page.rentpage;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.*;
import android.widget.LinearLayout;
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
import k15hkii.se114.bookstore.databinding.ShippingPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.dialog.filtersearch.FilterSearchDialog;
import k15hkii.se114.bookstore.ui.mainscreen.page.homepage.HomeMenuTab;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add.AddRentBookDetail;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.OrderMenuTabAdapter;
import k15hkii.se114.bookstore.ui.searchbook.SearchBookView;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add.AddRentBookView;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.RentBookMenuTabAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import k15hkii.se114.bookstore.ui.notificationnews.NotificationPage;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartViewPage;
import k15hkii.se114.bookstore.utils.ScreenUtils;

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
        initViewPager();
        return view;
    }

    private final String[] TITLE = new String[] {
            "Đang thuê",
            "Đã thuê"
    };

    private void initViewPager() {
        RentPageFragmentBinding binding = getViewDataBinding();
        TabLayout tlContent = binding.tabMenuRentNav;

        {
            View root = tlContent.getChildAt(0);
            if (root instanceof LinearLayout) {
                ((LinearLayout) root).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
                GradientDrawable drawable = new GradientDrawable();
                drawable.setColor(Color.TRANSPARENT);
                drawable.setSize((int) ScreenUtils.convertPixelsToDp(36, getContext()), 1);
                ((LinearLayout) root).setDividerPadding(10);
                ((LinearLayout) root).setDividerDrawable(drawable);
            }
        }

        ViewPager2 vpContent = binding.vpRentBookView;
        RentBookMenuTabAdapter adapter = new RentBookMenuTabAdapter(getChildFragmentManager(), this.getLifecycle());
        vpContent.setAdapter(adapter);
        tlContent.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            private void updateTab(TabLayout.Tab tab, int position, boolean isSelected) {
                int resId = 0;
                switch (position) {
                    case 0:
                        resId = isSelected ? R.drawable.adapter_menutab_head : R.drawable.adapter_menutab_head_unselect;
                        break;
                    /*case 1:
                    case 2:
                        resId = isSelected ? R.drawable.adapter_menutab_body : R.drawable.adapter_menu_body_unselect;
                        break;*/
                    case 1:
                        resId = isSelected ? R.drawable.adapter_menu_tail : R.drawable.adapter_menu_tail_unselect;
                        break;
                }

                if (resId != 0) {
                    Drawable d = getResources().getDrawable(resId, null);
                    tab.view.setBackground(d);
                }
            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                updateTab(tab, tab.getPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                updateTab(tab, tab.getPosition(), false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        TabLayoutMediator mediator = new TabLayoutMediator(tlContent, vpContent,
                (tab, position) -> {
                    String title = TITLE[position];
                    int resId = 0;
                    switch (position) {
                        case 0:
                            resId = R.drawable.adapter_menutab_head_unselect;
                            break;
                        /*case 1:
                        case 2:
                            resId = R.drawable.adapter_menu_body_unselect;
                            break;*/
                        case 1:
                            resId = R.drawable.adapter_menu_tail_unselect;
                            break;
                    }

                    if (resId != 0) {
                        Drawable d = getResources().getDrawable(resId, null);
                        tab.view.setBackground(d);
                    }
                    tab.setText(title);
                });
        mediator.attach();
        Bundle bundle = getArguments();
        if (bundle != null) {
            int position = bundle.getInt("position");
            vpContent.setCurrentItem(position);
        }
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
