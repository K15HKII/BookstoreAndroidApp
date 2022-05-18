package k15hkii.se114.bookstore.views.accountscreen.helppage.delaccountrequest;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.DeleteAccountFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;

public class DeleteAccount extends BaseFragment<DeleteAccountFragmentBinding, DeleteAccountViewModel> implements DeleteAccountNavigator {

    private DeleteAccountFragmentBinding deleteAccountFragmentBinding;
    private DeleteAccountViewModel mViewModel;

    public static DeleteAccount newInstance() {
        return new DeleteAccount();
    }

    @Override
    public int getBindingVariable() {
        return BR.DeleteAccountViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.delete_account_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        deleteAccountFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DeleteAccountViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
