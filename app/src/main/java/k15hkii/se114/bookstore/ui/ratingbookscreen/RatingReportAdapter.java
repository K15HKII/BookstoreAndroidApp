package k15hkii.se114.bookstore.ui.ratingbookscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.RatingDetailBooksDeltailAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RatingReportAdapter extends ListAdapter<RatingReportViewModel,RatingReportAdapter.RatingReportViewHolder> {

    private Context context;
    @Getter
    @Setter
    IRatingReportAdapterNavigator navigator;

    public RatingReportAdapter(List<RatingReportViewModel> lsRatingReport, Context context, IRatingReportAdapterNavigator navigator) {
        super(lsRatingReport);
        this.context = context;
        this.navigator = navigator;
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
    public void onBindViewHolder(@NonNull @NotNull RatingReportViewHolder holder, RatingReportViewModel data) {
        holder.binding.btnRatingReportAddImage1.setOnClickListener(d -> {
            getNavigator().getPicture(data);
        });
        holder.setViewModel(data);
    }

    class RatingReportViewHolder extends RecyclerView.ViewHolder{

        RatingDetailBooksDeltailAdapterBinding binding;

        public RatingReportViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = RatingDetailBooksDeltailAdapterBinding.bind(itemView);
        }

        public void setViewModel(RatingReportViewModel data) {
            binding.setViewModel(data);
        }
    }
}
