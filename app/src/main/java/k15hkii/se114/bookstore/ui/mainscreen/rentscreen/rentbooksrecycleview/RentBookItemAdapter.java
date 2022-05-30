package k15hkii.se114.bookstore.ui.mainscreen.rentscreen.rentbooksrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.RentBookAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RentBookItemAdapter extends ListAdapter<RentBookItemViewModel, RentBookItemAdapter.RentBookItemViewHolder> {

    private Context context;

    @Deprecated
    public RentBookItemAdapter(List<RentBookItemViewModel> lsRentItem) {
        super(lsRentItem);
    }

    public RentBookItemAdapter(List<RentBookItemViewModel> lsRentItem, Context context) {
        super(lsRentItem);
        this.context = context;
    }

    public RentBookItemAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public RentBookItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rent_book_adapter, parent, false);
        return new RentBookItemAdapter.RentBookItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RentBookItemViewHolder holder, RentBookItemViewModel data) {
        holder.setViewModel(data);
    }

    public class RentBookItemViewHolder extends RecyclerView.ViewHolder {

        private RentBookAdapterBinding binding;

        public RentBookItemViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = RentBookAdapterBinding.bind(itemView);
        }

        public void setViewModel(RentBookItemViewModel data) {
            binding.setViewModel(data);
        }
    }
}
