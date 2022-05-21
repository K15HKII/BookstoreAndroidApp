package k15hkii.se114.bookstore.views.bankscreen.add;

import android.widget.ExpandableListView;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.databinding.AddBankAccountFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.bankscreen.BankExpandableListView.BankGroup;
import k15hkii.se114.bookstore.views.bankscreen.BankExpandableListView.BankItems;
import k15hkii.se114.bookstore.views.bankscreen.BankExpandableListView.ExpandableBankAdapter;
import k15hkii.se114.bookstore.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddBankPage extends BaseFragment<AddBankAccountFragmentBinding, AddBankPageViewModel> implements AddBankPageNavigator {

    private AddBankAccountFragmentBinding addBankAccountFragmentBinding;
    private AddBankPageViewModel mViewModel;
    private ExpandableListView lvBank;
    private List<BankGroup> lsbankgroup;
    private Map<BankGroup, List<BankItems>> lsbankitem;
    private ExpandableBankAdapter expandableBankAdapter;

    public static AddBankPage newInstance() {
        return new AddBankPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.AddBankPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.add_bank_account_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        addBankAccountFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        lvBank = view.findViewById(R.id.lvAddBankBank);
        lsbankitem = getListItems();
        lsbankgroup = new ArrayList<>(lsbankitem.keySet());

        expandableBankAdapter = new ExpandableBankAdapter(lsbankgroup,lsbankitem);
        lvBank.setAdapter(expandableBankAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddBankPageViewModel.class);
        // TODO: Use the ViewModel
    }

    private Map<BankGroup, List<BankItems>> getListItems(){
        Map<BankGroup, List<BankItems>> lsMap = new HashMap<>();

        BankGroup bankname = new BankGroup(1,"Ngân hàng");
        BankGroup location = new BankGroup(2,"Chi nhánh");

        List<BankItems> banksymbol = new ArrayList<>();
        banksymbol.add(new BankItems(1,"VIETCOMBANK"));
        banksymbol.add(new BankItems(2,"TECHCOMBANK"));
        banksymbol.add(new BankItems(3,"AGRIBANK"));

        List<BankItems> banklocation = new ArrayList<>();
        banklocation.add(new BankItems(1,"Nam sài gòn"));
        banklocation.add(new BankItems(2,"Phạm thành thái"));
        banklocation.add(new BankItems(3,"Nguyễn cư trinh"));

        lsMap.put(bankname, banksymbol);
        lsMap.put(location, banklocation);

        return lsMap;
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
