package k15hkii.se114.bookstore.views.bankscreen.add;

import android.widget.AdapterView;
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

public class AddBankPage extends BaseFragment<AddBankAccountFragmentBinding, AddBankPageViewModel> implements AdapterView.OnItemSelectedListener,AddBankPageNavigator {

    private AddBankAccountFragmentBinding addBankAccountFragmentBinding;

    public static AddBankPage newInstance() {
        return new AddBankPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
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
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
