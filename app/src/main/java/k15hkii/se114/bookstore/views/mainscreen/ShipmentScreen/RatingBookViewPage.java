package k15hkii.se114.bookstore.views.mainscreen.ShipmentScreen;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.views.mainscreen.ShipmentScreen.OrderShipmentAdapter.OrderItemsRecycleView.OrderItem;
import k15hkii.se114.bookstore.views.mainscreen.ShipmentScreen.OrderShipmentAdapter.OrderItemsRecycleView.OrderView;
import k15hkii.se114.bookstore.views.mainscreen.ShipmentScreen.OrderShipmentAdapter.OrderItemsRecycleView.OrderViewAdapter;
import k15hkii.se114.bookstore.R;

import java.util.ArrayList;
import java.util.List;

public class RatingBookViewPage extends Fragment {

    private RatingBookViewPageViewModel mViewModel;
    private RecyclerView rcvOrderView;
    private OrderViewAdapter orderViewAdapter;

    public static RatingBookViewPage newInstance() {
        return new RatingBookViewPage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rating_view_fragment, container, false);
        rcvOrderView = view.findViewById(R.id.rcvRatingOrderView);
        orderViewAdapter = new OrderViewAdapter(getListBook());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RatingBookViewPage.this.getContext());
        rcvOrderView.setLayoutManager(linearLayoutManager);
        rcvOrderView.setAdapter(orderViewAdapter);
        return view;
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
