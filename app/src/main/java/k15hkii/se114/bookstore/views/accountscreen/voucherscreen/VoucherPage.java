package k15hkii.se114.bookstore.views.accountscreen.voucherscreen;

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
import k15hkii.se114.bookstore.databinding.VoucherViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class VoucherPage extends BaseFragment<VoucherViewFragmentBinding, VoucherPageViewModel> implements VoucherPageNavigator {

    private VoucherViewFragmentBinding voucherViewFragmentBinding;
    private VoucherPageViewModel mViewModel;
    private RecyclerView rcvVoucherList;
    private VoucherViewAdapter voucherViewAdapter;

    public static VoucherPage newInstance() {
        return new VoucherPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.VoucherPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.voucher_view_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        voucherViewFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        String[] names = {"20% Giảm giá","30% Giảm giá","10% Giảm giá"};

        List<Voucher> arrayName = new ArrayList<Voucher>();
        for(int i=0;i<names.length;i++){
            arrayName.add(new Voucher(names[i]));
        }
        rcvVoucherList = view.findViewById(R.id.rcvVoucherViewVoucherList);
        voucherViewAdapter = new VoucherViewAdapter(arrayName,getActivity());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        rcvVoucherList.setLayoutManager(layoutManager);
        rcvVoucherList.setAdapter(voucherViewAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VoucherPageViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
