package k15hkii.se114.bookstore.ui.account.address.recycleViewAddressSelector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.SelectorAddressAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OtherAddressAdapter extends ListAdapter<OtherAddressViewModel, OtherAddressAdapter.OtherAddressViewHolder> {

    private final Context context;

    @Deprecated
    public OtherAddressAdapter(List<OtherAddressViewModel> data, Context context) {
        super(data);
        this.context = context;
    }

    public OtherAddressAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(OtherAddressViewHolder holder, OtherAddressViewModel data) {
        holder.setViewModel(data);
    }

    @NonNull
    @NotNull
    @Override
    public OtherAddressViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selector_address_adapter, parent, false);
        return new OtherAddressAdapter.OtherAddressViewHolder(view);
    }

    public class OtherAddressViewHolder extends RecyclerView.ViewHolder {

        SelectorAddressAdapterBinding binding;

        public OtherAddressViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = SelectorAddressAdapterBinding.bind(itemView);
        }

        public void setViewModel(OtherAddressViewModel data) {
            binding.setViewModel(data);
        }

    }

}
