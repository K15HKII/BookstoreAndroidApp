package k15hkii.se114.bookstore.ui.mainscreen.navigator.popular;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import k15hkii.se114.bookstore.R;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerAdapterHolder> {

    private final List<String> uris = Arrays.asList(
            "https://upbeat-resolver-316305.df.r.appspot.com/images/slide1.png",
            "https://upbeat-resolver-316305.df.r.appspot.com/images/slide2.png",
            "https://upbeat-resolver-316305.df.r.appspot.com/images/slide3.png"
    );

    private final Context context;

    public BannerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public BannerAdapterHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_image, parent, false);
        return new BannerAdapter.BannerAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BannerAdapterHolder holder, int position) {
        Glide.with(holder.imageView).load(uris.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return uris.size();
    }

    public static class BannerAdapterHolder extends RecyclerView.ViewHolder {

        @Getter
        private final ImageView imageView;

        public BannerAdapterHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_banner);
        }

    }

}
