package k15hkii.se114.bookstore.utils;

import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.databinding.BindingAdapter;

import java.util.List;

public final class BindingUtils {

    private BindingUtils() {
    }

    @BindingAdapter("testsource")
    public static void bindSource(Spinner spinner, List<String> source) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(spinner.getContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for (String s : source) {
            adapter.add(s + " binded");
        }
        adapter.notifyDataSetChanged();
        spinner.setAdapter(adapter);
    }

}
