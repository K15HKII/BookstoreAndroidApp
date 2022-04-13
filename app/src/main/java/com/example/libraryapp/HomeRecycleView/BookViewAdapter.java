package com.example.libraryapp.HomeRecycleView;

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

public class BookViewAdapter extends RecyclerView.Adapter<BookViewAdapter.BookViewHolder> {
    private Context context;
    public List<BookView> lsBookView;

    public void setLsBookView(List<BookView> lsBookView) {
        this.lsBookView = lsBookView;
        notifyDataSetChanged();
    }

    public BookViewAdapter(Context context, List<BookView> lsBookView) {
        this.context = context;
        this.lsBookView = lsBookView;
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
    public void onBindViewHolder(@NonNull @NotNull BookViewHolder holder, int position) {
        BookView book = lsBookView.get(position);
        if(book == null){
            return;
        }
        holder.tvBookName.setText(book.getName());
    }

    @Override
    public int getItemCount() {
        if(lsBookView!=null){
            return lsBookView.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{

        private TextView tvBookName;

        public BookViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvBookName = itemView.findViewById(R.id.tvBookViewBookName);
        }
    }
}
