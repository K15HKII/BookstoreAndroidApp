package k15hkii.se114.bookstore.utils;

import android.annotation.SuppressLint;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import k15hkii.se114.bookstore.BuildConfig;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.VoucherViewModel;
import k15hkii.se114.bookstore.ui.accountscreen.voucherscreen.VoucherViewAdapter;
import k15hkii.se114.bookstore.ui.address.recycleViewAddressSelector.OtherAddressAdapter;
import k15hkii.se114.bookstore.ui.address.recycleViewAddressSelector.OtherAddressViewModel;
import k15hkii.se114.bookstore.ui.bankscreen.recycleViewBankSelector.OtherBankAdapter;
import k15hkii.se114.bookstore.ui.bankscreen.recycleViewBankSelector.OtherBankViewModel;
import k15hkii.se114.bookstore.ui.bookdetailscreen.Comment;
import k15hkii.se114.bookstore.ui.bookdetailscreen.CommentViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview.RentViewAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderViewAdapter;
import k15hkii.se114.bookstore.ui.notificationnews.ListDataNotificationViewModel;
import k15hkii.se114.bookstore.ui.notificationnews.ListDataNotificationAdapter;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartItemViewModel;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartItemAdapter;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBooksViewAdapter;
import k15hkii.se114.bookstore.ui.searchbook.RecentSearchViewModel;
import k15hkii.se114.bookstore.ui.searchbook.RecentSearchAdapter;

import java.util.List;

public final class BindingUtils {

    private BindingUtils() {
    }

    @BindingAdapter({"image"})
    public static void bindImage(ImageView view, Image image) {
        if (image == null)
            return;

        final String url = BuildConfig.BASE_URL + "images/" + image.getId().toString() + ".png";

        Glide.with(view)
                .load(url)
                .into(view);
    }

    @BindingAdapter({"image"})
    public static void bindImage(ImageView view, String image) {
        if (image == null)
            return;

        final String url = BuildConfig.BASE_URL + "images/" + image + ".png";

        Glide.with(view)
                .load(url)
                .into(view);
    }

    //region Binding adapter recycleview
    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void bindSource(RecyclerView view, List<BookViewModel> source) {
        BookViewAdapter adapter = (BookViewAdapter) view.getAdapter();
        if (adapter == null || source == null)
            return;
        adapter.getSource().clear();

        if (source == null) {
            return;
        }
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void orderViewBindSource(RecyclerView view, List<OrderViewViewModel> source) {
        OrderViewAdapter adapter = (OrderViewAdapter) view.getAdapter();
        if (adapter == null || source == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void orderBookViewBindSource(RecyclerView view, List<OrderBookViewModel> source) {
        OrderBooksViewAdapter adapter = (OrderBooksViewAdapter) view.getAdapter();
        if (adapter == null || source == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void voucherBindSource(RecyclerView view, List<VoucherViewModel> source) {
        VoucherViewAdapter adapter = (VoucherViewAdapter) view.getAdapter();
        if (adapter == null || source == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void addressBindSource(RecyclerView view, List<OtherAddressViewModel> source) {
        OtherAddressAdapter adapter = (OtherAddressAdapter) view.getAdapter();
        if (adapter == null || source == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void bankAccountBindSource(RecyclerView view, List<OtherBankViewModel> source) {
        OtherBankAdapter adapter = (OtherBankAdapter) view.getAdapter();
        if (adapter == null || source == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void commentBindSource(RecyclerView view, List<Comment> source) {
        CommentViewAdapter adapter = (CommentViewAdapter) view.getAdapter();
        if (adapter == null || source == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void rentViewBindSource(RecyclerView view, List<RentViewViewModel> source) {
        RentViewAdapter adapter = (RentViewAdapter) view.getAdapter();
        if (adapter == null || source == null)
            return;

        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

//    @SuppressLint("NotifyDataSetChanged")
//    @BindingAdapter({"source"})
//    public static void rentItemBindSource(RecyclerView view, List<RentBookItemViewModel> source) {
//        RentBookItemAdapter adapter = (RentBookItemAdapter) view.getAdapter();
//        if (adapter == null || source == null)
//            return;
//        adapter.getSource().clear();
//        adapter.getSource().addAll(source);
//        adapter.notifyDataSetChanged();
//    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void orderItemBindSource(RecyclerView view, List<OrderItemViewModel> source) {
        OrderItemAdapter adapter = (OrderItemAdapter) view.getAdapter();
        if (adapter == null || source == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void onCartItemBindSource(RecyclerView view, List<OncartItemViewModel> source) {
        OncartItemAdapter adapter = (OncartItemAdapter) view.getAdapter();
        if (adapter == null || source == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

//    @SuppressLint("NotifyDataSetChanged")
//    @BindingAdapter({"source"})
//    public static void ratingReportBindSource(RecyclerView view, List<RatingReportViewModel> source) {
//        RatingReportAdapter adapter = (RatingReportAdapter) view.getAdapter();
//        if (adapter == null || source == null)
//            return;
//        adapter.getSource().clear();
//        adapter.getSource().addAll(source);
//        adapter.notifyDataSetChanged();
//    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void searchBindSource(RecyclerView view, List<RecentSearchViewModel> source) {
        RecentSearchAdapter adapter = (RecentSearchAdapter) view.getAdapter();
        if (adapter == null || source == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static void listDataNotificationBindSource(RecyclerView view, List<ListDataNotificationViewModel> source) {
        ListDataNotificationAdapter adapter = (ListDataNotificationAdapter) view.getAdapter();
        if (adapter == null || source == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }

    //endregion Binding Adapter spinner
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
