package k15hkii.se114.bookstore.ui.orderinfoscreen;

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
import k15hkii.se114.bookstore.databinding.OrderInfoPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.orderinfoscreen.RecycleViewOrderBooks.OrderBooksViewAdapter;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class OrderInfoPage extends BaseFragment<OrderInfoPageFragmentBinding, OrderInfoPageViewModel> implements OrderInfoPageNavigator {
    @Inject protected OrderBooksViewAdapter orderBooksViewAdapter;

    public static OrderInfoPage newInstance() {
        return new OrderInfoPage();
    }

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

        String[] items = {"Dac nhan tam", "Nguoi phan xu", "Kteam"};

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        orderInfoPageFragmentBinding.lvOrderPageListBooks.setLayoutManager(layoutManager);
        orderInfoPageFragmentBinding.lvOrderPageListBooks.setAdapter(orderBooksViewAdapter);

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
}
