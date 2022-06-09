package k15hkii.se114.bookstore.ui.bookdetailscreen;

import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.ui.base.INavigator;

public interface BookDetailPageNavigator extends INavigator {
    void BackWard();

    void openBuyNowDialog(Book book);

    void openOnCartDialog(Book book);

    void openRatingBook();
}
