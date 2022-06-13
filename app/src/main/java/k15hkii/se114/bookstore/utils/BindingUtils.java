package k15hkii.se114.bookstore.utils;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.*;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import de.hdodenhof.circleimageview.CircleImageView;
import k15hkii.se114.bookstore.BuildConfig;
import k15hkii.se114.bookstore.data.model.ISubEnum;
import k15hkii.se114.bookstore.data.model.api.Payment;
import k15hkii.se114.bookstore.data.model.api.book.BookTag;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.model.api.user.Gender;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.ui.components.ListAdapter;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

public final class BindingUtils {

    private BindingUtils() {
    }

    @BindingAdapter({"tags"})
    public static void bindTags(TextView view, List<BookTag> tags) {
        if (tags == null) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (BookTag tag : tags) {
            builder.append(tag.toDefaultLocale());
            builder.append(", ");
        }
        if (builder.length() > 0) {
            builder.delete(builder.length() - 2, builder.length());
        }
        view.setText(builder.toString());
    }

    @BindingAdapter({"gender"})
    public static void bindGender(TextView view, Gender gender) {
        if (gender != null) {
            view.setText(gender.toDefaultLocale());
        }
    }

    @BindingAdapter({"sub"})
    public static void bindSub(TextView view, ISubEnum sub) {
        if (sub != null) {
            view.setText(sub.toDefaultLocale());
        }
    }

    @BindingAdapter({"loading"})
    public static void bindLoading(ProgressBar progressBar, boolean isLoading) {
        if (isLoading) progressBar.setVisibility(View.VISIBLE);
        else progressBar.setVisibility(View.GONE);
    }

    @BindingAdapter({"loading"})
    public static void bindLoading(FrameLayout layout, boolean isLoading) {
        if (isLoading) layout.setVisibility(View.VISIBLE);
        else layout.setVisibility(View.GONE);
    }

    @BindingAdapter({"loading"})
    public static void bindLoading(CircularProgressIndicator progressBar, boolean isLoading) {
        if (isLoading) progressBar.setVisibility(View.VISIBLE);
        else progressBar.setVisibility(View.GONE);
    }

    @BindingAdapter({"address"})
    public static void bindAddress(TextView view, UserAddress address) {
        if (address != null) {
            view.setText(String.format("%s, %s, %s, %s, %s, %s",
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
        if (date == null)
            return;
        view.setText(DateFormat.getDateInstance().format(date));
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
    public static void bindImage(CircleImageView view, Image image) {
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
                .fitCenter()
                .into(view);
    }

    @BindingAdapter("price")
    public static void bindPrice(TextView view, long price) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        view.setText(formatter.format(price) + "đ");
    }

    @BindingAdapter("price")
    public static void bindPrice(TextView view, double price) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        view.setText(formatter.format(price) + "đ");
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("rating")
    public static void bindText(TextView view, double rating) {
        view.setText(String.format("%,.1f", rating));
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("rating")
    public static void bindText(TextView view, float rating) {
        view.setText(String.format("%,.1f", rating));
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("rating_full")
    public static void ratingFull(TextView view, double rating) {
        view.setText(String.format("%,.1f/5", rating));
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("rating_full")
    public static void ratingFull(TextView view, float rating) {
        view.setText(String.format("%,.1f/5", rating));
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

    @BindingAdapter("source")
    public static void spinnerSourceString(Spinner spinner, List<String> source) {
        if (source == null)
            return;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(spinner.getContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for (String s : source) {
            adapter.add(s);
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
