package k15hkii.se114.bookstore.utils;

import android.annotation.SuppressLint;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.views.mainscreen.HomeScreen.homechipnavigation.BookView;
import k15hkii.se114.bookstore.views.mainscreen.HomeScreen.homechipnavigation.BookViewAdapter;

import java.util.List;

public final class BindingUtils {

    private BindingUtils() {
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void bindSource(RecyclerView view, List<BookView> source) {
        BookViewAdapter adapter = (BookViewAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @BindingAdapter("testSource")
    public static void bindSource(Spinner spinner, List<String> source) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(spinner.getContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for (String s : source) {
            adapter.add(s + "");
        }
        adapter.notifyDataSetChanged();
        spinner.setAdapter(adapter);
    }

}
