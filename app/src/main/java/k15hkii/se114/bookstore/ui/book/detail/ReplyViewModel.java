package k15hkii.se114.bookstore.ui.book.detail;

import k15hkii.se114.bookstore.data.model.api.message.ReplyFeedback;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class ReplyViewModel extends BaseCommentViewModel<INavigator> {

    public ReplyViewModel(SchedulerProvider schedulerProvider, ModelRemote remote) {
        super(schedulerProvider, remote);
    }

    public void setReply(ReplyFeedback reply) {
        this.setMessage(reply);
    }

}
