package com.example.libraryapp.HomeRecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.libraryapp.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OrderViewAdapter extends RecyclerView.Adapter<OrderViewAdapter.OrderViewHolder> {

    private List<OrderView> orderViewList;
    Context context;

    public OrderViewAdapter(List<OrderView> orderViewList,Context context){
        this.orderViewList = orderViewList;
        this.context = context;
    }

    public void setData(Context context,List<OrderView> orderViewList){
        this.orderViewList = orderViewList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.waiting_order_view_items, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OrderViewHolder holder, int position) {
        OrderView orderView = orderViewList.get(position);
        if(orderView == null){
            return;
        }
        holder.tvItemNote.setText(orderView.getNote());
        holder.tvItemPrice.setText(orderView.getPrice());

        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.rcvBookList.getContext(),
                RecyclerView.VERTICAL,
                false
        );

        // Create sub item view adapter
        OrderItemAdapter orderItemAdapter = new OrderItemAdapter(orderView.getLsBooks());

        holder.rcvBookList.setLayoutManager(layoutManager);
        holder.rcvBookList.setAdapter(orderItemAdapter);
        holder.rcvBookList.setFocusable(false);
    }

    @Override
    public int getItemCount() {
        return orderViewList.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder{

        private TextView tvItemPrice,tvItemNote;
        private RecyclerView rcvBookList;

        public OrderViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvItemPrice = itemView.findViewById(R.id.tvWaitingOrderItemsPrice);
            tvItemNote = itemView.findViewById(R.id.tvWaitingOrderItemsNote);
            rcvBookList = itemView.findViewById(R.id.rcvWaitingOrderItemsItems);
        }
    }
}
