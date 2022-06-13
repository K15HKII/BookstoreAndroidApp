package k15hkii.se114.bookstore.ui.order.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.OrderbookAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OrderBooksViewAdapter extends ListAdapter<OrderBookViewModel, OrderBooksViewAdapter.OrderBooksViewViewHolder> {

    private final Context context;

    @Getter
    @Setter
    private OrderBooksViewNavigator navigator;

    @Deprecated
    public OrderBooksViewAdapter(List<OrderBookViewModel> lsBookViews, Context context, OrderBooksViewNavigator navigator) {
        super(lsBookViews);
        this.context = context;
        this.navigator = navigator;
    }

    public OrderBooksViewAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public OrderBooksViewAdapter.OrderBooksViewViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderbook_adapter, parent, false);
        return new OrderBooksViewAdapter.OrderBooksViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OrderBooksViewAdapter.OrderBooksViewViewHolder holder,
                                 OrderBookViewModel data) {
        holder.itemView.setOnClickListener(d -> {
            getNavigator().Navigate(data);
        });
        holder.setViewModel(data);
    }

    class OrderBooksViewViewHolder extends RecyclerView.ViewHolder {

        private final OrderbookAdapterBinding binding;

        public OrderBooksViewViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = OrderbookAdapterBinding.bind(itemView);
        }

        public void setViewModel(OrderBookViewModel data) {
            binding.setViewModel(data);
        }

    }

}
