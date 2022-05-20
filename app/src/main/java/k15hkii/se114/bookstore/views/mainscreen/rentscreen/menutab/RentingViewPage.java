package k15hkii.se114.bookstore.views.mainscreen.rentscreen.menutab;

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
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.RentingViewPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.RentBooksRecycleView.RentBookItem;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.RentBooksRecycleView.RentView;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.RentBooksRecycleView.RentViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class RentingViewPage extends BaseFragment<RentingViewPageFragmentBinding, RentingViewPageViewModel> implements RentingViewPageNavigator {

    private RentingViewPageFragmentBinding rentingViewPageFragmentBinding;
    private RentingViewPageViewModel mViewModel;
    private RecyclerView rcvRentView;
    private RentViewAdapter rentViewAdapter;

    public static RentingViewPage newInstance() {
        return new RentingViewPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.RentingViewPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.renting_view_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        rentingViewPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        rcvRentView = view.findViewById(R.id.rcvRentingBookView);

        //TODO: Fix bug lỗi hiển thị các adapter khi chuyển fragment

        rentViewAdapter = new RentViewAdapter(getListBook(),RentingViewPage.this.getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RentingViewPage.this.getContext());
        rcvRentView.setLayoutManager(linearLayoutManager);
        rcvRentView.setAdapter(rentViewAdapter);

//        rentViewAdapter = new OrderViewAdapter(getListBook1(), RentingViewPage.this.getContext());
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RentingViewPage.this.getContext());
//        rcvRentView.setLayoutManager(linearLayoutManager);
//        rcvRentView.setAdapter(rentViewAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }
//    private List<OrderView> getListBook1() {
//        List<OrderView> lsOrder = new ArrayList<>();
//
//        List<OrderItem> lsBook1 = new ArrayList<>();
//        lsBook1.add(new OrderItem("Dac Nhan Tam"));
//        lsBook1.add(new OrderItem("hello"));
//
//
//        List<OrderItem> lsBook2 = new ArrayList<>();
//        lsBook2.add(new OrderItem("Dac Nhan Tam"));
//
//        lsOrder.add(new OrderView("200.000d","nothing",lsBook1));
//        lsOrder.add(new OrderView("120.000d","nothing",lsBook2));
//
//        return lsOrder;
//    }

    private List<RentView> getListBook() {
        List<RentView> lsRentOrder = new ArrayList<>();

        List<RentBookItem> lsBook1 = new ArrayList<>();
        lsBook1.add(new RentBookItem("Dac Nhan Tam"));
        lsBook1.add(new RentBookItem("hello"));


        List<RentBookItem> lsBook2 = new ArrayList<>();
        lsBook2.add(new RentBookItem("Dac Nhan Tam"));

        lsRentOrder.add(new RentView("20.000đ","nothing1",lsBook1));
        lsRentOrder.add(new RentView("10.000đ","nothing2",lsBook2));

        return lsRentOrder;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RentingViewPageViewModel.class);
        // TODO: Use the ViewModel
    }

}
