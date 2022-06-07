package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.popularbooks;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.PopularBooksFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.bookdetailscreen.BookDetailPage;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewNavigator;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class PopularBooksPage extends BaseFragment<PopularBooksFragmentBinding, PopularBooksViewModel> implements PopularBooksPageNavigator, BookViewNavigator {
    @Inject
    protected BookViewAdapter bookViewAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }
    @Override
    public int getLayoutId() {
        return R.layout.popular_books_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        PopularBooksFragmentBinding popularBooksFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        bookViewAdapter.setBookViewNavigator(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        popularBooksFragmentBinding.lvHomePopularBook.setLayoutManager(gridLayoutManager);
        popularBooksFragmentBinding.lvHomePopularBook.setAdapter(bookViewAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void Navigate(BookViewModel vm) {
        createTransaction(R.id.fragmentContainerView, BookDetailPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }
}
