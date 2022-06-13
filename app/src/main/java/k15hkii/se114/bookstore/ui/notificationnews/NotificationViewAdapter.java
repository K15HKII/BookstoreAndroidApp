package k15hkii.se114.bookstore.ui.notificationnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.databinding.NotificationOrderAdapterBinding;
import k15hkii.se114.bookstore.ui.components.ListAdapter;
import k15hkii.se114.bookstore.R;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NotificationViewAdapter extends ListAdapter<NotificationViewModel, NotificationViewAdapter.NotificationOrderHolder> implements NotificationViewNavigator {

    private Context context;
    @Setter
    private NotificationPageNavigator pageNavigator;

    public NotificationViewAdapter(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public NotificationOrderHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_order_adapter, parent, false);
        return new NotificationViewAdapter.NotificationOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NotificationOrderHolder holder, NotificationViewModel data) {
        data.setNavigator(this);
        holder.setViewModel(data);
    }

    @Override
    public void onClick(Object object) {
        pageNavigator.childNavigate(object);
    }

    class NotificationOrderHolder extends RecyclerView.ViewHolder {

        NotificationOrderAdapterBinding binding;

        public NotificationOrderHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = NotificationOrderAdapterBinding.bind(itemView);
        }

        public void setViewModel(NotificationViewModel data) {
            binding.setViewModel(data);
        }
    }
}
