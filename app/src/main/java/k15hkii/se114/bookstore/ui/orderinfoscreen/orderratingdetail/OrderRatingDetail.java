package k15hkii.se114.bookstore.ui.orderinfoscreen.orderratingdetail;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.OrderRatingDetailFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderrating.OrderRatingNavigator;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderrating.OrderRatingViewModel;

public class OrderRatingDetail extends BaseFragment<OrderRatingDetailFragmentBinding, OrderRatingViewModel> implements OrderRatingNavigator {

    private OrderRatingDetailFragmentBinding orderRatingDetailFragmentBinding;

    public static OrderRatingDetail newInstance() {
        return new OrderRatingDetail();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.order_rating_detail_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        orderRatingDetailFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
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
