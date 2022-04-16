package com.example.libraryapp.HomeRecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.libraryapp.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ListDataNotificationAdapter extends RecyclerView.Adapter<ListDataNotificationAdapter.ListDataNotificationViewHolder> {

    Context context;
    List<ListDataNotification> lslistDataNotifications;
    public static final int TYPE_INFO = 1;
    public static final int TYPE_ORDERVIEW = 2;

    public ListDataNotificationAdapter(Context context, List<ListDataNotification> lslistDataNotifications) {
        this.context = context;
        this.lslistDataNotifications = lslistDataNotifications;
    }

    public void setData(List<ListDataNotification> lsDATA){
        this.lslistDataNotifications = lsDATA;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return lslistDataNotifications.get(position).getType();
    }

    @NonNull
    @NotNull
    @Override
    public ListDataNotificationViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_datalist_adapter,parent,false);
        return new ListDataNotificationAdapter.ListDataNotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListDataNotificationViewHolder holder, int position) {
        ListDataNotification listDataNotification = lslistDataNotifications.get(position);
        if(listDataNotification == null){
            return;
        }
        if(TYPE_INFO == holder.getItemViewType()){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL,false);
            holder.rcvListNotification.setLayoutManager(linearLayoutManager);
            holder.rcvListNotification.setFocusable(false);

            NotificationInfoAdapter notificationInfoAdapter = new NotificationInfoAdapter(context, listDataNotification.getNotificationInfos());
            holder.rcvListNotification.setAdapter(notificationInfoAdapter);
        }
        else if(TYPE_ORDERVIEW == holder.getItemViewType()){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL,false);
            holder.rcvListNotification.setLayoutManager(linearLayoutManager);
            holder.rcvListNotification.setFocusable(false);

            NotificationOrderViewAdapter notificationOrderViewAdapter = new NotificationOrderViewAdapter(context, listDataNotification.getOrderItems());
            holder.rcvListNotification.setAdapter(notificationOrderViewAdapter);
        }
    }

    @Override
    public int getItemCount() {
        if(lslistDataNotifications != null){
            return lslistDataNotifications.size();
        }
        return 0;
    }

    class ListDataNotificationViewHolder extends RecyclerView.ViewHolder{

        RecyclerView rcvListNotification;

        public ListDataNotificationViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            rcvListNotification = itemView.findViewById(R.id.rcv_listNotificationDATA);
        }
    }
}
