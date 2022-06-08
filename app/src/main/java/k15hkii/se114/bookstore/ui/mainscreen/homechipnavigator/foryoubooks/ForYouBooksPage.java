package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.foryoubooks;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.ForYouBooksFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.bookdetailscreen.BookDetailPage;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewNavigator;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class ForYouBooksPage extends BaseFragment<ForYouBooksFragmentBinding, ForYouBooksViewModel> implements ForYouBooksNavigator, BookViewNavigator {
    @Inject
    protected BookViewAdapter bookViewAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.for_you_books_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ForYouBooksFragmentBinding forYouBooksFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        bookViewAdapter.setBookViewNavigator(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        forYouBooksFragmentBinding.lvHomeForYouBooks.setLayoutManager(gridLayoutManager);
        forYouBooksFragmentBinding.lvHomeForYouBooks.setAdapter(bookViewAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void Navigate(BookViewModel vm) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("book",vm.getBook());
        createTransaction(R.id.fragmentContainerView, BookDetailPage.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }
}
