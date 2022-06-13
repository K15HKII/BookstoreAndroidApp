package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.cancleorder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.LinearLayoutManager;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.CancleOrderFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.IOrderNavigator;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewViewModel;
import k15hkii.se114.bookstore.ui.order.cancel.OrderCancle;

import javax.inject.Inject;

public class CancelOrder extends BaseFragment<CancleOrderFragmentBinding, CancelOrderViewModel> implements CancleOrderNavigator, IOrderNavigator {

    @Inject
    protected OrderViewAdapter orderViewAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.cancle_order_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        CancleOrderFragmentBinding cancleOrderFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        cancleOrderFragmentBinding.rcvCancleOrderView.setLayoutManager(linearLayoutManager);
        cancleOrderFragmentBinding.rcvCancleOrderView.setAdapter(orderViewAdapter);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void Navigate(OrderViewViewModel vm) {
        Bundle bundle = new Bundle();

        bundle.putSerializable("bill", vm.getBill());
        createTransaction(R.id.fragmentContainerView, OrderCancle.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

}
