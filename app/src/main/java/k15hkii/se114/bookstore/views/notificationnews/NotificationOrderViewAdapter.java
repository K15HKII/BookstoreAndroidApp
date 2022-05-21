package k15hkii.se114.bookstore.views.notificationnews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.views.components.ListAdapter;
import k15hkii.se114.bookstore.views.mainscreen.shipmentscreen.OrderShipmentAdapter.orderitemsrecycleview.OrderItemAdapter;
import k15hkii.se114.bookstore.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NotificationOrderViewAdapter extends ListAdapter<NotificationOrderView,NotificationOrderViewAdapter.NotificationOrderHolder> {

    public NotificationOrderViewAdapter(List<NotificationOrderView> data) {
        super(data);
    }

    @NonNull
    @NotNull
    @Override
    public NotificationOrderHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_order_adapter,parent,false);
        return new NotificationOrderViewAdapter.NotificationOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NotificationOrderHolder holder, NotificationOrderView data) {

        holder.tvTitle.setText(data.getTitle());
        holder.tvDescription.setText(data.getDescription());
        holder.tvPrice.setText(data.getPrice());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                holder.rcvListOrders.getContext(),
                RecyclerView.VERTICAL,
                false
        );

        OrderItemAdapter orderItemAdapter = new OrderItemAdapter(data.getLsorderItems());
        holder.rcvListOrders.setLayoutManager(linearLayoutManager);
        holder.rcvListOrders.setAdapter(orderItemAdapter);
        holder.rcvListOrders.setFocusable(false);
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
