package k15hkii.se114.bookstore.views.bankscreen;

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
import k15hkii.se114.bookstore.databinding.SelectorBankFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.bankscreen.RecycleViewBankSelector.OtherBankAdapter;
import k15hkii.se114.bookstore.views.bankscreen.add.AddBankPage;

import java.util.ArrayList;
import java.util.List;

public class SelectorBankPage extends BaseFragment<SelectorBankFragmentBinding, SelectorBankPageViewModel> implements SelectorBankPageNavigator {

    private SelectorBankFragmentBinding selectorBankFragmentBinding;
    private SelectorBankPageViewModel mViewModel;
    private OtherBankAdapter otherBankAdapter;
    private RecyclerView rcvOtherBankAccount;

    public static SelectorBankPage newInstance() {
        return new SelectorBankPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.SelectorBankPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.selector_bank_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        selectorBankFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        rcvOtherBankAccount = view.findViewById(R.id.rcvBankChoiceOtherBank);
        String[] names = {"TechComBank","MBBank"};

        List<BankAccount> arrayName = new ArrayList<BankAccount>();
        for(int i=0;i<names.length;i++){
            arrayName.add(new BankAccount(names[i]));
        }

        otherBankAdapter = new OtherBankAdapter(arrayName,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        rcvOtherBankAccount.setLayoutManager(linearLayoutManager);
        rcvOtherBankAccount.setAdapter(otherBankAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SelectorBankPageViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void openAddBankAccount() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, AddBankPage.class, null).addToBackStack(null).commit();
    }
}
