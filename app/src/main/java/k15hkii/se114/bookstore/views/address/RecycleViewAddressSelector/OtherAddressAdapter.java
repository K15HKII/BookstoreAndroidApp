package k15hkii.se114.bookstore.views.address.RecycleViewAddressSelector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.views.address.Address;
import k15hkii.se114.bookstore.views.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OtherAddressAdapter extends ListAdapter<Address, OtherAddressAdapter.OtherAddressViewHolder> {

    Context context;

    public OtherAddressAdapter(List<Address> data, Context context) {
        super(data);
        this.context = context;
    }

    public OtherAddressAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(OtherAddressViewHolder holder, Address data) {
        if(data == null){
            return;
        }
        holder.radbtnAddress.setText(data.getLocation());
    }

    @NonNull
    @NotNull
    @Override
    public OtherAddressViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selector_address_adapter,parent,false);
        return new OtherAddressAdapter.OtherAddressViewHolder(view);
    }

    public class OtherAddressViewHolder extends RecyclerView.ViewHolder{

        RadioButton radbtnAddress;

        public OtherAddressViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            radbtnAddress = itemView.findViewById(R.id.btnAddressChoiceOtherAddress);
        }
    }
}
