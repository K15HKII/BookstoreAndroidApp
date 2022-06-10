package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.OrderpageItemsAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OrderItemAdapter extends ListAdapter<OrderItemViewModel, OrderItemAdapter.OrderItemHolder> {

    private Context context;
    @Getter
    @Setter
    private IOrderNavigator orderNavigator;

    public OrderItemAdapter(Context context) {
        super(new ArrayList<>());
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
    protected void onBindViewHolder(OrderItemHolder holder, OrderItemViewModel data) {
        holder.setViewModel(data);
    }

    class OrderItemHolder extends RecyclerView.ViewHolder{

        private OrderpageItemsAdapterBinding binding;

        public OrderItemHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = OrderpageItemsAdapterBinding.bind(itemView);
        }

        public void setViewModel(OrderItemViewModel data) {
            binding.setViewModel(data);
        }
    }
}
