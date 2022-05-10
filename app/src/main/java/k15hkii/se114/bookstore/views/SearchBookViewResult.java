package k15hkii.se114.bookstore.views;

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
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.viewmodel.SearchBookViewResultViewModel;
import k15hkii.se114.bookstore.views.mainscreen.HomeScreen.HomeChipNavigation.BookView;
import k15hkii.se114.bookstore.views.mainscreen.HomeScreen.HomeChipNavigation.BookViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchBookViewResult extends Fragment {

    private SearchBookViewResultViewModel mViewModel;
    private RecyclerView rcvListBooks;
    private BookViewAdapter bookViewAdapter;

    public static SearchBookViewResult newInstance() {
        return new SearchBookViewResult();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_book_view_result_fragment, container, false);

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SearchBookViewResultViewModel.class);
        // TODO: Use the ViewModel
    }

}
