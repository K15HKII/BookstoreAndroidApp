package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.IOrderNavigator;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.waitingorderview.WaitingOrderViewPage;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OrderViewAdapter extends ListAdapter<OrderViewViewModel, OrderViewAdapter.OrderViewHolder> {

    private Context context;
    @Getter
    @Setter
    private IOrderNavigator orderNavigator;

    public OrderViewAdapter(List<OrderViewViewModel> orderViewList, Context context, IOrderNavigator orderNavigator) {
        super(orderViewList);
        this.context = context;
        this.orderNavigator = orderNavigator;
    }

    public OrderViewAdapter(List<OrderViewViewModel> orderViewList) {
        super(orderViewList);
    }

    public OrderViewAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(OrderViewHolder holder, OrderViewViewModel data) {
        if (data == null) {
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

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderNavigator.Navigate(data);
            }
        });
    }

    @NonNull
    @NotNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int index) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.waiting_order_view_adapter, parent, false);
        return new OrderViewAdapter.OrderViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class OrderViewHolder extends RecyclerView.ViewHolder {

        private TextView tvItemPrice, tvItemNote;
        private RecyclerView rcvBookList;
        private LinearLayout layout;

        public OrderViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvItemPrice = itemView.findViewById(R.id.tvWaitingOrderItemsPrice);
            tvItemNote = itemView.findViewById(R.id.tvWaitingOrderItemsNote);
            rcvBookList = itemView.findViewById(R.id.rcvWaitingOrderItemsItems);
            layout = itemView.findViewById(R.id.layoutOrderAdapter);
        }
    }
}
