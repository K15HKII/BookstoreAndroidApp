package k15hkii.se114.bookstore.ui.searchbook;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.SearchBookViewResultFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewAdapter;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class SearchBookViewResult extends BaseFragment<SearchBookViewResultFragmentBinding, SearchBookViewResultViewModel> implements SearchBookViewResultNavigator {

    @Inject
    protected BookViewAdapter bookViewAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.search_book_view_result_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        SearchBookViewResultFragmentBinding searchBookViewResultFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        String[] names = {"Sách Đắc Nhân Tâm","Sách Công Nghệ","Danh Nghiệp","Giải tích AKA Giải thích"};

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        searchBookViewResultFragmentBinding.rcvSearchResultBookView.setLayoutManager(gridLayoutManager);
        searchBookViewResultFragmentBinding.rcvSearchResultBookView.setAdapter(bookViewAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }


    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }
}
