package k15hkii.se114.bookstore.ui.intro.thirdpage;

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
import k15hkii.se114.bookstore.databinding.IntroThirdPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.intro.fourthpage.IntroFourthPage;

public class IntroThirdPage extends BaseFragment<IntroThirdPageFragmentBinding, IntroThirdPageViewModel> implements IntroThirdPageNavigator {

    private IntroThirdPageFragmentBinding introThirdPageFragmentBinding;
    private IntroThirdPageViewModel mViewModel;

    public static IntroThirdPage newInstance() {
        return new IntroThirdPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.IntroThirdPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.intro_third_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        introThirdPageFragmentBinding = getViewDataBinding();
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
        mViewModel = new ViewModelProvider(this).get(IntroThirdPageViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void openFinalPage() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, IntroFourthPage.class, null).addToBackStack(null).commit();
    }
}
