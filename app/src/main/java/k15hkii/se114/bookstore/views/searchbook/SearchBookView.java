package k15hkii.se114.bookstore.views.searchbook;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.SearchBookViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class SearchBookView extends BaseFragment<SearchBookViewFragmentBinding, SearchBookViewViewModel> implements SearchBookViewNavigator {

    private SearchBookViewFragmentBinding searchBookViewFragmentBinding;
    private SearchBookViewViewModel mViewModel;

    private EditText sbSearchInput;
    private RecyclerView rcvRecentSearch;
    private RecentSearchAdapter recentSearchAdapter;
    private List<RecentSearch> arrayName;

    public static SearchBookView newInstance() {
        return new SearchBookView();
    }

    @Override
    public int getBindingVariable() {
        return BR.SearchBookViewViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.search_book_view_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        searchBookViewFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        sbSearchInput = view.findViewById(R.id.sbSearchViewInput);
        sbSearchInput.requestFocus();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        String[] names = {"Sách Đắc Nhân Tâm","Sách Công Nghệ","Danh Nghiệp","Giải tích AKA Giải thích"};

        arrayName = new ArrayList<RecentSearch>();
        for(int i=0;i<names.length;i++){
            arrayName.add(new RecentSearch(names[i]));
        }

        rcvRecentSearch = view.findViewById(R.id.rcvSearchViewTitle);
        recentSearchAdapter = new RecentSearchAdapter(arrayName);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rcvRecentSearch.setLayoutManager(linearLayoutManager);
        rcvRecentSearch .setAdapter(recentSearchAdapter);

        sbSearchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    private void filter(String inputTxt){
        ArrayList<RecentSearch> filteredLs = new ArrayList<>();
        for(RecentSearch item : arrayName){
            if(item.getTitle().toLowerCase().contains(inputTxt.toLowerCase())) {
                filteredLs.add(item);
            }
        }
        recentSearchAdapter.filterlist(filteredLs);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SearchBookViewViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
        closekeyboard();
    }

    @Override
    public void openSearchViewResult() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, SearchBookViewResult.class, null).addToBackStack(null).commit();
        closekeyboard();
    }

    private void closekeyboard() {
        View view = getActivity().getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}
