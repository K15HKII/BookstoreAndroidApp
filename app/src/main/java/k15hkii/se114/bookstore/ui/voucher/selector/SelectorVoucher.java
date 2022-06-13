package k15hkii.se114.bookstore.ui.voucher.selector;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.SelectorVoucherFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.voucher.adapter.VoucherItemAdapter;
import k15hkii.se114.bookstore.ui.voucher.adapter.VoucherItemAdapterViewModel;
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
        getParentFragmentManager().popBackStack();
    }

    @Override
    public void accept() {
        VoucherItemAdapterViewModel vm = viewModel.getSelectedVoucher();
        setCloseCallbackData(vm == null ? null : vm.getVoucher());
        getParentFragmentManager().popBackStack();
    }

}
