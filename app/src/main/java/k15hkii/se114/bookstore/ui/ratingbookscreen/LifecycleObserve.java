package k15hkii.se114.bookstore.ui.ratingbookscreen;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import k15hkii.se114.bookstore.utils.RemoteUtils;

public class LifecycleObserve implements DefaultLifecycleObserver {

    private final ActivityResultRegistry mRegistry;
    private ActivityResultLauncher<String> mGetContent;

    LifecycleObserve(@NonNull ActivityResultRegistry registry) {
        mRegistry = registry;
    }

    public void onCreate(@NonNull LifecycleOwner owner) {
        // ...

        mGetContent = mRegistry.register("imageSelector", owner, new ActivityResultContracts.GetContent(),
                uri -> {
                    if (owner instanceof RatingBooksDetailPage) {
                        RatingBooksDetailPage page = (RatingBooksDetailPage) owner;
                        FragmentActivity activity = page.getActivity();
                        page.getViewModel().selectImages(uri, RemoteUtils.from(activity, activity.getContentResolver(), uri));
                    }
                });
    }

    public void selectImage() {
        // Open the activity to select an image
        mGetContent.launch("image/*");
    }

}
