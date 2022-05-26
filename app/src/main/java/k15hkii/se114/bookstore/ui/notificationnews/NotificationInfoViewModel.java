package k15hkii.se114.bookstore.ui.notificationnews;

import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;

public class NotificationInfoViewModel extends BaseViewModel<NotificationInfoViewNavigator> {

    @Inject protected ModelRemote remote;
    // todo: get data

    String title;
    String description;

    public NotificationInfoViewModel(String title, String description) {
        super(null);
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
