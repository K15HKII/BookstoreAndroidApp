package k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.ratingbookview;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.databinding.RatingViewFragmentBinding;
import k15hkii.se114.bookstore.databinding.WaitingOrderViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderItem;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderView;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderViewAdapter;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.waitingorderview.WaitingOrderViewPage;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class RatingBookViewPage extends BaseFragment<RatingViewFragmentBinding, RatingBookViewPageViewModel> implements RatingBookViewPageNavigator {

    @Inject protected OrderViewAdapter orderViewAdapter;

    public static RatingBookViewPage newInstance() {
        return new RatingBookViewPage();
    }

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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RatingBookViewPage.this.getContext());
        ratingViewFragmentBinding.rcvRatingOrderView.setLayoutManager(linearLayoutManager);
        ratingViewFragmentBinding.rcvRatingOrderView.setAdapter(orderViewAdapter);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }


}
