package k15hkii.se114.bookstore.ui.voucherscreen.adapterSelect;

import android.content.Context;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.VoucherItemAdapterFragmentBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class VoucherItemAdapter extends ListAdapter<VoucherItemAdapterViewModel, VoucherItemAdapter.VoucherItemHolder> {

    private Context context;
    @Deprecated
    public VoucherItemAdapter(List<VoucherItemAdapterViewModel> lsVouchers, Context context) {
        super(lsVouchers);
        this.context = context;
    }

    public VoucherItemAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public VoucherItemAdapter.VoucherItemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_item_adapter_fragment,parent,false);
        return new VoucherItemAdapter.VoucherItemHolder(view);
    }

    @Override
    protected void onBindViewHolder(VoucherItemHolder holder, VoucherItemAdapterViewModel data) {
        holder.setViewModel(data);
    }

    class VoucherItemHolder extends RecyclerView.ViewHolder{

        private VoucherItemAdapterFragmentBinding binding;

        public VoucherItemHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = VoucherItemAdapterFragmentBinding.bind(itemView);
        }
        public void setViewModel(VoucherItemAdapterViewModel data) {
            binding.setViewModel(data);
        }
    }

}
