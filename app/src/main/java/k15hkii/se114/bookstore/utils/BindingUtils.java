package k15hkii.se114.bookstore.utils;

import android.annotation.SuppressLint;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.BookView;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.BookViewAdapter;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderView;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderViewAdapter;
import k15hkii.se114.bookstore.views.orderinfoscreen.RecycleViewOrderBooks.OrderBookView;
import k15hkii.se114.bookstore.views.orderinfoscreen.RecycleViewOrderBooks.OrderBooksViewAdapter;
import kotlin.jvm.JvmOverloads;

import java.util.List;

public final class BindingUtils {

    private BindingUtils() {
    }

    //Binding adapter recycleview
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
    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void bindSource1(RecyclerView view, List<OrderView> source) {
        OrderViewAdapter adapter = (OrderViewAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    //Binding Adapter spinner
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
