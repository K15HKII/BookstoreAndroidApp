package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.RentingViewPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.detail.RentDetailBill;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewNavigator;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewViewModel;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class RentingViewPage extends BaseFragment<RentingViewPageFragmentBinding, RentingViewPageViewModel> implements RentingViewPageNavigator, RentViewNavigator {

    @Inject
    protected RentViewAdapter rentViewAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.renting_view_page_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        RentingViewPageFragmentBinding rentingViewPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        rentViewAdapter.setRentViewNavigator(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RentingViewPage.this.getContext());
        rentingViewPageFragmentBinding.rcvRentingBookView.setLayoutManager(linearLayoutManager);
        rentingViewPageFragmentBinding.rcvRentingBookView.setAdapter(rentViewAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }


    @Override
    public void Navigate(RentViewViewModel vm) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("lending", vm.getLend());
        createTransaction(R.id.fragmentContainerView, RentDetailBill.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

}
