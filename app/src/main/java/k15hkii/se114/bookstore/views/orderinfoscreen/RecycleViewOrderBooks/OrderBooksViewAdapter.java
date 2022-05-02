package k15hkii.se114.bookstore.views.orderinfoscreen.RecycleViewOrderBooks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.views.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OrderBooksViewAdapter extends ListAdapter<OrderBookView,OrderBooksViewAdapter.OrderBooksViewViewHolder> {
    Context context;

    public OrderBooksViewAdapter(List<OrderBookView> lsBookViews, Context context) {
        super(lsBookViews);
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
    public void onBindViewHolder(@NonNull @NotNull OrderBooksViewAdapter.OrderBooksViewViewHolder holder,OrderBookView data) {
        if(data == null){
            return;
        }
        holder.tvItemTilte.setText(data.getName());
    }

    class OrderBooksViewViewHolder extends RecyclerView.ViewHolder{

        TextView tvItemTilte;

        public OrderBooksViewViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvItemTilte = itemView.findViewById(R.id.tvBooksNameOfBook);

        }
    }
}