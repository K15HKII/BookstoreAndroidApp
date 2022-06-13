package k15hkii.se114.bookstore.ui.mainscreen.page.homepage;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.HomePageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.book.search.SearchBookView;
import k15hkii.se114.bookstore.ui.cart.OncartViewPage;
import k15hkii.se114.bookstore.ui.dialog.filtersearch.FilterSearchDialog;
import k15hkii.se114.bookstore.utils.ScreenUtils;

public class HomePage extends BaseFragment<HomePageFragmentBinding, HomePageViewModel> implements HomePageNavigator {

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
        initViewPager();

        viewModel.setNavigator(HomePage.this);
        return view;
    }

    private final String[] TITLE = new String[] {
            "Tất cả",
            "Phổ biến",
            "Gần đây",
            "Cho bạn"
    };

    private void initViewPager() {
        HomePageFragmentBinding binding = getViewDataBinding();
        TabLayout tlContent = binding.tabMenuHomeNav;

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

        ViewPager2 vpContent = binding.vpHomeBookView;
        HomeMenuTab adapter = new HomeMenuTab(getChildFragmentManager(), this.getLifecycle());
        vpContent.setAdapter(adapter);
        tlContent.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            private void updateTab(TabLayout.Tab tab, int position, boolean isSelected) {
                int resId = 0;
                switch (position) {
                    case 0:
                        resId = isSelected ? R.drawable.adapter_menutab_head : R.drawable.adapter_menutab_head_unselect;
                        break;
                    case 1:
                    case 2:
                        resId = isSelected ? R.drawable.adapter_menutab_body : R.drawable.adapter_menu_body_unselect;
                        break;
                    case 3:
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
                        case 1:
                        case 2:
                            resId = R.drawable.adapter_menu_body_unselect;
                            break;
                        case 3:
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
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
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
    public void openFilterDialog() {
        FilterSearchDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }

}
