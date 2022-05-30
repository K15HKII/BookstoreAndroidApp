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
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RentViewAdapter extends ListAdapter<RentViewViewModel, RentViewAdapter.RentViewViewHolder> {

    private Context context;

    @Deprecated
    public RentViewAdapter(List<RentViewViewModel> rentViewList, Context context) {
        super(rentViewList);
        this.context = context;
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
//        if(data == null){
//            return;
//        }
//        holder.tvItemNote.setText(data.getNote());
//        holder.tvItemPrice.setText(data.getPrice());
//        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.binding.rcvRentItemsListItems.getContext(),
                RecyclerView.VERTICAL,
                false
        );
//        // Create sub item view adapter
//        RentBookItemAdapter rentBookItemAdapter = new RentBookItemAdapter(data.getRentListItem());
        holder.binding.rcvRentItemsListItems.setLayoutManager(layoutManager);
//        holder.rcvBookList.setAdapter(rentBookItemAdapter);
//        holder.rcvBookList.setFocusable(false);

        holder.setViewModel(data);
    }

    public class RentViewViewHolder extends RecyclerView.ViewHolder{

        private RentViewAdapterBinding binding;

        public RentViewViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = RentViewAdapterBinding.bind(itemView);
            binding.rcvRentItemsListItems.setAdapter(new RentBookItemAdapter(itemView.getContext()));
        }

        public void setViewModel(RentViewViewModel data) {
            binding.setViewModel(data);
        }
    }
}
