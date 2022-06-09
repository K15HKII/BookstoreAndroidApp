package k15hkii.se114.bookstore.ui.mainscreen.page.homepage;

import android.view.*;
import android.widget.Button;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import k15hkii.se114.bookstore.*;
import k15hkii.se114.bookstore.databinding.HomePageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.address.SelectorAddressPage;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.dialog.filtersearch.FilterSearchDialog;
import k15hkii.se114.bookstore.ui.searchbook.SearchBookView;
import com.google.android.material.chip.Chip;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.allbooks.AllBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.familiarbooks.FamiliarBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.foryoubooks.ForYouBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.popularbooks.PopularBooksPage;
import k15hkii.se114.bookstore.ui.notificationnews.NotificationPage;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartViewPage;

public class HomePage extends BaseFragment<HomePageFragmentBinding,HomePageViewModel> implements HomePageNavigator {

    private HomePageFragmentBinding homePageFragmentBinding;

    @Override
    public int getBindingVariable() {
        return BR.HomePageViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_page_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        homePageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(HomePage.this);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void openSearchView() {
        createTransaction(R.id.fragmentContainerView, SearchBookView.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openNotificationView() {
        createTransaction(R.id.fragmentContainerView, NotificationPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openOnCartView() {
        createTransaction(R.id.fragmentContainerView, OncartViewPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openFilterDialog() {
        FilterSearchDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openAllBooksView() {
        createTransaction(R.id.fragmentContainerHomeView, AllBooksPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openPoppularBooksView() {
        createTransaction(R.id.fragmentContainerHomeView, PopularBooksPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openFamiliarBooksView() {
        createTransaction(R.id.fragmentContainerHomeView, FamiliarBooksPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openForYouBooksView() {
        createTransaction(R.id.fragmentContainerHomeView, ForYouBooksPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }
}
