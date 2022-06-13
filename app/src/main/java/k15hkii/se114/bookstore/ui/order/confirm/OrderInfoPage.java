package k15hkii.se114.bookstore.ui.order.confirm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.data.model.api.voucher.Voucher;
import k15hkii.se114.bookstore.databinding.OrderInfoPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.account.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.book.detail.BookDetailPage;
import k15hkii.se114.bookstore.ui.order.PaymentMethodPage;
import k15hkii.se114.bookstore.ui.order.adapter.OrderBookViewModel;
import k15hkii.se114.bookstore.ui.order.adapter.OrderBooksViewAdapter;
import k15hkii.se114.bookstore.ui.order.adapter.OrderBooksViewNavigator;
import k15hkii.se114.bookstore.ui.success.order.OrderSuccess;
import k15hkii.se114.bookstore.ui.voucher.selector.SelectorVoucher;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class OrderInfoPage extends BaseFragment<OrderInfoPageFragmentBinding, OrderInfoPageViewModel> implements OrderInfoPageNavigator,
        OrderBooksViewNavigator {

    @Inject
    protected OrderBooksViewAdapter adapter;

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

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        orderInfoPageFragmentBinding.lvOrderPageListBooks.setLayoutManager(layoutManager);
        orderInfoPageFragmentBinding.lvOrderPageListBooks.setAdapter(adapter);
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

    @Override
    public void openSelectAddress() {
        createTransaction(R.id.fragmentContainerView, SelectorAddressPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openSelectVoucher() {
        SelectorVoucher selectorVoucher = new SelectorVoucher();
        selectorVoucher.addCloseCallback((data) -> {
            viewModel.setVoucher((Voucher) data);
        });
        createTransaction(R.id.fragmentContainerView, selectorVoucher, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openSelectPayment() {
        PaymentMethodPage paymentSelector = new PaymentMethodPage();
        paymentSelector.addCloseCallback((data) -> {
            viewModel.setVoucher((Voucher) data);
        });
        createTransaction(R.id.fragmentContainerView, paymentSelector, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

}
