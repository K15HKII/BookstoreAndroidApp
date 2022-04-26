package com.example.libraryapp.notificationnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.libraryapp.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NotificationInfoAdapter extends RecyclerView.Adapter<NotificationInfoAdapter.NotificationInfoHolder> {

    Context context;
    List<NotificationInfo> lsNotificationInfo;

    public NotificationInfoAdapter(Context context, List<NotificationInfo> lsNotificationInfo) {
        this.context = context;
        this.lsNotificationInfo = lsNotificationInfo;
    }

    @NonNull
    @NotNull
    @Override
    public NotificationInfoHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_welcome_adapter,parent,false);
        return new NotificationInfoAdapter.NotificationInfoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NotificationInfoHolder holder, int position) {
        NotificationInfo notificationInfo = lsNotificationInfo.get(position);
        if(notificationInfo == null){
            return;
        }
        holder.tvTitle.setText(notificationInfo.getTitle());
    }

    @Override
    public int getItemCount() {
        if(lsNotificationInfo != null){
            return lsNotificationInfo.size();
        }
        return 0;
    }

    class NotificationInfoHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public NotificationInfoHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvNotificationWelcomeTitle);
        }
    }
}
