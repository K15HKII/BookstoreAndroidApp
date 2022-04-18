package com.example.libraryapp.MainScreen.page;

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
import com.example.libraryapp.MainScreen.HomeScreen.HomeChipNavigation.BookView;
import com.example.libraryapp.MainScreen.HomeScreen.HomeChipNavigation.BookViewAdapter;
import com.example.libraryapp.R;
import com.example.libraryapp.ViewModel.LoveViewViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoritePage extends Fragment {

    private LoveViewViewModel mViewModel;
    private RecyclerView rcvListRecentlyBooks;
    private BookViewAdapter bookViewRecentlyAdapter;
    private RecyclerView rcvListAllBooks;
    private BookViewAdapter bookViewAllAdapter;

    public static FavoritePage newInstance() {
        return new FavoritePage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorite_page_fragment, container, false);

        String[] names = {"Sách Đắc Nhân Tâm","Sách Công Nghệ","Danh Nghiệp","Giải tích AKA Giải thích"};

        List<BookView> arrayName = new ArrayList<BookView>();
        for(int i=0;i<names.length;i++){
            arrayName.add(new BookView(names[i]));
        }

        rcvListRecentlyBooks = view.findViewById(R.id.lvLoveRecentlyBook);
        bookViewRecentlyAdapter = new BookViewAdapter(getActivity(),arrayName);

        rcvListAllBooks = view.findViewById(R.id.lvLoveAllBook);
        bookViewAllAdapter = new BookViewAdapter(getActivity(),arrayName);

        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getActivity(),2);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity(),2);
        rcvListRecentlyBooks.setLayoutManager(gridLayoutManager1);
        rcvListAllBooks.setLayoutManager(gridLayoutManager2);

        rcvListRecentlyBooks.setAdapter(bookViewRecentlyAdapter);
        rcvListAllBooks.setAdapter(bookViewAllAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoveViewViewModel.class);
        // TODO: Use the ViewModel
    }

}
