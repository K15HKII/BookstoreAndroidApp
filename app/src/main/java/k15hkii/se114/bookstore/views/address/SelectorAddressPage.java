package k15hkii.se114.bookstore.views.address;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import k15hkii.se114.bookstore.databinding.SelectorAddressFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.address.RecycleViewAddressSelector.OtherAddressAdapter;
import k15hkii.se114.bookstore.views.bankscreen.add.AddBankPage;

import java.util.ArrayList;
import java.util.List;

public class SelectorAddressPage extends BaseFragment<SelectorAddressFragmentBinding, SelectorAddressPageViewModel> implements SelectorAddressPageNavigator {

    private SelectorAddressFragmentBinding selectorAddressFragmentBinding;
    private SelectorAddressPageViewModel mViewModel;
    private RecyclerView rcvOtherAddress;
    private OtherAddressAdapter otherAddressAdapter;

    public static SelectorAddressPage newInstance() {
        return new SelectorAddressPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.SelectorAddressPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.selector_address_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        selectorAddressFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        rcvOtherAddress = view.findViewById(R.id.rcvAddressChoiceOtherAddress);

        String[] names = {"Biên Hòa, Đồng Nai","Vạn Ninh, Khánh Hòa"};

        List<Address> arrayName = new ArrayList<Address>();
        for(int i=0;i<names.length;i++){
            arrayName.add(new Address(names[i]));
        }

        otherAddressAdapter = new OtherAddressAdapter(arrayName,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        rcvOtherAddress.setLayoutManager(linearLayoutManager);
        rcvOtherAddress.setAdapter(otherAddressAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SelectorAddressPageViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void openAddBank() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, AddBankPage.class, null).addToBackStack(null).commit();
    }
}
