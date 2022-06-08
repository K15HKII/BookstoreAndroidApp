package k15hkii.se114.bookstore.ui.orderinfoscreen.orderrating;

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
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.databinding.OrderRatingFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;

public class OrderRating extends BaseFragment<OrderRatingFragmentBinding, OrderRatingViewModel> implements OrderRatingNavigator {

    private OrderRatingFragmentBinding orderRatingFragmentBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.order_rating_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        orderRatingFragmentBinding = getViewDataBinding();
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
