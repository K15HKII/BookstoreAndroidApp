package k15hkii.se114.bookstore.ui.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.databinding.ImageAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ImageViewAdapter extends ListAdapter<Image, ImageViewAdapter.ImageViewHolder> {

    public ImageViewAdapter() {
        super(new ArrayList<>());
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @Override
    protected void onBindViewHolder(ImageViewHolder holder, Image data) {
        holder.setImage(data);
    }

    @NonNull
    @NotNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_adapter, parent, false);
        return new ImageViewHolder(view);
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {

        private final ImageAdapterBinding binding;

        public ImageViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = ImageAdapterBinding.bind(itemView);
        }

        public void setImage(Image image) {
            binding.setImage(image);
            binding.notifyPropertyChanged(BR.image);
        }

    }

}
