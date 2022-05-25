package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.add;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.AddRentBookDetailFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;

public class AddRentBookDetail extends BaseFragment<AddRentBookDetailFragmentBinding, AddRentBookDetailViewModel> implements AddRentBookDetailNavigator {

    private AddRentBookDetailFragmentBinding addRentBookDetailFragmentBinding;
    private AddRentBookDetailViewModel mViewModel;

    public static AddRentBookDetail newInstance() {
        return new AddRentBookDetail();
    }

    @Override
    public int getBindingVariable() {
        return BR.AddRentBookDetailViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.add_rent_book_detail_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        addRentBookDetailFragmentBinding = getViewDataBinding();
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
        mViewModel = new ViewModelProvider(this).get(AddRentBookDetailViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
