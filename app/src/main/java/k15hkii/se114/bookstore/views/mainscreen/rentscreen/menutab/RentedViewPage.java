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
import k15hkii.se114.bookstore.databinding.RentedViewPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.rentbooksrecycleview.RentBookItem;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.rentbooksrecycleview.RentView;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.rentbooksrecycleview.RentViewAdapter;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class RentedViewPage extends BaseFragment<RentedViewPageFragmentBinding, RentedViewPageViewModel> implements RentedViewPageNavigator {

    public static RentedViewPage newInstance() {
        return new RentedViewPage();
    }
    @Inject
    protected RentViewAdapter rentViewAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.rented_view_page_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        RentedViewPageFragmentBinding rentedViewPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RentedViewPage.this.getContext());
        rentedViewPageFragmentBinding.rcvRentedBookView.setLayoutManager(linearLayoutManager);
        rentedViewPageFragmentBinding.rcvRentedBookView.setAdapter(rentViewAdapter);

        return  view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }


}
