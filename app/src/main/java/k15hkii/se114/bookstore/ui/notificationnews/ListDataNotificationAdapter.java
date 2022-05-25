package k15hkii.se114.bookstore.ui.notificationnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ListDataNotificationAdapter extends ListAdapter<ListDataNotification,ListDataNotificationAdapter.ListDataNotificationViewHolder> {

    Context context;
    public static final int TYPE_INFO = 1;
    public static final int TYPE_ORDERVIEW = 2;

    public ListDataNotificationAdapter(Context context, List<ListDataNotification> lslistDataNotifications) {
        super(lslistDataNotifications);
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return super.source.get(position).getType();
    }

    @NonNull
    @NotNull
    @Override
    public ListDataNotificationViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_datalist_adapter,parent,false);
        return new ListDataNotificationAdapter.ListDataNotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListDataNotificationViewHolder holder, ListDataNotification data) {
        if(data == null){
            return;
        }
        if(TYPE_INFO == holder.getItemViewType()){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL,false);
            holder.rcvListNotification.setLayoutManager(linearLayoutManager);
            holder.rcvListNotification.setFocusable(false);

            NotificationInfoAdapter notificationInfoAdapter = new NotificationInfoAdapter(data.getNotificationInfos());
            holder.rcvListNotification.setAdapter(notificationInfoAdapter);
        }
        else if(TYPE_ORDERVIEW == holder.getItemViewType()){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL,false);
            holder.rcvListNotification.setLayoutManager(linearLayoutManager);
            holder.rcvListNotification.setFocusable(false);

            NotificationOrderViewAdapter notificationOrderViewAdapter = new NotificationOrderViewAdapter(data.getOrderItems());
            holder.rcvListNotification.setAdapter(notificationOrderViewAdapter);
        }
    }

    class ListDataNotificationViewHolder extends RecyclerView.ViewHolder{

        RecyclerView rcvListNotification;

        public ListDataNotificationViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            rcvListNotification = itemView.findViewById(R.id.rcv_listNotificationDATA);
        }
    }
}
