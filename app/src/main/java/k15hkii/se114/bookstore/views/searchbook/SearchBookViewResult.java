package k15hkii.se114.bookstore.views.searchbook;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.SearchBookViewResultFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import k15hkii.se114.bookstore.views.mainscreen.HomeScreen.homechipnavigation.BookView;
import k15hkii.se114.bookstore.views.mainscreen.HomeScreen.homechipnavigation.BookViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchBookViewResult extends BaseFragment<SearchBookViewResultFragmentBinding, SearchBookViewResultViewModel> implements SearchBookViewResultNavigator {

    private SearchBookViewResultFragmentBinding searchBookViewResultFragmentBinding;
    private SearchBookViewResultViewModel mViewModel;
    private RecyclerView rcvListBooks;
    private BookViewAdapter bookViewAdapter;

    public static SearchBookViewResult newInstance() {
        return new SearchBookViewResult();
    }

    @Override
    public int getBindingVariable() {
        return BR.SearchBookViewResultViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.search_book_view_result_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        searchBookViewResultFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        String[] names = {"Sách Đắc Nhân Tâm","Sách Công Nghệ","Danh Nghiệp","Giải tích AKA Giải thích"};

        List<BookView> arrayName = new ArrayList<BookView>();
        for(int i=0;i<names.length;i++){
            arrayName.add(new BookView(names[i]));
        }

        rcvListBooks = view.findViewById(R.id.rcvSearchResultBookView);
        bookViewAdapter = new BookViewAdapter(getActivity(),arrayName);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        rcvListBooks.setLayoutManager(gridLayoutManager);

        rcvListBooks.setAdapter(bookViewAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SearchBookViewResultViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
