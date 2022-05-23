package k15hkii.se114.bookstore.views.intro.firstpage;

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
import k15hkii.se114.bookstore.databinding.IntroFirstPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.intro.secondpage.IntroSecondPage;

public class IntroFirstPage extends BaseFragment<IntroFirstPageFragmentBinding, IntroFirstPageViewModel> implements IntroFirstPageNavigator {

    private IntroFirstPageFragmentBinding introFirstPageFragmentBinding;
    private IntroFirstPageViewModel mViewModel;

    public static IntroFirstPage newInstance() {
        return new IntroFirstPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.IntroFirstPageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.intro_first_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        introFirstPageFragmentBinding = getViewDataBinding();
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
        mViewModel = new ViewModelProvider(this).get(IntroFirstPageViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void openNextPage() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.fragmentContainerView, IntroSecondPage.class, null).addToBackStack(null).commit();
    }
}
