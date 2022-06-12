package k15hkii.se114.bookstore.ui.bookdetailscreen;

import androidx.databinding.Bindable;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.model.api.message.Feedback;
import k15hkii.se114.bookstore.data.model.api.message.Message;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

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

    private Message message;

    public BaseCommentViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void setMessage(Message message) {
        this.message = message;

        notifyPropertyChanged(BR.comment);
        notifyPropertyChanged(BR.images);
    }

}
