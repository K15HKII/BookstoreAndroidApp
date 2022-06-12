package k15hkii.se114.bookstore.ui.bookdetailscreen;

import k15hkii.se114.bookstore.data.model.api.message.Feedback;
import k15hkii.se114.bookstore.data.model.api.message.ReplyFeedback;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class ReplyViewModel extends BaseCommentViewModel<INavigator> {

    public ReplyViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void setReply(ReplyFeedback reply) {
        this.setMessage(reply);
    }

}
