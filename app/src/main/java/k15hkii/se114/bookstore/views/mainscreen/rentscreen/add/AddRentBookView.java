package k15hkii.se114.bookstore.views.mainscreen.rentscreen.add;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.AddRentBookViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;

public class AddRentBookView extends BaseFragment<AddRentBookViewFragmentBinding,AddRentBookViewViewModel> implements AddRentBookViewNavigator {

    private AddRentBookViewFragmentBinding addRentBookViewFragmentBinding;
    private AddRentBookViewViewModel mViewModel;

    public static AddRentBookView newInstance() {
        return new AddRentBookView();
    }

    @Override
    public int getBindingVariable() {
        return BR.AddRentBookViewViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.add_rent_book_view_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_rent_book_view_fragment, container, false);
        addRentBookViewFragmentBinding = getViewDataBinding();
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
        mViewModel = new ViewModelProvider(this).get(AddRentBookViewViewModel.class);
        // TODO: Use the ViewModel
    }

}
