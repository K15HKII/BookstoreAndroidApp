package k15hkii.se114.bookstore.ui.ratingbookscreen;

import android.net.Uri;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.utils.Consumer;

public interface IRatingReportAdapterNavigator extends INavigator {
    void getPicture(RatingReportViewModel viewModel);

    void getPicture(Consumer<Uri> callback);

}
