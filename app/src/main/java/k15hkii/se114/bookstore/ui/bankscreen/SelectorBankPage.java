package k15hkii.se114.bookstore.ui.bankscreen;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.SelectorBankFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.bankscreen.recycleViewBankSelector.OtherBankAdapter;
import k15hkii.se114.bookstore.ui.bankscreen.add.AddBankPage;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class SelectorBankPage extends BaseFragment<SelectorBankFragmentBinding, SelectorBankPageViewModel> implements SelectorBankPageNavigator {

    @Inject protected OtherBankAdapter otherBankAdapter;

    public static SelectorBankPage newInstance() {
        return new SelectorBankPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.selector_bank_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        SelectorBankFragmentBinding selectorBankFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        selectorBankFragmentBinding.rcvBankChoiceOtherBank.setLayoutManager(linearLayoutManager);
        selectorBankFragmentBinding.rcvBankChoiceOtherBank.setAdapter(otherBankAdapter);

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
    public void openAddBankAccount() {
        createTransaction(R.id.fragmentContainerView, AddBankPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }
}
