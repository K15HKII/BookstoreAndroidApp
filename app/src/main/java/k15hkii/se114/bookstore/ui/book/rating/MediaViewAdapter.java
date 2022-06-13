package k15hkii.se114.bookstore.ui.book.rating;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.databinding.AddImageAdapterBinding;
import k15hkii.se114.bookstore.databinding.ImageAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MediaViewAdapter extends ListAdapter<Object, MediaViewAdapter.MediaViewHolder> {

    @Setter
    private RatingBooksDetailPageNavigator navigator;

    public MediaViewAdapter() {
        super(new ArrayList<>());
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MediaViewHolder holder, int position) {
        if (position == super.getItemCount()) {
            onBindViewHolder(holder, navigator);
            return;
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == super.getItemCount() ? 0 : 1;
    }

    @Override
    protected void onBindViewHolder(MediaViewHolder holder, Object data) {
        if (holder instanceof NavigatorViewHolder && data instanceof RatingBooksDetailPageNavigator) {
            ((NavigatorViewHolder) holder).setNavigator((RatingBooksDetailPageNavigator) data);
            return;
        }
        if (holder instanceof ImageViewHolder && data instanceof Image) {
            ((ImageViewHolder) holder).setImage((Image) data);
            return;
        }
    }

    @NonNull
    @NotNull
    @Override
    public MediaViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_image_adapter, parent, false);
            return new NavigatorViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_adapter, parent, false);
            return new ImageViewHolder(view);
        }
    }

    static class MediaViewHolder extends RecyclerView.ViewHolder {

        public MediaViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }

    }

    static class NavigatorViewHolder extends MediaViewHolder {

        private final AddImageAdapterBinding binding;

        public NavigatorViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = AddImageAdapterBinding.bind(itemView);
        }

        public void setNavigator(RatingBooksDetailPageNavigator navigator) {
            binding.setNavigator(navigator);
            binding.notifyPropertyChanged(BR.navigator);
        }

    }

    static class ImageViewHolder extends MediaViewHolder {

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
