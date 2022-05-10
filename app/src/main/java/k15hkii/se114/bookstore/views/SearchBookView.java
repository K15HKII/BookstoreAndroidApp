package k15hkii.se114.bookstore.views;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.viewmodel.SearchBookViewViewModel;
import k15hkii.se114.bookstore.views.mainscreen.HomeScreen.HomeChipNavigation.BookView;
import k15hkii.se114.bookstore.views.mainscreen.HomeScreen.HomeChipNavigation.BookViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchBookView extends Fragment {

    private SearchBookViewViewModel mViewModel;

    private EditText sbSearchInput;
    private RecyclerView rcvRecentSearch;
    private RecentSearchAdapter recentSearchAdapter;

    public static SearchBookView newInstance() {
        return new SearchBookView();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_book_view_fragment, container, false);

        sbSearchInput = view.findViewById(R.id.sbSearchViewInput);
        sbSearchInput.requestFocus();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        String[] names = {"Sách Đắc Nhân Tâm","Sách Công Nghệ","Danh Nghiệp","Giải tích AKA Giải thích"};

        List<RecentSearch> arrayName = new ArrayList<RecentSearch>();
        for(int i=0;i<names.length;i++){
            arrayName.add(new RecentSearch(names[i]));
        }

        rcvRecentSearch = view.findViewById(R.id.rcvSearchViewTitle);
        recentSearchAdapter = new RecentSearchAdapter(arrayName);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rcvRecentSearch.setLayoutManager(linearLayoutManager);

        rcvRecentSearch .setAdapter(recentSearchAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SearchBookViewViewModel.class);
        // TODO: Use the ViewModel
    }

}
