package k15hkii.se114.bookstore.views.searchbook;

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

import java.util.ArrayList;
import java.util.List;

public class RecentSearchAdapter extends ListAdapter<RecentSearch, RecentSearchAdapter.RecentSearchViewHolder> {
    private Context context;

    public RecentSearchAdapter(List<RecentSearch> data) {
        super(data);
    }

    public RecentSearchAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(RecentSearchAdapter.RecentSearchViewHolder holder, RecentSearch data) {
        if(data == null){
            return;
        }
        holder.tvTitle.setText(data.getTitle());
    }

    @NonNull
    @NotNull
    @Override
    public RecentSearchAdapter.RecentSearchViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_adapter,parent,false);
        return new RecentSearchAdapter.RecentSearchViewHolder(view);
    }

    public class RecentSearchViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTitle;

        public RecentSearchViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTopicAdapterName);
        }
    }

    public void filterlist(ArrayList<RecentSearch> filterls){
        this.source = filterls;
        notifyDataSetChanged();
    }
}
