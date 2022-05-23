package k15hkii.se114.bookstore.views.intro.fourthpage;

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
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.IntroFourthPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.viewmodel.base.BaseViewModel;
import k15hkii.se114.bookstore.views.intro.secondpage.IntroSecondPage;
import k15hkii.se114.bookstore.views.loginscreen.Login;

public class IntroFourthPage extends BaseFragment<IntroFourthPageFragmentBinding, IntroFourthPageViewModel> implements IntroFourthPageNavigator {

    private IntroFourthPageFragmentBinding introFourthPageFragmentBinding;
    private IntroFourthPageViewModel mViewModel;


    public static IntroFourthPage newInstance() {
        return new IntroFourthPage();
    }

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(IntroFourthPageViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void openLogin() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, Login.class, null).addToBackStack(null).commit();
    }
}
