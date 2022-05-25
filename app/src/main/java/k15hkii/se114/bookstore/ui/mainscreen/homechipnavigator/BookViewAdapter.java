package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BookViewAdapter extends ListAdapter<BookViewModel, BookViewAdapter.BookViewHolder> {
    private Context context;

    /**
     * Deprecated constructor: use {@link #BookViewAdapter(Context)} with DI instead
     *
     * @param context
     * @param source
     */
    @Deprecated
    public BookViewAdapter(Context context, List<BookViewModel> source) {
        super(source);
        this.context = context;
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
        if (data == null) {
            return;
        }
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        private TextView tvBookName;

        public BookViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvBookName = itemView.findViewById(R.id.tvBookViewBookName);
        }

    }
}
