package k15hkii.se114.bookstore.ui.account.address;

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
import k15hkii.se114.bookstore.databinding.SelectorAddressFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.account.address.add.AddAddressPage;
import k15hkii.se114.bookstore.ui.account.address.recycleViewAddressSelector.OtherAddressAdapter;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class SelectorAddressPage extends BaseFragment<SelectorAddressFragmentBinding, SelectorAddressPageViewModel> implements SelectorAddressPageNavigator {

    @Inject
    protected OtherAddressAdapter otherAddressAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.selector_address_fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        getViewDataBinding().getViewModel().loadData();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        SelectorAddressFragmentBinding selectorAddressFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        selectorAddressFragmentBinding.rcvAddressChoiceOtherAddress.setLayoutManager(linearLayoutManager);
        selectorAddressFragmentBinding.rcvAddressChoiceOtherAddress.setAdapter(otherAddressAdapter);

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

    @Override
    public void openAddBank() {
        createTransaction(R.id.fragmentContainerView, AddAddressPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

}
