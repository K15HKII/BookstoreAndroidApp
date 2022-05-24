package k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.shippingview;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.databinding.ShippingViewFragmentBinding;
import k15hkii.se114.bookstore.databinding.WaitingOrderViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItem;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.orderitemsrecycleview.OrderView;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewAdapter;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.waitingorderview.WaitingOrderViewPage;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ShippingViewPage extends BaseFragment<ShippingViewFragmentBinding, ShippingViewPageViewModel> implements ShippingViewPageNavigator {

    @Inject protected OrderViewAdapter orderViewAdapter;

    public static ShippingViewPage newInstance() {
        return new ShippingViewPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.shipping_view_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ShippingViewFragmentBinding shippingOrderViewFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShippingViewPage.this.getContext());
        shippingOrderViewFragmentBinding.rcvShippingOrderView.setLayoutManager(linearLayoutManager);
        shippingOrderViewFragmentBinding.rcvShippingOrderView.setAdapter(orderViewAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }


}
