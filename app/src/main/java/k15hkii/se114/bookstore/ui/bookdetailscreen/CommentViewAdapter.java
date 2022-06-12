package k15hkii.se114.bookstore.ui.bookdetailscreen;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.data.model.api.message.Feedback;
import k15hkii.se114.bookstore.databinding.BookViewAdapterBinding;
import k15hkii.se114.bookstore.databinding.CommentAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommentViewAdapter extends ListAdapter<FeedbackViewModel, CommentViewAdapter.CommentViewHolder> {

    private final Context context;

    public CommentViewAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_adapter, parent, false);
        return new CommentViewAdapter.CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CommentViewHolder holder, FeedbackViewModel data) {
        if (data == null) {
            return;
        }
        holder.setViewModel(data);
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {

        private CommentAdapterBinding binding;

        public CommentViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = CommentAdapterBinding.bind(itemView);
        }

        public void setViewModel(FeedbackViewModel data) {
            binding.setViewModel(data);
        }

    }

}
