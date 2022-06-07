package k15hkii.se114.bookstore.ui.intro.fourthpage;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.IntroFourthPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.loginscreen.Login;

public class IntroFourthPage extends BaseFragment<IntroFourthPageFragmentBinding, IntroFourthPageViewModel> implements IntroFourthPageNavigator {

    private IntroFourthPageFragmentBinding introFourthPageFragmentBinding;

    @Override
    public int getBindingVariable() {
        return BR.IntroFourthPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.intro_fourth_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        introFourthPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void openLogin() {
        createTransaction(R.id.fragmentContainerView, Login.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }
}
