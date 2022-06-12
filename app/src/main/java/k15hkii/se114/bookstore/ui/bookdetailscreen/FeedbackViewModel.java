package k15hkii.se114.bookstore.ui.bookdetailscreen;

import k15hkii.se114.bookstore.data.model.api.message.Feedback;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

public class FeedbackViewModel extends BaseCommentViewModel<INavigator> {

    public FeedbackViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    public void setFeedback(Feedback feedback) {
        this.setMessage(feedback);
    }

}
