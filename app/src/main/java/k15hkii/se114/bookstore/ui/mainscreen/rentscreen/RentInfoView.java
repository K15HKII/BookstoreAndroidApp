package k15hkii.se114.bookstore.ui.mainscreen.rentscreen;

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
import k15hkii.se114.bookstore.databinding.RentInfoViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewAdapter;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class RentInfoView extends BaseFragment<RentInfoViewFragmentBinding, RentInfoViewViewModel> implements RentInfoViewNavigator {

    @Inject
    protected RentViewAdapter rentViewAdapter;

    public static RentInfoView newInstance() {
        return new RentInfoView();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.rent_info_view_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        RentInfoViewFragmentBinding rentInfoViewFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rentInfoViewFragmentBinding.rcvRentInfoBookList.setLayoutManager(linearLayoutManager);
        rentInfoViewFragmentBinding.rcvRentInfoBookList.setAdapter(rentViewAdapter);

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
