package k15hkii.se114.bookstore.views.orderinfoscreen;

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
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.OrderInfoPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.orderinfoscreen.RecycleViewOrderBooks.OrderBookView;
import k15hkii.se114.bookstore.views.orderinfoscreen.RecycleViewOrderBooks.OrderBooksViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class OrderInfoPage extends BaseFragment<OrderInfoPageFragmentBinding, OrderInfoPageViewModel> implements OrderInfoPageNavigator {

    private OrderInfoPageFragmentBinding orderInfoPageFragmentBinding;
    private OrderInfoPageViewModel mViewModel;
    private RecyclerView rcvListBooks;
    private OrderBooksViewAdapter orderBooksViewAdapter;

    public static OrderInfoPage newInstance() {
        return new OrderInfoPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.OrderInfoPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.order_info_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        orderInfoPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        String[] items = {"Dac nhan tam", "Nguoi phan xu", "Kteam"};

        rcvListBooks = view.findViewById(R.id.lvOrderPageListBooks);

        List<OrderBookView> arrayName = new ArrayList<OrderBookView>();
        for(int i=0;i<items.length;i++){
            arrayName.add(new OrderBookView(items[i]));
        }

        orderBooksViewAdapter = new OrderBooksViewAdapter(arrayName,getContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        rcvListBooks.setLayoutManager(layoutManager);
        rcvListBooks.setAdapter(orderBooksViewAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(OrderInfoPageViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
