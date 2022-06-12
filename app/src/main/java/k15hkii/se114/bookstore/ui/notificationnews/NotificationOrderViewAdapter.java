package k15hkii.se114.bookstore.ui.notificationnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.databinding.NotificationOrderAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.OrderItemAdapter;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks.OrderBookViewModel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NotificationOrderViewAdapter extends ListAdapter<NotificationOrderViewModel,NotificationOrderViewAdapter.NotificationOrderHolder> {

    private Context context;

    public NotificationOrderViewAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public NotificationOrderHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_order_adapter,parent,false);
        return new NotificationOrderViewAdapter.NotificationOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NotificationOrderHolder holder, NotificationOrderViewModel data) {
        holder.setViewModel(data);
    }

    class NotificationOrderHolder extends RecyclerView.ViewHolder{

        NotificationOrderAdapterBinding binding;

        public NotificationOrderHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            //TODO: viết adapter cho notification order
            binding = NotificationOrderAdapterBinding.bind(itemView);
        }
        public void setViewModel(NotificationOrderViewModel data) {
            binding.setViewModel(data);
        }
    }
}
