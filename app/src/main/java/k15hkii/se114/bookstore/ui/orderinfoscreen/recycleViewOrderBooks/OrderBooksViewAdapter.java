package k15hkii.se114.bookstore.ui.orderinfoscreen.recycleViewOrderBooks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.OrderbookAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartItemViewModel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OrderBooksViewAdapter extends ListAdapter<OrderBookViewModel,OrderBooksViewAdapter.OrderBooksViewViewHolder> {
    private Context context;

    @Deprecated
    public OrderBooksViewAdapter(List<OrderBookViewModel> lsBookViews, Context context) {
        super(lsBookViews);
        this.context = context;
    }

    public OrderBooksViewAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public OrderBooksViewAdapter.OrderBooksViewViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderpage_items_adapter,parent,false);
        return new OrderBooksViewAdapter.OrderBooksViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OrderBooksViewAdapter.OrderBooksViewViewHolder holder,
                                 OrderBookViewModel data) {
        holder.setViewModel(data);
    }

    class OrderBooksViewViewHolder extends RecyclerView.ViewHolder {

        private OrderbookAdapterBinding binding;

        public OrderBooksViewViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = OrderbookAdapterBinding.bind(itemView);
        }
        public void setViewModel(OrderBookViewModel data) {
            binding.setViewModel(data);
        }
    }
}