package k15hkii.se114.bookstore.views.mainscreen.page.shippingpage;

import android.app.Dialog;
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
import k15hkii.se114.bookstore.databinding.ShippingPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.searchbook.SearchBookView;
import k15hkii.se114.bookstore.views.mainscreen.ShipmentScreen.OrderMenuTabAdapter;
import k15hkii.se114.bookstore.R;
import com.google.android.material.tabs.TabLayout;
import k15hkii.se114.bookstore.views.notificationnews.NotificationPage;
import k15hkii.se114.bookstore.views.oncartscreen.OncartViewPage;

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
        FragmentManager fragmentManager = ShippingPage.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, SearchBookView.class,null).addToBackStack(null).commit();
    }

    @Override
    public void openNotificationView() {
        FragmentManager fragmentManager = ShippingPage.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, NotificationPage.class,null).addToBackStack(null).commit();
    }

    @Override
    public void openOnCartView() {
        FragmentManager fragmentManager = ShippingPage.this.getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, OncartViewPage.class,null).addToBackStack(null).commit();
    }

    @Override
    public void openFilterDialog() {
        openFilter(Gravity.TOP);
    }
}
