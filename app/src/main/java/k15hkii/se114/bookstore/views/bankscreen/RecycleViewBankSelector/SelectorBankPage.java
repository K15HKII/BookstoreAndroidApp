package k15hkii.se114.bookstore.views.bankscreen.RecycleViewBankSelector;

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
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.views.bankscreen.BankChoiceViewModel;
import k15hkii.se114.bookstore.views.bankscreen.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class SelectorBankPage extends Fragment {

    private BankChoiceViewModel mViewModel;
    private OtherBankAdapter otherBankAdapter;
    private RecyclerView rcvOtherBankAccount;

    public static SelectorBankPage newInstance() {
        return new SelectorBankPage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.selector_bank_fragment, container, false);

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BankChoiceViewModel.class);
        // TODO: Use the ViewModel
    }

}
