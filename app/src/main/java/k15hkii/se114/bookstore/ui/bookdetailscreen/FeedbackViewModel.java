package k15hkii.se114.bookstore.ui.bookdetailscreen;

import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.message.Feedback;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.List;

public class FeedbackViewModel extends BaseCommentViewModel<INavigator> {

    public final ObservableField<List<ReplyViewModel>> replies = new ObservableField<>();

    public FeedbackViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider, remote);
    }

    public void setFeedback(Feedback feedback) {
        this.setMessage(feedback);
    }

}
