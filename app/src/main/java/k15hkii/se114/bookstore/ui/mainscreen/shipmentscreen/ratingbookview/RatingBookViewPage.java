package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.ratingbookview;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.databinding.RatingViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.IOrderNavigator;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewAdapter;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderratingdetail.OrderRatingDetail;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class RatingBookViewPage extends BaseFragment<RatingViewFragmentBinding, RatingBookViewPageViewModel> implements RatingBookViewPageNavigator, IOrderNavigator {

    @Inject protected OrderViewAdapter orderViewAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.rating_view_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        RatingViewFragmentBinding ratingViewFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        orderViewAdapter.setOrderNavigator(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RatingBookViewPage.this.getContext());
        ratingViewFragmentBinding.rcvRatingOrderView.setLayoutManager(linearLayoutManager);
        ratingViewFragmentBinding.rcvRatingOrderView.setAdapter(orderViewAdapter);
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

        createTransaction(R.id.fragmentContainerView, OrderRatingDetail.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }
}
