package k15hkii.se114.bookstore.views.mainscreen.rentscreen;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.RentInfoViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;

public class RentInfoView extends BaseFragment<RentInfoViewFragmentBinding, RentInfoViewViewModel> implements RentInfoViewNavigator {

    private RentInfoViewFragmentBinding rentInfoViewFragmentBinding;
    private RentInfoViewViewModel mViewModel;

    public static RentInfoView newInstance() {
        return new RentInfoView();
    }

    @Override
    public int getBindingVariable() {
        return BR.RentInfoViewViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.rent_info_view_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        rentInfoViewFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RentInfoViewViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
