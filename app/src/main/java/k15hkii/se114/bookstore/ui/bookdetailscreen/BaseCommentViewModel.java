package k15hkii.se114.bookstore.ui.bookdetailscreen;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.model.api.message.Feedback;
import k15hkii.se114.bookstore.data.model.api.message.Message;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import lombok.Getter;

import java.util.Date;
import java.util.List;

public class BaseCommentViewModel<N extends INavigator> extends BaseViewModel<N> {

    @Bindable
    public String getComment() {
        return message == null ? null : message.getText();
    }

    @Bindable
    public List<Image> getImages() {
        return message == null ? null : message.getImages();
    }

    @Bindable
    public Date getCreatedAt() {
        return message == null ? null : message.getCreatedAt();
    }

    public final ObservableField<String> senderName = new ObservableField<>();
    public final ObservableField<Image> senderAvatar = new ObservableField<>();

    private Message message;
    @Getter private final ModelRemote remote;

    public BaseCommentViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider);
        this.remote = remote;
    }

    public void setMessage(Message message) {
        this.message = message;

        dispose(remote.getUser(message.getUserId()), user -> {
            senderName.set(user.getName());
            senderAvatar.set(user.getAvatar());
        }, throwable -> {
            Log.d("BaseCommentViewModel", "Error get user");
        });

        notifyPropertyChanged(BR.comment);
        notifyPropertyChanged(BR.images);
        notifyPropertyChanged(BR.createdAt);
    }

}
