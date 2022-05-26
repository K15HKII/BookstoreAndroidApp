package k15hkii.se114.bookstore.utils;

import android.annotation.SuppressLint;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.VoucherViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.VoucherViewAdapter;
import k15hkii.se114.bookstore.ui.address.Address;
import k15hkii.se114.bookstore.ui.address.RecycleViewAddressSelector.OtherAddressAdapter;
import k15hkii.se114.bookstore.ui.bankscreen.BankAccount;
import k15hkii.se114.bookstore.ui.bankscreen.RecycleViewBankSelector.OtherBankAdapter;
import k15hkii.se114.bookstore.ui.bookdetailscreen.Comment;
import k15hkii.se114.bookstore.ui.bookdetailscreen.CommentViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentBookItemViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentBookItemAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItem;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderView;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewAdapter;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartItemViewModel;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartItemAdapter;
import k15hkii.se114.bookstore.ui.orderinfoscreen.RecycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.RecycleViewOrderBooks.OrderBooksViewAdapter;
import k15hkii.se114.bookstore.ui.ratingbookscreen.RatingReport;
import k15hkii.se114.bookstore.ui.ratingbookscreen.RatingReportAdapter;
import k15hkii.se114.bookstore.ui.searchbook.RecentSearchViewModel;
import k15hkii.se114.bookstore.ui.searchbook.RecentSearchAdapter;

import java.util.List;

public final class BindingUtils {

    private BindingUtils() {
    }

    //Binding adapter recycleview
    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void bindSource(RecyclerView view, List<BookViewModel> source) {
        BookViewAdapter adapter = (BookViewAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void orderViewBindSource(RecyclerView view, List<OrderView> source) {
        OrderViewAdapter adapter = (OrderViewAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void orderBookViewBindSource(RecyclerView view, List<OrderBookViewModel> source) {
        OrderBooksViewAdapter adapter = (OrderBooksViewAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void voucherBindSource(RecyclerView view, List<VoucherViewModel> source) {
        VoucherViewAdapter adapter = (VoucherViewAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void addressBindSource(RecyclerView view, List<Address> source) {
        OtherAddressAdapter adapter = (OtherAddressAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void bankAccountBindSource(RecyclerView view, List<BankAccount> source) {
        OtherBankAdapter adapter = (OtherBankAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void commentBindSource(RecyclerView view, List<Comment> source) {
        CommentViewAdapter adapter = (CommentViewAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void rentViewBindSource(RecyclerView view, List<RentViewViewModel> source) {
        RentViewAdapter adapter = (RentViewAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void rentItemBindSource(RecyclerView view, List<RentBookItemViewModel> source) {
        RentBookItemAdapter adapter = (RentBookItemAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void orderItemBindSource(RecyclerView view, List<OrderItem> source) {
        OrderItemAdapter adapter = (OrderItemAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void onCartItemBindSource(RecyclerView view, List<OncartItemViewModel> source) {
        OncartItemAdapter adapter = (OncartItemAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void ratingReportBindSource(RecyclerView view, List<RatingReport> source) {
        RatingReportAdapter adapter = (RatingReportAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void searchBindSource(RecyclerView view, List<RecentSearchViewModel> source) {
        RecentSearchAdapter adapter = (RecentSearchAdapter) view.getAdapter();
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
