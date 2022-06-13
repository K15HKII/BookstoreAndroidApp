package k15hkii.se114.bookstore.ui.cart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.OncartItemsAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class OncartItemAdapter extends ListAdapter<OncartItemViewModel, OncartItemAdapter.oncart_itemHolder> {

    private final Context context;

    @Getter
    @Setter
    protected OncartItemNavigator oncartItemNavigator;

    @Inject
    protected OncartItemViewModel viewModel;

    @Deprecated
    public OncartItemAdapter(Context context, List<OncartItemViewModel> lsOncart) {
        super(lsOncart);
        this.context = context;
    }

    public OncartItemAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public oncart_itemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.oncart_items_adapter, parent, false);
        return new OncartItemAdapter.oncart_itemHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull @NotNull oncart_itemHolder holder, OncartItemViewModel data) {
        holder.itemView.setOnClickListener(d -> {
            getOncartItemNavigator().openBookDetailNavigator(data);
        });
        holder.setViewModel(data);
        data.setNavigator(oncartItemNavigator);
//        notifyDataSetChanged();
    }

    class oncart_itemHolder extends RecyclerView.ViewHolder {

        private final OncartItemsAdapterBinding binding;

        public oncart_itemHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = OncartItemsAdapterBinding.bind(itemView);
        }

        public void setViewModel(OncartItemViewModel data) {
            binding.setViewModel(data);
        }

    }

}
