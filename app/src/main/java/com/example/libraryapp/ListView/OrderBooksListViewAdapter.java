package com.example.libraryapp.ListView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.libraryapp.R;

public class OrderBooksListViewAdapter extends BaseAdapter {
    private String[] BookName;
    private Activity activity;

    public OrderBooksListViewAdapter(String[] bookName, Activity activity) {
        BookName = bookName;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return BookName.length;
    }

    @Override
    public Object getItem(int i) {
        return BookName[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.orderpage_list_books,null);
        TextView tvBookName = view.findViewById(R.id.tvListBooksNameOfBook);
        tvBookName.setText(BookName[i]);
        return view;
    }
}
