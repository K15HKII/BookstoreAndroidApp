package k15hkii.se114.bookstore.ui.mainscreen.page.shippingpage;

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
import k15hkii.se114.bookstore.databinding.ShippingPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.dialog.filtersearch.FilterSearchDialog;
import k15hkii.se114.bookstore.ui.searchbook.SearchBookView;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.OrderMenuTabAdapter;
import k15hkii.se114.bookstore.R;
import com.google.android.material.tabs.TabLayout;
import k15hkii.se114.bookstore.ui.notificationnews.NotificationPage;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartViewPage;

public class ShippingPage extends BaseFragment<ShippingPageFragmentBinding, ShippingPageViewModel> implements ShippingPageNavigator {

    private ShippingPageFragmentBinding shippingPageFragmentBinding;
    private ShippingPageViewModel mViewModel;
    private TabLayout tabmenuNav;
    private ViewPager orderView;

    public static ShippingPage newInstance() {
        return new ShippingPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.ShippingPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.shipping_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        shippingPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        tabmenuNav = view.findViewById(R.id.tabMenuReceiptNav);
        orderView = view.findViewById(R.id.vpReceiptOrderView);

//        final LoadingDialog loadingDialog = new LoadingDialog(getActivity());
//        loadingDialog.startLoadingDialog();
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                loadingDialog.dismissDialog();
//            }
//        },500);

        OrderMenuTabAdapter orderMenuTabAdapter = new OrderMenuTabAdapter(getActivity().getSupportFragmentManager(),
                                                    FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        orderView.setAdapter(orderMenuTabAdapter);
        tabmenuNav.setupWithViewPager(orderView);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ShippingPageViewModel.class);
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
    public void openFilterDialog() {
        FilterSearchDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }
}
