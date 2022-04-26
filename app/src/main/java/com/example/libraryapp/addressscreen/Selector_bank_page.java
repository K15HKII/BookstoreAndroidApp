package com.example.libraryapp.addressscreen;

import android.widget.ListView;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.libraryapp.bankscreen.OtherBankAdapter;
import com.example.libraryapp.R;
import com.example.libraryapp.viewmodel.BankChoiceViewModel;

import java.util.ArrayList;

public class Selector_bank_page extends Fragment {

    private BankChoiceViewModel mViewModel;
    private OtherBankAdapter otherBankAdapter;
    private ListView lvOtherBankAccount;

    public static Selector_bank_page newInstance() {
        return new Selector_bank_page();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.selector_bank_fragment, container, false);

        lvOtherBankAccount = view.findViewById(R.id.lvBankChoiceOtherBank);
        ArrayList<String> lsOtherBank = new ArrayList<>();
        lsOtherBank.add("TechComBank");
        lsOtherBank.add("MBBank");

        otherBankAdapter = new OtherBankAdapter(lsOtherBank,getActivity());
        lvOtherBankAccount.setAdapter(otherBankAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BankChoiceViewModel.class);
        // TODO: Use the ViewModel
    }

}
