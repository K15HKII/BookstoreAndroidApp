package k15hkii.se114.bookstore.utils;

import android.annotation.SuppressLint;
import android.media.Rating;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.views.accountscreen.voucherscreen.Voucher;
import k15hkii.se114.bookstore.views.accountscreen.voucherscreen.VoucherViewAdapter;
import k15hkii.se114.bookstore.views.address.Address;
import k15hkii.se114.bookstore.views.address.RecycleViewAddressSelector.OtherAddressAdapter;
import k15hkii.se114.bookstore.views.bankscreen.BankAccount;
import k15hkii.se114.bookstore.views.bankscreen.RecycleViewBankSelector.OtherBankAdapter;
import k15hkii.se114.bookstore.views.bookdetailscreen.Comment;
import k15hkii.se114.bookstore.views.bookdetailscreen.CommentViewAdapter;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.BookView;
import k15hkii.se114.bookstore.views.mainscreen.homechipnavigator.BookViewAdapter;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.rentbooksrecycleview.RentBookItem;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.rentbooksrecycleview.RentBookItemAdapter;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.rentbooksrecycleview.RentView;
import k15hkii.se114.bookstore.views.mainscreen.rentscreen.rentbooksrecycleview.RentViewAdapter;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderItem;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderItemAdapter;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderView;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderViewAdapter;
import k15hkii.se114.bookstore.views.oncartscreen.OncartItem;
import k15hkii.se114.bookstore.views.oncartscreen.OncartItemAdapter;
import k15hkii.se114.bookstore.views.orderinfoscreen.RecycleViewOrderBooks.OrderBookView;
import k15hkii.se114.bookstore.views.orderinfoscreen.RecycleViewOrderBooks.OrderBooksViewAdapter;
import k15hkii.se114.bookstore.views.ratingbookscreen.RatingReport;
import k15hkii.se114.bookstore.views.ratingbookscreen.RatingReportAdapter;
import k15hkii.se114.bookstore.views.searchbook.RecentSearch;
import k15hkii.se114.bookstore.views.searchbook.RecentSearchAdapter;

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
    public static void orderBookViewBindSource(RecyclerView view, List<OrderBookView> source) {
        OrderBooksViewAdapter adapter = (OrderBooksViewAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void voucherBindSource(RecyclerView view, List<Voucher> source) {
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
    public static void rentViewBindSource(RecyclerView view, List<RentView> source) {
        RentViewAdapter adapter = (RentViewAdapter) view.getAdapter();
        if (adapter == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void rentItemBindSource(RecyclerView view, List<RentBookItem> source) {
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
    public static void onCartItemBindSource(RecyclerView view, List<OncartItem> source) {
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
    public static void searchBindSource(RecyclerView view, List<RecentSearch> source) {
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
