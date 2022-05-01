package k15hkii.se114.bookstore.views.notificationnews;

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

import java.util.List;

public class NotificationInfoAdapter extends ListAdapter<NotificationInfo,NotificationInfoAdapter.NotificationInfoHolder> {

    public NotificationInfoAdapter( List<NotificationInfo> lsNotificationInfo) {
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
    public void onBindViewHolder(@NonNull @NotNull NotificationInfoHolder holder, NotificationInfo data) {
        holder.tvTitle.setText(data.getTitle());
    }

    class NotificationInfoHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public NotificationInfoHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvNotificationWelcomeTitle);
        }
    }
}
