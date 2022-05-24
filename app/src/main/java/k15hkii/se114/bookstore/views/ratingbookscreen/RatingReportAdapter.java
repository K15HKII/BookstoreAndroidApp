package k15hkii.se114.bookstore.views.ratingbookscreen;

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

import java.util.ArrayList;
import java.util.List;

public class RatingReportAdapter extends ListAdapter<RatingReport,RatingReportAdapter.RatingReportViewHolder> {

    Context context;

    public RatingReportAdapter(List<RatingReport> lsRatingReport, Context context) {
        super(lsRatingReport);
        this.context = context;
    }

    public RatingReportAdapter(Context context) {
        super(new ArrayList<>());
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
    public void onBindViewHolder(@NonNull @NotNull RatingReportViewHolder holder, RatingReport data) {

        if(data == null){
            return;
        }
        holder.tvBookName.setText(data.getBookname());
    }

    class RatingReportViewHolder extends RecyclerView.ViewHolder{

        TextView tvBookName;

        public RatingReportViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvBookName = itemView.findViewById(R.id.tvRatingReportNameOfBook);
        }
    }
}
