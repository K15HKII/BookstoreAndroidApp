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
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderItem;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderView;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderViewAdapter;
import k15hkii.se114.bookstore.R;

import java.util.ArrayList;
import java.util.List;

public class RatingBookViewPage extends BaseFragment<RatingViewFragmentBinding, RatingBookViewPageViewModel> implements RatingBookViewPageNavigator {

    private RatingViewFragmentBinding ratingViewFragmentBinding;
    private RatingBookViewPageViewModel mViewModel;
    private RecyclerView rcvOrderView;
    private OrderViewAdapter orderViewAdapter;

    public static RatingBookViewPage newInstance() {
        return new RatingBookViewPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.RatingBookViewPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.rating_view_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ratingViewFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        rcvOrderView = view.findViewById(R.id.rcvRatingOrderView);
        orderViewAdapter = new OrderViewAdapter(getListBook());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RatingBookViewPage.this.getContext());
        rcvOrderView.setLayoutManager(linearLayoutManager);
        rcvOrderView.setAdapter(orderViewAdapter);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    private List<OrderView> getListBook() {
        List<OrderView> lsOrder = new ArrayList<>();

        List<OrderItem> lsBook1 = new ArrayList<>();
        lsBook1.add(new OrderItem("Dac Nhan Tam"));
        lsBook1.add(new OrderItem("hello"));


        List<OrderItem> lsBook2 = new ArrayList<>();
        lsBook2.add(new OrderItem("Dac Nhan Tam"));

        lsOrder.add(new OrderView("200.000d","nothing",lsBook1));
        lsOrder.add(new OrderView("120.000d","nothing",lsBook2));

        return lsOrder;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RatingBookViewPageViewModel.class);
        // TODO: Use the ViewModel
    }

}
