package k15hkii.se114.bookstore.views.components;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class ListAdapter<VM, T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    @Getter protected List<VM> source;

    public ListAdapter(List<VM> data) {
        this.source = data;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull T holder, int position) {
        VM data = this.source.get(position);
        if (data == null)
            return;
        onBindViewHolder(holder, data);
    }

    protected abstract void onBindViewHolder(T holder, VM data);

    @Override
    public int getItemCount() {
        return source == null ? 0 : source.size();
    }

}
