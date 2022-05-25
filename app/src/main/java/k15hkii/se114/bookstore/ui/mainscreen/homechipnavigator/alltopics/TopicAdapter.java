package k15hkii.se114.bookstore.ui.mainscreen.homechipnavigator.alltopics;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TopicAdapter extends ListAdapter<Topic,TopicAdapter.TopicViewHolder> {

    public TopicAdapter(List<Topic> data) {
        super(data);
    }

    @Override
    protected void onBindViewHolder(TopicAdapter.TopicViewHolder holder, Topic data) {
        if(data == null){
            return;
        }
        holder.tvTopicName.setText(data.getTopicName());
    }

    @NonNull
    @NotNull
    @Override
    public TopicAdapter.TopicViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_adapter,parent,false);
        return new TopicAdapter.TopicViewHolder(view);
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTopicName;

        public TopicViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvTopicName = itemView.findViewById(R.id.tvTopicAdapterName);
        }
    }
}
