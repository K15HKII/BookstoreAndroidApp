package com.example.libraryapp.mainscreen.Shipment_screen.OrderShipmentAdapter.OrderItemsRecycleView;

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

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.OrderItemHolder> {

    List<OrderItem> lsOrderItem;
    Context context;

    public OrderItemAdapter(List<OrderItem> lsOrderItem) {
        this.lsOrderItem = lsOrderItem;
    }

    public OrderItemAdapter(List<OrderItem> lsOrderItem, Context context) {
        this.lsOrderItem = lsOrderItem;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public OrderItemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderpage_items_adapter,parent,false);
        return new OrderItemAdapter.OrderItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OrderItemHolder holder, int position) {
        OrderItem orderItem = lsOrderItem.get(position);
        if(orderItem == null){
            return;
        }
        holder.tvBookName.setText(orderItem.getName());
    }

    @Override
    public int getItemCount() {
        if(lsOrderItem != null){
            return lsOrderItem.size();
        }
        return 0;
    }

    class OrderItemHolder extends RecyclerView.ViewHolder{

        TextView tvBookName;

        public OrderItemHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvBookName = itemView.findViewById(R.id.tvListBooksNameOfBook);
        }
    }
}
