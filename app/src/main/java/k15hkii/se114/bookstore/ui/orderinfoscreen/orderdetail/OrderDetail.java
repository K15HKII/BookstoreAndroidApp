package k15hkii.se114.bookstore.ui.orderinfoscreen.orderdetail;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.databinding.OrderDetailFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.waitingorderview.WaitingOrderViewPage;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBooksViewAdapter;

import javax.inject.Inject;
import java.util.List;

public class OrderDetail extends BaseFragment<OrderDetailFragmentBinding, OrderDetailViewModel> implements OrderDetailNavigator {

    OrderDetailFragmentBinding orderDetailFragmentBinding;

    @Inject
    OrderBooksViewAdapter adapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.order_detail_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        orderDetailFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        orderDetailFragmentBinding.lvOrderDetailListBooks.setLayoutManager(linearLayoutManager);
        orderDetailFragmentBinding.lvOrderDetailListBooks.setAdapter(adapter);

        Bundle bundle = this.getArguments();
        Bill bill = (Bill) bundle.getSerializable("bill");
        viewModel.setBill(bill);
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
