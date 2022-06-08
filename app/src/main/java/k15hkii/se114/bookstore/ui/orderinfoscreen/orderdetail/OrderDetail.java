package k15hkii.se114.bookstore.ui.orderinfoscreen.orderdetail;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.databinding.OrderDetailFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;

public class OrderDetail extends BaseFragment<OrderDetailFragmentBinding, OrderDetailViewModel> implements OrderDetailNavigator {

    OrderDetailFragmentBinding orderDetailFragmentBinding;

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
