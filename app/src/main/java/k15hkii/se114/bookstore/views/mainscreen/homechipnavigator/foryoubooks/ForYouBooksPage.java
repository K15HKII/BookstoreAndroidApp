package k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.foryoubooks;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.ForYouBooksFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.BookView;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.BookViewAdapter;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ForYouBooksPage extends BaseFragment<ForYouBooksFragmentBinding, ForYouBooksViewModel> implements ForYouBooksNavigator {
    @Inject
    protected BookViewAdapter bookViewAdapter;

    public static ForYouBooksPage newInstance() {
        return new ForYouBooksPage();
    }

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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        forYouBooksFragmentBinding.lvHomeForYouBooks.setLayoutManager(gridLayoutManager);
        forYouBooksFragmentBinding.lvHomeForYouBooks.setAdapter(bookViewAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

}
