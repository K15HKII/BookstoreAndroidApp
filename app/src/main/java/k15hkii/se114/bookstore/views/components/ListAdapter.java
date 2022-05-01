package k15hkii.se114.bookstore.views.components;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class ListAdapter<VM, T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    protected final List<VM> data;

    public ListAdapter(List<VM> data) {
        this.data = data;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull T holder, int position) {
        VM data = this.data.get(position);
        if (data == null)
            return;
        onBindViewHolder(holder, data);
    }

    protected abstract void onBindViewHolder(T holder, VM data);

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

}
