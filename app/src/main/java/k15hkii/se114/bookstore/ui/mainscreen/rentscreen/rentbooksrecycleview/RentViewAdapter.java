package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.BookViewAdapterBinding;
import k15hkii.se114.bookstore.databinding.RentViewAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.BookViewModel;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.orderitemsrecycleview.IOrderNavigator;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RentViewAdapter extends ListAdapter<RentViewViewModel, RentViewAdapter.RentViewViewHolder> {

    private Context context;
    @Getter
    @Setter
    private RentViewNavigator rentViewNavigator;

    @Deprecated
    public RentViewAdapter(List<RentViewViewModel> rentViewList, Context context, RentViewNavigator rentViewNavigator) {
        super(rentViewList);
        this.context = context;
        this.rentViewNavigator = rentViewNavigator;
    }

    public RentViewAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    //set view
    @NonNull
    @NotNull
    @Override
    public RentViewViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rent_view_adapter, parent, false);
        return new RentViewAdapter.RentViewViewHolder(view);
    }

    //set DATA
    @Override
    public void onBindViewHolder(@NonNull @NotNull RentViewViewHolder holder, RentViewViewModel data) {
        holder.setViewModel(data);
        holder.itemView.setOnClickListener(d -> {
            getRentViewNavigator().Navigate(data);
        });
    }

    public class RentViewViewHolder extends RecyclerView.ViewHolder{

        private RentViewAdapterBinding binding;

        public RentViewViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = RentViewAdapterBinding.bind(itemView);
        }

        public void setViewModel(RentViewViewModel data) {
            binding.setViewModel(data);
        }
    }
}
