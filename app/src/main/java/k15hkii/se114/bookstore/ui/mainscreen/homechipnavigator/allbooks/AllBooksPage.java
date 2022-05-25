package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.allbooks;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.AllBooksViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewAdapter;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class AllBooksPage extends BaseFragment<AllBooksViewFragmentBinding, AllBooksViewViewModel> implements AllBooksPageNavigator {

    @Inject protected BookViewAdapter bookViewAdapter;

    public static AllBooksPage newInstance() {
        return new AllBooksPage();
    }

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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        allBooksViewFragmentBinding.lvHomeAllBook.setLayoutManager(gridLayoutManager);
        allBooksViewFragmentBinding.lvHomeAllBook.setAdapter(bookViewAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

}
