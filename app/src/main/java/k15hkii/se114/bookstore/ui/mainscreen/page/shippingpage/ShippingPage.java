package k15hkii.se114.bookstore.ui.mainscreen.page.shippingpage;

import android.view.*;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayoutMediator;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.databinding.ShippingPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.OrderMenuTabAdapter;
import k15hkii.se114.bookstore.R;
import com.google.android.material.tabs.TabLayout;

public class ShippingPage extends BaseFragment<ShippingPageFragmentBinding, ShippingPageViewModel> implements ShippingPageNavigator {

    private TabLayout tmOrder;
    private ViewPager2 vpOrder;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.shipping_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ShippingPageFragmentBinding binding = getViewDataBinding();
        viewModel.setNavigator(this);

        tmOrder = binding.tabMenuReceiptNav;
        vpOrder = binding.vpReceiptOrderView;

        //TODO: set position cho menutab

        OrderMenuTabAdapter orderMenuTabAdapter = new OrderMenuTabAdapter(getActivity().getSupportFragmentManager(),
                this.getLifecycle());
        vpOrder.setAdapter(orderMenuTabAdapter);
        new TabLayoutMediator(tmOrder, vpOrder,
                (tab, position) -> {
                    String title = "";
                    switch (position) {
                        case 0:
                            title = "Chờ xác nhận";
                            break;
                        case 1:
                            title = "Đang vận chuyển";
                            break;
                        case 2:
                            title = "Đã vận chuyển";
                            break;
                        case 3:
                            title = "Đơn huỷ";
                            break;
                    }
                    tab.setText(title);
                }
        ).attach();
        if (getArguments() != null) {
            int position = getArguments().getInt("position", 0);
            vpOrder.setCurrentItem(position);
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
}
