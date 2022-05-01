package k15hkii.se114.bookstore.views.mainscreen.RentScreen.RentBooksRecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RentViewAdapter extends RecyclerView.Adapter<RentViewAdapter.RentViewViewHolder> {

    private List<RentView> RentViewList;
    Context context;

    public RentViewAdapter(List<RentView> rentViewList, Context context) {
        RentViewList = rentViewList;
        this.context = context;
    }

    public void setData(Context context,List<RentView> rentViewList){
        this.RentViewList = rentViewList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public RentViewViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rent_view_adapter, parent, false);
        return new RentViewAdapter.RentViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RentViewViewHolder holder, int position) {
        RentView rentView = RentViewList.get(position);
        if(rentView == null){
            return;
        }
        holder.tvItemNote.setText(rentView.getNote());
        holder.tvItemPrice.setText(rentView.getPrice());
        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.rcvBookList.getContext(),
                RecyclerView.VERTICAL,
                false
        );
        // Create sub item view adapter
        RentBookItemAdapter rentBookItemAdapter = new RentBookItemAdapter(rentView.getLsRentItem());
        holder.rcvBookList.setLayoutManager(layoutManager);
        holder.rcvBookList.setAdapter(rentBookItemAdapter);
        holder.rcvBookList.setFocusable(false);
    }

    @Override
    public int getItemCount() {
        if(RentViewList != null){
            return RentViewList.size();
        }
        return 0;
    }

    public class RentViewViewHolder extends RecyclerView.ViewHolder{
        private TextView tvItemPrice,tvItemNote;
        private RecyclerView rcvBookList;

        public RentViewViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvItemPrice = itemView.findViewById(R.id.tvRentItemsPrice);
            tvItemNote = itemView.findViewById(R.id.tvRentItemsNote);
            rcvBookList = itemView.findViewById(R.id.rcvRentItemsListItems);
        }
    }
}
