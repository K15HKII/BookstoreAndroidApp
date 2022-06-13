package k15hkii.se114.bookstore.ui.book.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.CommentAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

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

        CommentViewHolder holder = new CommentViewAdapter.CommentViewHolder(view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
        holder.getBinding().rcvCommentImages.setLayoutManager(gridLayoutManager);
        holder.getBinding().rcvCommentImages.setAdapter(new ImageViewAdapter());

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CommentViewHolder holder, FeedbackViewModel data) {
        if (data == null) {
            return;
        }
        holder.setViewModel(data);
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {

        @Getter
        private final CommentAdapterBinding binding;

        public CommentViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = CommentAdapterBinding.bind(itemView);
        }

        public void setViewModel(FeedbackViewModel data) {
            binding.setViewModel(data);
        }

    }

}
