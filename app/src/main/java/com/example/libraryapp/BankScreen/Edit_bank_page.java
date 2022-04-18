package com.example.libraryapp.BankScreen;

import android.widget.ExpandableListView;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.libraryapp.BankScreen.BankExpandableListView.BankGroup;
import com.example.libraryapp.BankScreen.BankExpandableListView.BankItems;
import com.example.libraryapp.BankScreen.BankExpandableListView.ExpandableBankAdapter;
import com.example.libraryapp.R;
import com.example.libraryapp.ViewModel.EditBankAccountViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Edit_bank_page extends Fragment {

    public static Edit_bank_page newInstance() {
        return new Edit_bank_page();
    }

    private EditBankAccountViewModel mViewModel;
    private ExpandableListView lvBank;
    private List<BankGroup> lsbankgroup;
    private Map<BankGroup, List<BankItems>> lsbankitem;
    private ExpandableBankAdapter expandableBankAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_bank_account_fragment, container, false);

        lvBank = view.findViewById(R.id.lvEditBankBank);
        lsbankitem = getListItems();
        lsbankgroup = new ArrayList<>(lsbankitem.keySet());

        expandableBankAdapter = new ExpandableBankAdapter(lsbankgroup,lsbankitem);
        lvBank.setAdapter(expandableBankAdapter);

        return view;
    }

    private Map<BankGroup, List<BankItems>> getListItems() {
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EditBankAccountViewModel.class);
        // TODO: Use the ViewModel
    }

}
