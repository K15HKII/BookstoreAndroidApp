package k15hkii.se114.bookstore.ui.mainscreen.navigator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.BookViewAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BookViewAdapter extends ListAdapter<BookViewModel, BookViewAdapter.BookViewHolder> {

    private final Context context;
    @Getter
    @Setter
    private BookViewNavigator bookViewNavigator;

    /**
     * Deprecated constructor: use {@link #BookViewAdapter(Context)} with DI instead
     *
     * @param context
     * @param source
     */
    @Deprecated
    public BookViewAdapter(Context context, List<BookViewModel> source, BookViewNavigator bookViewNavigator) {
        super(source);
        this.context = context;
        this.bookViewNavigator = bookViewNavigator;
    }

    public BookViewAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    //Set View
    public BookViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_view_adapter, parent, false);
        return new BookViewHolder(view);
    }

    //set DATA
    @Override
    public void onBindViewHolder(@NonNull @NotNull BookViewHolder holder, BookViewModel data) {
        holder.itemView.setOnClickListener(d -> {
            getBookViewNavigator().Navigate(data);
        });
        holder.setViewModel(data);
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {

        private final BookViewAdapterBinding binding;

        public BookViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = BookViewAdapterBinding.bind(itemView);
        }

        public void setViewModel(BookViewModel data) {
            binding.setViewModel(data);
        }

    }

}
