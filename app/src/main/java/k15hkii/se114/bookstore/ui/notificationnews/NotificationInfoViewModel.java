package k15hkii.se114.bookstore.ui.notificationnews;

public class NotificationInfoViewModel {
    String title;
    String description;

    public NotificationInfoViewModel(String title, String description) {
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
