package k15hkii.se114.bookstore.utils;

import android.annotation.SuppressLint;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import k15hkii.se114.bookstore.BuildConfig;
import k15hkii.se114.bookstore.data.model.api.Payment;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.ui.components.ListAdapter;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

public final class BindingUtils {

    private BindingUtils() {
    }

    @BindingAdapter({"address"})
    public static void bindAddress(TextView view, UserAddress address) {
        if (address != null) {
            view.setText(String.format("{0}, {1}, {2}, {3}, {4}, (5), (6)",
                    address.getAddress(),
                    address.getStreet(),
                    address.getProject(),
                    address.getWard(),
                    address.getDistrict(),
                    address.getCity()));
        }
    }

    @BindingAdapter({"date"})
    public static void bindDate(TextView view, Date date) {
        DateFormat.getDateInstance().format(date);
    }

    @BindingAdapter({"payment"})
    public static void bindPayment(TextView view, Payment payment) {
        if (payment != null) {
            view.setText(payment.name()); //TODO: get full payment info
        }
    }

    @BindingAdapter({"image"})
    public static void bindImage(ImageView view, Image image) {
        if (image == null)
            return;

        bindImage(view, image.getId().toString());
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

    @BindingAdapter("price")
    public static void bindPrice(TextView view, long price) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        view.setText(formatter.format(price));
    }

    @BindingAdapter("price")
    public static void bindPrice(TextView view, double price) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        view.setText(formatter.format(price));
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("rating")
    public static void bindText(TextView view, double rating) {
        view.setText(String.format("%,.1f", rating));
    }

    //region Adapter
    @SuppressLint("NotifyDataSetChanged")
    @BindingAdapter({"source"})
    public static <VM> void bindViewModelSource(RecyclerView view, List<VM> source) {
        ListAdapter<VM, ?> adapter = (ListAdapter<VM, ?>) view.getAdapter();
        if (adapter == null || source == null)
            return;
        adapter.getSource().clear();
        adapter.getSource().addAll(source);
        adapter.notifyDataSetChanged();
    }
    //endregion

    @BindingAdapter("source")
    public static <T> void spinnerSource(Spinner spinner, List<SpinnerWrapper<T>> source) {
        if (source == null)
            return;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(spinner.getContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for (SpinnerWrapper<T> s : source) {
            adapter.add(s.getDisplay());
        }
        adapter.notifyDataSetChanged();
        spinner.setAdapter(adapter);
    }

    @BindingAdapter("testSource")
    public static void bindStringSource(Spinner spinner, List<String> source) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(spinner.getContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for (String s : source) {
            adapter.add(s);
        }
        adapter.notifyDataSetChanged();
        spinner.setAdapter(adapter);
    }

}
