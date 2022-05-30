package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.WaitingOrderViewAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
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

    @Deprecated
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

    @NonNull
    @NotNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int index) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.waiting_order_view_adapter, parent, false);
        return new OrderViewAdapter.OrderViewHolder(view);
    }


    @Override
    protected void onBindViewHolder(OrderViewHolder holder, @SuppressLint("RecyclerView") OrderViewViewModel data) {
        // Create layout manager with initial prefetch item count
        //TODO: chèn chuyển view vào cả layout của recyclerview
//        LinearLayoutManager layoutManager = new LinearLayoutManager(
//                holder.binding.rcvWaitingOrderItemsItems.getContext(),
//                RecyclerView.VERTICAL,
//                false
//        );
//
//        // Create sub item view adapter
//        holder.binding.rcvWaitingOrderItemsItems.setLayoutManager(layoutManager);
        holder.itemView.setOnClickListener(d -> {
            getOrderNavigator().Navigate(data);
        });
        holder.setViewModel(data);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class OrderViewHolder extends RecyclerView.ViewHolder {

        private WaitingOrderViewAdapterBinding binding;

        public OrderViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = WaitingOrderViewAdapterBinding.bind(itemView);
            binding.rcvWaitingOrderItemsItems.setAdapter(new OrderItemAdapter(itemView.getContext()));
        }

        public void setViewModel(OrderViewViewModel data) {
            binding.setViewModel(data);
        }
    }
}
