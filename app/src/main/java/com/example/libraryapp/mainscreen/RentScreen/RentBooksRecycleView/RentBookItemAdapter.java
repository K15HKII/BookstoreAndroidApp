package com.example.libraryapp.mainscreen.RentScreen.RentBooksRecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.libraryapp.R;
import com.example.libraryapp.mainscreen.ShipmentScreen.OrderShipmentAdapter.OrderItemsRecycleView.OrderItem;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RentBookItemAdapter extends RecyclerView.Adapter<RentBookItemAdapter.RentBookItemViewHolder> {

    List<RentBookItem> lsRentItem;
    Context context;

    public RentBookItemAdapter(List<RentBookItem> lsRentItem) {
        this.lsRentItem = lsRentItem;
    }

    public RentBookItemAdapter(List<RentBookItem> lsRentItem, Context context) {
        this.lsRentItem = lsRentItem;
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
    public void onBindViewHolder(@NonNull @NotNull RentBookItemViewHolder holder, int position) {
        RentBookItem rentBookItem = lsRentItem.get(position);
        if(rentBookItem == null){
            return;
        }
        holder.tvBookName.setText(rentBookItem.getName());
    }

    @Override
    public int getItemCount() {
        if(lsRentItem != null){
            return lsRentItem.size();
        }
        return 0;
    }

    public class RentBookItemViewHolder extends RecyclerView.ViewHolder{

        TextView tvBookName;

        public RentBookItemViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvBookName = itemView.findViewById(R.id.tvRentBookAdapterNameOfBook);
        }
    }
}
