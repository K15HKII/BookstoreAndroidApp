package k15hkii.se114.bookstore.ui.accountscreen.voucherscreen;

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
import k15hkii.se114.bookstore.databinding.SelectorVoucherFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.adapterSelect.VoucherItemAdapter;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class SelectorVoucher extends BaseFragment<SelectorVoucherFragmentBinding, SelectorVoucherViewModel> implements SelectorVoucherNavigator {

    @Inject
    protected VoucherItemAdapter adapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.selector_voucher_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        SelectorVoucherFragmentBinding binding = getViewDataBinding();
        viewModel.setNavigator(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        binding.rcvVoucherSelectViewVoucherList.setLayoutManager(layoutManager);
        binding.rcvVoucherSelectViewVoucherList.setAdapter(adapter);

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
