package com.example.libraryapp.ratingbookscreen;

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

public class RatingReportAdapter extends RecyclerView.Adapter<RatingReportAdapter.RatingReportViewHolder> {

    List<RatingReport> lsRatingReport;
    Context context;

    public RatingReportAdapter(List<RatingReport> lsRatingReport, Context context) {
        this.lsRatingReport = lsRatingReport;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public RatingReportViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rating_detail_books_deltail_adapter,parent,false);
        return new RatingReportAdapter.RatingReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RatingReportViewHolder holder, int position) {
        RatingReport ratingReport = lsRatingReport.get(position);
        if(ratingReport != null){
            return;
        }
        holder.tvBookName.setText(ratingReport.getBookname());
    }

    @Override
    public int getItemCount() {
        if(lsRatingReport != null){
            return lsRatingReport.size();
        }
        return 0;
    }

    class RatingReportViewHolder extends RecyclerView.ViewHolder{

        TextView tvBookName;

        public RatingReportViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvBookName = itemView.findViewById(R.id.tvRatingReportNameOfBook);
        }
    }
}
