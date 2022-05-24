package k15hkii.se114.bookstore.views.bankscreen.RecycleViewBankSelector;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.views.address.RecycleViewAddressSelector.OtherAddressAdapter;
import k15hkii.se114.bookstore.views.bankscreen.BankAccount;
import k15hkii.se114.bookstore.views.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OtherBankAdapter extends ListAdapter<BankAccount, OtherBankAdapter.OtherBankViewHolder> {

    Context context;

    public OtherBankAdapter(List<BankAccount> data, Context context) {
        super(data);
        this.context = context;
    }

    public OtherBankAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(OtherBankViewHolder holder, BankAccount data) {
        if(data == null){
            return;
        }
        holder.tvBankName.setText(data.getBankName());
    }

    @NonNull
    @NotNull
    @Override
    public OtherBankViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selector_bank_adapter,parent,false);
        return new OtherBankAdapter.OtherBankViewHolder(view);
    }


    public class OtherBankViewHolder extends RecyclerView.ViewHolder{

        TextView tvBankName;

        public OtherBankViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvBankName = itemView.findViewById(R.id.tvBankChoiceAdapterBankName);
        }
    }
}
