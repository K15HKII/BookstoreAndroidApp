package k15hkii.se114.bookstore.views.oncartscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OncartItemAdapter extends RecyclerView.Adapter<OncartItemAdapter.oncart_itemHolder> {

    Context context;
    List<OncartItem> lsOncart;

    public OncartItemAdapter(List<OncartItem> lsOncart) {
        this.lsOncart = lsOncart;
    }

    public void setLsOncart(List<OncartItem> lsOncart) {
        this.lsOncart = lsOncart;
        notifyDataSetChanged();
    }

    public OncartItemAdapter(Context context, List<OncartItem> lsOncart) {
        this.context = context;
        this.lsOncart = lsOncart;
    }

    @NonNull
    @NotNull
    @Override
    public oncart_itemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.oncart_items_adapter,parent,false);
        return new OncartItemAdapter.oncart_itemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull oncart_itemHolder holder, int position) {
        OncartItem oncart_item = lsOncart.get(position);
        if(oncart_item == null){
            return;
        }
        holder.tvBookName.setText(oncart_item.getName());
    }

    @Override
    public int getItemCount() {
        if(lsOncart!=null){
            return lsOncart.size();
        }
        return 0;
    }

    class oncart_itemHolder extends RecyclerView.ViewHolder{

        private TextView tvBookName;

        public oncart_itemHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvBookName = itemView.findViewById(R.id.tvOnCartItemName);
        }
    }
}
