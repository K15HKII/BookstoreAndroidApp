package k15hkii.se114.bookstore.ui.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.NewsAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import k15hkii.se114.bookstore.ui.news.ImageViewAdapter;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends ListAdapter<NewsAdapterViewModel, NewsAdapter.NewsAdapterViewHolder> {
    Context context;
    @Deprecated
    public NewsAdapter(List<NewsAdapterViewModel> data, Context context) {
        super(data);
        this.context = context;
    }

    public NewsAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public NewsAdapter.NewsAdapterViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_adapter,parent,false);
        NewsAdapterViewHolder holder = new NewsAdapter.NewsAdapterViewHolder(view);
        ImageViewAdapter imageViewAdapter = new ImageViewAdapter();
        holder.getBinding().recyclerView.setAdapter(imageViewAdapter);
        return holder;
    }

    @Override
    protected void onBindViewHolder(NewsAdapterViewHolder holder, NewsAdapterViewModel data) {
        holder.setViewModel(data);
    }

    public class NewsAdapterViewHolder extends RecyclerView.ViewHolder{

        @Getter private final NewsAdapterBinding binding;

        public NewsAdapterViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = NewsAdapterBinding.bind(itemView);
        }

        public void setViewModel(NewsAdapterViewModel data) {
            binding.setViewModel(data);
        }
    }
}
