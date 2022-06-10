package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.detail;

import androidx.databinding.library.baseAdapters.BR;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.data.model.api.lend.Lend;
import k15hkii.se114.bookstore.databinding.RentDetailBillFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;

public class RentDetailBill extends BaseFragment<RentDetailBillFragmentBinding, RentDetailBillViewModel> implements RentDetailBillNavigator {

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.rent_detail_bill_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        RentDetailBillFragmentBinding rentDetailBillFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        Bundle bundle = this.getArguments();

        if (bundle.containsKey("lending")) {
            Lend lending = (Lend) bundle.getSerializable("lending");
            viewModel.setLend(lending);
        }
        else if (bundle.containsKey("lended")) {
            Lend lended = (Lend) bundle.getSerializable("lended");
            viewModel.setLend(lended);
        }
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
