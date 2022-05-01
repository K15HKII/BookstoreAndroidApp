package k15hkii.se114.bookstore.views.mainscreen.ShipmentScreen.OrderShipmentAdapter.OrderItemsRecycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.views.componenets.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OrderItemAdapter extends ListAdapter<OrderItem, OrderItemAdapter.OrderItemHolder> {

    public OrderItemAdapter(List<OrderItem> lsOrderItem) {
        super(lsOrderItem);
    }

    @Override
    protected void onBindViewHolder(OrderItemHolder holder, OrderItem data) {
        holder.tvBookName.setText(data.getName());
    }

    @NonNull
    @NotNull
    @Override
    public OrderItemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderpage_items_adapter,parent,false);
        return new OrderItemAdapter.OrderItemHolder(view);
    }

    class OrderItemHolder extends RecyclerView.ViewHolder{

        TextView tvBookName;

        public OrderItemHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvBookName = itemView.findViewById(R.id.tvListBooksNameOfBook);
        }
    }
}
