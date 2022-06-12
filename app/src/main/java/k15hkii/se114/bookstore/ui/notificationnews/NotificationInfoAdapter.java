package k15hkii.se114.bookstore.ui.notificationnews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.NotificationWelcomeAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NotificationInfoAdapter extends ListAdapter<NotificationInfoViewModel,NotificationInfoAdapter.NotificationInfoHolder> {

    public NotificationInfoAdapter( List<NotificationInfoViewModel> lsNotificationInfo) {
        super(lsNotificationInfo);
    }

    @NonNull
    @NotNull
    @Override
    public NotificationInfoHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_welcome_adapter,parent,false);
        return new NotificationInfoAdapter.NotificationInfoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NotificationInfoHolder holder, NotificationInfoViewModel data) {
        holder.setViewModel(data);
    }

    class NotificationInfoHolder extends RecyclerView.ViewHolder {

        NotificationWelcomeAdapterBinding binding;

        public NotificationInfoHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = NotificationWelcomeAdapterBinding.bind(itemView);
        }
        public void setViewModel(NotificationInfoViewModel data) {
            binding.setViewModel(data);
        }
    }
}
