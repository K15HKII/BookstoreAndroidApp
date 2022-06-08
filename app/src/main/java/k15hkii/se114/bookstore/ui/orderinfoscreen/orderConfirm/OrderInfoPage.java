package k15hkii.se114.bookstore.ui.orderinfoscreen.orderConfirm;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.data.model.api.Bill;
import k15hkii.se114.bookstore.databinding.OrderInfoPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.bookdetailscreen.BookDetailPage;
import k15hkii.se114.bookstore.ui.mainscreen.page.homepage.HomePage;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderdetail.OrderDetail;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBooksViewAdapter;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBooksViewNavigator;
import k15hkii.se114.bookstore.ui.success.order.OrderSuccess;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class OrderInfoPage extends BaseFragment<OrderInfoPageFragmentBinding, OrderInfoPageViewModel> implements OrderInfoPageNavigator,
                                                                                                                 OrderBooksViewNavigator {
    @Inject protected OrderBooksViewAdapter orderBooksViewAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.order_info_page_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        OrderInfoPageFragmentBinding orderInfoPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        orderInfoPageFragmentBinding.lvOrderPageListBooks.setLayoutManager(layoutManager);
        orderInfoPageFragmentBinding.lvOrderPageListBooks.setAdapter(orderBooksViewAdapter);

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

    @Override
    public void SucceedOrder() {
        createTransaction(R.id.fragmentContainerView, OrderSuccess.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void Navigate(OrderBookViewModel vm) {
        createTransaction(R.id.fragmentContainerView, BookDetailPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }
}
