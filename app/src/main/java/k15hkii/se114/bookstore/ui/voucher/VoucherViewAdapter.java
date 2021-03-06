package k15hkii.se114.bookstore.ui.voucher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.VoucherItemAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class VoucherViewAdapter extends ListAdapter<BaseVoucherViewModel, VoucherViewAdapter.VoucherViewHolder> {

    private final Context context;

    public VoucherViewAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public VoucherViewAdapter.VoucherViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_item_adapter, parent, false);
        return new VoucherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull VoucherViewAdapter.VoucherViewHolder holder, BaseVoucherViewModel data) {
        holder.setViewModel(data);
    }

    static class VoucherViewHolder extends RecyclerView.ViewHolder {

        private final VoucherItemAdapterBinding binding;

        public VoucherViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = VoucherItemAdapterBinding.bind(itemView);
        }

        public void setViewModel(BaseVoucherViewModel data) {
            binding.setViewModel(data);
        }

    }

}
