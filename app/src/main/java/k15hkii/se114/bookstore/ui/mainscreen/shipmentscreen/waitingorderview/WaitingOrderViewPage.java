package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.waitingorderview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.WaitingOrderViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.IOrderNavigator;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewViewModel;
import k15hkii.se114.bookstore.ui.order.detail.OrderDetail;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class WaitingOrderViewPage extends BaseFragment<WaitingOrderViewFragmentBinding, WaitingOrderListViewModel> implements WaitingOrderViewPageNavigator, IOrderNavigator {

    private WaitingOrderListViewModel mViewModel;
    private final int statusView = 0;

    public int getStatusView() {
        return this.statusView;
    }

    @Inject
    protected OrderViewAdapter orderViewAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.waiting_order_view_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        WaitingOrderViewFragmentBinding waitingOrderViewFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        orderViewAdapter.setOrderNavigator(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(WaitingOrderViewPage.this.getContext());
        waitingOrderViewFragmentBinding.rcvWaitingOrderOrderView.setLayoutManager(linearLayoutManager);
        waitingOrderViewFragmentBinding.rcvWaitingOrderOrderView.setAdapter(orderViewAdapter);

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

        createTransaction(R.id.fragmentContainerView, OrderDetail.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

}
