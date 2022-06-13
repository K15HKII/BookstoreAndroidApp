package k15hkii.se114.bookstore.ui.mainscreen.navigator.all;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.AllBooksViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.book.detail.BookDetailPage;
import k15hkii.se114.bookstore.ui.dialog.errordata.ErrorDataDialog;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.BookViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.BookViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.BookViewNavigator;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.popular.BannerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class AllBooksPage extends BaseFragment<AllBooksViewFragmentBinding, AllBooksViewViewModel> implements AllBooksPageNavigator, BookViewNavigator {

    @Inject
    protected BookViewAdapter bookViewAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.all_books_view_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        AllBooksViewFragmentBinding allBooksViewFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        bookViewAdapter.setBookViewNavigator(this);

        BannerAdapter bannerAdapter = new BannerAdapter(this.getContext());

        getViewDataBinding().vpPopularBooks.setAdapter(bannerAdapter);
        getViewDataBinding().ciPopularBooks.setViewPager(getViewDataBinding().vpPopularBooks);
        bannerAdapter.registerAdapterDataObserver(getViewDataBinding().ciPopularBooks.getAdapterDataObserver());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        allBooksViewFragmentBinding.lvHomeAllBook.setLayoutManager(gridLayoutManager);
        allBooksViewFragmentBinding.lvHomeAllBook.setAdapter(bookViewAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void Navigate(BookViewModel vm) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("book", vm.getBook());
        createTransaction(R.id.fragmentContainerView, BookDetailPage.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openErrorDataDialog() {
        ErrorDataDialog dialog = new ErrorDataDialog();
        dialog.show(getActivity().getSupportFragmentManager());
    }

}
