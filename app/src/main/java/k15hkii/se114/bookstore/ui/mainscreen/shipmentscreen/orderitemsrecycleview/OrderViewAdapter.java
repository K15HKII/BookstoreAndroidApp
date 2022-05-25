package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OrderViewAdapter extends ListAdapter<OrderView, OrderViewAdapter.OrderViewHolder> {

    private Context context;

    public OrderViewAdapter(List<OrderView> orderViewList, Context context){
        super(orderViewList);
        this.context = context;
    }

    public OrderViewAdapter(List<OrderView> orderViewList){
        super(orderViewList);
    }

    public OrderViewAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(OrderViewHolder holder, OrderView data) {
        if(data == null){
            return;
        }
        holder.tvItemNote.setText(data.getNote());
        holder.tvItemPrice.setText(data.getPrice());

        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.rcvBookList.getContext(),
                RecyclerView.VERTICAL,
                false
        );

        // Create sub item view adapter
        OrderItemAdapter orderItemAdapter = new OrderItemAdapter(data.getLsBooks());

        holder.rcvBookList.setLayoutManager(layoutManager);
        holder.rcvBookList.setAdapter(orderItemAdapter);
        holder.rcvBookList.setFocusable(false);
    }

    @NonNull
    @NotNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.waiting_order_view_adapter, parent, false);
        return new OrderViewAdapter.OrderViewHolder(view);
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
