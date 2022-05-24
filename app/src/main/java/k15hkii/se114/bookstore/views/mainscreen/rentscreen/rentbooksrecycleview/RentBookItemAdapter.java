package k15hkii.se114.bookstore.views.mainscreen.rentscreen.rentbooksrecycleview;

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

public class RentBookItemAdapter extends ListAdapter<RentBookItem, RentBookItemAdapter.RentBookItemViewHolder> {

    Context context;

    public RentBookItemAdapter(List<RentBookItem> lsRentItem) {
        super(lsRentItem);
    }

    public RentBookItemAdapter(List<RentBookItem> lsRentItem, Context context) {
        super(lsRentItem);
        this.context = context;
    }

    public RentBookItemAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public RentBookItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rent_book_adapter,parent,false);
        return new RentBookItemAdapter.RentBookItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RentBookItemViewHolder holder, RentBookItem data) {
        holder.tvBookName.setText(data.getName());
    }

    public class RentBookItemViewHolder extends RecyclerView.ViewHolder{

        TextView tvBookName;

        public RentBookItemViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvBookName = itemView.findViewById(R.id.tvRentBookAdapterNameOfBook);
        }
    }
}
