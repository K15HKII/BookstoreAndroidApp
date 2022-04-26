package com.example.libraryapp.accountscreen.VoucherScreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.libraryapp.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class VoucherViewAdapter extends RecyclerView.Adapter<VoucherViewAdapter.VoucherViewHolder> {

    List<Voucher> lsVouchers;
    Context context;

    public void setLsVouchers(List<Voucher> lsVouchers) {
        this.lsVouchers = lsVouchers;
        notifyDataSetChanged();
    }

    public VoucherViewAdapter(List<Voucher> lsVouchers, Context context) {
        this.lsVouchers = lsVouchers;
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
    public void onBindViewHolder(@NonNull @NotNull VoucherViewAdapter.VoucherViewHolder holder, int position) {
        Voucher voucher = lsVouchers.get(position);
        if(voucher == null){
            return;
        }
        holder.tvItemTilte.setText(voucher.getTitle());
    }

    @Override
    public int getItemCount() {
        if(lsVouchers != null){
            return lsVouchers.size();
        }
        return 0;
    }

    class VoucherViewHolder extends RecyclerView.ViewHolder{

        TextView tvItemTilte;

        public VoucherViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvItemTilte = itemView.findViewById(R.id.tvVoucherItemTitle);

        }
    }
}
