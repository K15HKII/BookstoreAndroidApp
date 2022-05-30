package k15hkii.se114.bookstore.ui.bankscreen.recycleViewBankSelector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.SelectorBankAdapterBinding;
import k15hkii.se114.bookstore.ui.address.recycleViewAddressSelector.OtherAddressViewModel;
import k15hkii.se114.bookstore.ui.bankscreen.BankAccount;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OtherBankAdapter extends ListAdapter<OtherBankViewModel, OtherBankAdapter.OtherBankViewHolder> {

    Context context;
    @Deprecated
    public OtherBankAdapter(List<OtherBankViewModel> data, Context context) {
        super(data);
        this.context = context;
    }

    public OtherBankAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(OtherBankViewHolder holder, OtherBankViewModel data) {
        holder.setViewModel(data);
    }

    @NonNull
    @NotNull
    @Override
    public OtherBankViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selector_bank_adapter,parent,false);
        return new OtherBankAdapter.OtherBankViewHolder(view);
    }


    public class OtherBankViewHolder extends RecyclerView.ViewHolder{

        SelectorBankAdapterBinding binding;

        public OtherBankViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = SelectorBankAdapterBinding.bind(itemView);
        }

        public void setViewModel(OtherBankViewModel data) {
            binding.setViewModel(data);
        }
    }
}
