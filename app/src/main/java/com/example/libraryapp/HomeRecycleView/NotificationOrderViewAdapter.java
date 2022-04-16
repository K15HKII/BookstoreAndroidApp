package com.example.libraryapp.HomeRecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.libraryapp.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NotificationOrderViewAdapter extends RecyclerView.Adapter<NotificationOrderViewAdapter.NotificationOrderHolder> {

    Context context;
    List<NotificationOrderView> lsOrderView;

    public NotificationOrderViewAdapter(Context context, List<NotificationOrderView> lsOrderView) {
        this.context = context;
        this.lsOrderView = lsOrderView;
    }

    @NonNull
    @NotNull
    @Override
    public NotificationOrderHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_order_adapter,parent,false);
        return new NotificationOrderViewAdapter.NotificationOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NotificationOrderHolder holder, int position) {
        NotificationOrderView notificationOrderView = lsOrderView.get(position);
        if(notificationOrderView == null)
            return;
        holder.tvTitle.setText(notificationOrderView.getTitle());
        holder.tvDescription.setText(notificationOrderView.getDescription());
        holder.tvPrice.setText(notificationOrderView.getPrice());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                holder.rcvListOrders.getContext(),
                RecyclerView.VERTICAL,
                false
        );

        OrderItemAdapter orderItemAdapter = new OrderItemAdapter(notificationOrderView.getLsorderItems());
        holder.rcvListOrders.setLayoutManager(linearLayoutManager);
        holder.rcvListOrders.setAdapter(orderItemAdapter);
        holder.rcvListOrders.setFocusable(false);
    }

    @Override
    public int getItemCount() {
        if(lsOrderView != null){
            return lsOrderView.size();
        }
        return 0;
    }

    class NotificationOrderHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvDescription;
        TextView tvPrice;
        RecyclerView rcvListOrders;

        public NotificationOrderHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvNotificationTitle);
            tvDescription = itemView.findViewById(R.id.tvNotificationDescription);
            tvPrice = itemView.findViewById(R.id.tvNotificationItemsPrice);
            rcvListOrders = itemView.findViewById(R.id.rcvNotificaitonOrderView);
        }
    }
}
