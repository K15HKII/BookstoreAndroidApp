package k15hkii.se114.bookstore.views.accountscreen.voucherscreen;

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

public class VoucherViewAdapter extends ListAdapter<Voucher,VoucherViewAdapter.VoucherViewHolder> {

    Context context;

    public VoucherViewAdapter(List<Voucher> lsVouchers, Context context) {
        super(lsVouchers);
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public VoucherViewAdapter.VoucherViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_item_adapter,parent,false);
        return new VoucherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull VoucherViewAdapter.VoucherViewHolder holder, Voucher data) {
        if(data == null){
            return;
        }
        holder.tvItemTilte.setText(data.getTitle());
    }

    class VoucherViewHolder extends RecyclerView.ViewHolder{

        TextView tvItemTilte;

        public VoucherViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvItemTilte = itemView.findViewById(R.id.tvVoucherItemTitle);

        }
    }
}
