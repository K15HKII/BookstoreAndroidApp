package com.example.libraryapp.bookdetailscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.libraryapp.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CommentViewAdapter extends RecyclerView.Adapter<CommentViewAdapter.CommentViewHolder> {

    List<Comment> lsComments;
    Context context;

    public void setLsComments(List<Comment> lsComments) {
        this.lsComments = lsComments;
    }

    public CommentViewAdapter(List<Comment> lsComments, Context context) {
        this.lsComments = lsComments;
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
    public void onBindViewHolder(@NonNull @NotNull CommentViewHolder holder, int position) {
        Comment comment = lsComments.get(position);
        if(comment == null){
            return;
        }
        holder.tvUserEmail.setText(comment.getUserEmail());
    }

    @Override
    public int getItemCount() {
        if(lsComments != null)
        {
            return lsComments.size();
        }
        return 0;
    }

    class CommentViewHolder extends RecyclerView.ViewHolder{

        TextView tvUserEmail;

        public CommentViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvUserEmail = itemView.findViewById(R.id.tvCommentViewUserEmail);
        }
    }
}
