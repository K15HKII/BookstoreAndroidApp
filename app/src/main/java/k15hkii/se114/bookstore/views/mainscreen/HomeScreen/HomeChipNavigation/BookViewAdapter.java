package k15hkii.se114.bookstore.views.mainscreen.HomeScreen.HomeChipNavigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.views.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BookViewAdapter extends ListAdapter<BookView, BookViewAdapter.BookViewHolder> {
    private Context context;

    BookViewAdapter(List<BookView> lsBookView) {
        super(lsBookView);
    }

    public BookViewAdapter(Context context, List<BookView> lsBookView) {
        super(lsBookView);
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    //Set View
    public BookViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_view_adapter,parent,false);
        return new BookViewHolder(view);
    }

    //set DATA
    @Override
    public void onBindViewHolder(@NonNull @NotNull BookViewHolder holder, BookView data) {
        if(data == null){
            return;
        }
        holder.tvBookName.setText(data.getName());
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{

        private TextView tvBookName;

        public BookViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvBookName = itemView.findViewById(R.id.tvBookViewBookName);
        }
    }
}
