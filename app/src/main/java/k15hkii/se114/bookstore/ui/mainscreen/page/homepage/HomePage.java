package k15hkii.se114.bookstore.ui.mainscreen.page.homepage;

import android.view.*;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import k15hkii.se114.bookstore.*;
import k15hkii.se114.bookstore.databinding.HomePageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.dialog.filtersearch.FilterSearchDialog;
import k15hkii.se114.bookstore.ui.searchbook.SearchBookView;
import com.google.android.material.chip.Chip;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.allbooks.AllBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.familiarbooks.FamiliarBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.foryoubooks.ForYouBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.popularbooks.PopularBooksPage;
import k15hkii.se114.bookstore.ui.notificationnews.NotificationPage;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartViewPage;

public class HomePage extends BaseFragment<HomePageFragmentBinding,HomePageViewModel> implements HomePageNavigator {

    private TabLayout tabmenuNav;
    private ViewPager2 newsView;

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
        HomePageFragmentBinding binding = getViewDataBinding();
        tabmenuNav = binding.tabMenuHomeNav;
        newsView = binding.vpHomeBookView;
        HomeMenuTab adapter = new HomeMenuTab(getActivity().getSupportFragmentManager(), this.getLifecycle());
        newsView.setAdapter(adapter);
        new TabLayoutMediator(tabmenuNav, newsView,
                (tab, position) -> {
                    String title = "";
                    switch (position) {
                        case 0:
                            title = "Tất cả";
                            View v = LayoutInflater.from(getContext()).inflate(R.layout.adapter_menutab, tabmenuNav, false);
                            TextView tv = v.findViewById(R.id.tvAdapterMenuTab);
                            tv.setText(title);
                            tab.setCustomView(v);
                            break;
                        case 1:
                            //TODO: fix lỗi hiện tất cả adapter
                            title = "Phổ biến";
//                            View v1 = LayoutInflater.from(getContext()).inflate(R.layout.adapter_menutab2, tabmenuNav, false);
//                            TextView tv1 = v1.findViewById(R.id.tvAdapterMenuTab);
//                            tv1.setText(title);
//                            tab.setCustomView(v1);
                            break;
                        case 2:
                            title = "Gần đây";
//                            View v2 = LayoutInflater.from(getContext()).inflate(R.layout.adapter_menutab2, tabmenuNav, false);
//                            TextView tv2 = v2.findViewById(R.id.tvAdapterMenuTab);
//                            tv2.setText(title);
//                            tab.setCustomView(v2);
                            break;
                        case 3:
                            title = "Dành cho bạn";
//                            View v3 = LayoutInflater.from(getContext()).inflate(R.layout.adapter_menutab2, tabmenuNav, false);
//                            TextView tv3 = v3.findViewById(R.id.tvAdapterMenuTab);
//                            tv3.setText(title);
//                            tab.setCustomView(v3);
                            break;
                    }
                    tab.setText(title);
                }).attach();
        viewModel.setNavigator(HomePage.this);
        return view;
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
