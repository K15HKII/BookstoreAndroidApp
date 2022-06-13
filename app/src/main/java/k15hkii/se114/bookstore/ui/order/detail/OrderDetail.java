package k15hkii.se114.bookstore.ui.order.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.OrderDetailFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.book.detail.BookDetailPage;
import k15hkii.se114.bookstore.ui.order.adapter.OrderBookViewModel;
import k15hkii.se114.bookstore.ui.order.adapter.OrderBooksViewAdapter;
import k15hkii.se114.bookstore.ui.order.adapter.OrderBooksViewNavigator;

import javax.inject.Inject;

public class OrderDetail extends BaseFragment<OrderDetailFragmentBinding, OrderDetailViewModel> implements OrderDetailNavigator,
        OrderBooksViewNavigator {

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

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        orderDetailFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        orderDetailFragmentBinding.lvOrderDetailListBooks.setLayoutManager(linearLayoutManager);
        orderDetailFragmentBinding.lvOrderDetailListBooks.setAdapter(adapter);
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
        bundle.putSerializable("book", vm.getBook());
        createTransaction(R.id.fragmentContainerView, BookDetailPage.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

}
