package k15hkii.se114.bookstore.ui.account.help.delete;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.DeleteAccountFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.auth.loginscreen.Login;
import k15hkii.se114.bookstore.ui.base.BaseFragment;

public class DeleteAccount extends BaseFragment<DeleteAccountFragmentBinding, DeleteAccountViewModel> implements DeleteAccountNavigator {

    private DeleteAccountFragmentBinding deleteAccountFragmentBinding;

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
    public void BackWard() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void OpenLoginNavigator() {
        createTransaction(R.id.fragmentContainerView, Login.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

}
