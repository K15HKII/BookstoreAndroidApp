package k15hkii.se114.bookstore.ui.orderinfoscreen.orderratingdetail;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.databinding.OrderRatingDetailFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.bookdetailscreen.BookDetailPage;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderdetail.OrderDetail;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderrating.OrderRatingNavigator;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderrating.OrderRatingViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBooksViewAdapter;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBooksViewNavigator;

import javax.inject.Inject;

public class OrderRatingDetail extends BaseFragment<OrderRatingDetailFragmentBinding, OrderRatingViewModel> implements OrderRatingNavigator,
                                                                                                                       OrderBooksViewNavigator {

    private OrderRatingDetailFragmentBinding orderRatingDetailFragmentBinding;

    @Inject
    OrderBooksViewAdapter adapter;

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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        orderRatingDetailFragmentBinding.lvOrderRatingDetailListBooks.setLayoutManager(linearLayoutManager);
        orderRatingDetailFragmentBinding.lvOrderRatingDetailListBooks.setAdapter(adapter);
        adapter.setNavigator(this);

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

    @Override
    public void Navigate(OrderBookViewModel vm) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("book",vm.getBook());
        createTransaction(R.id.fragmentContainerView, BookDetailPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }
}
