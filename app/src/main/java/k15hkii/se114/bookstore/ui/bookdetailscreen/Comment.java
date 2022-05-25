package k15hkii.se114.bookstore.ui.bookdetailscreen;

public class Comment {
    String UserEmail;

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public Comment(String userEmail) {
        UserEmail = userEmail;
    }
}
