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
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommentViewAdapter extends ListAdapter<FeedbackViewModel, CommentViewAdapter.CommentViewHolder> {

    Context context;

    public CommentViewAdapter(List<FeedbackViewModel> lsComments, Context context) {
        super(lsComments);
        this.context = context;
    }

    public CommentViewAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_adapter,parent,false);
        return new CommentViewAdapter.CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CommentViewHolder holder, FeedbackViewModel data) {
        if(data == null){
            return;
        }
        //holder.tvUserEmail.setText(data.getUserEmail());
    }

    class CommentViewHolder extends RecyclerView.ViewHolder{

        TextView tvUserEmail;

        public CommentViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvUserEmail = itemView.findViewById(R.id.tvCommentViewUserEmail);
            SpannableString content = new SpannableString("Content");
            content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
            tvUserEmail.setText(content);
        }
    }
}
