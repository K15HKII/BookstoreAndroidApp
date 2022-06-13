package k15hkii.se114.bookstore.ui.news;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import k15hkii.se114.bookstore.ui.news.explorer.Explorer;
import k15hkii.se114.bookstore.ui.news.follow.Follow;
import k15hkii.se114.bookstore.ui.news.popularnews.PopularNews;
import org.jetbrains.annotations.NotNull;

public class NewsMenuTab extends FragmentStateAdapter {

    public NewsMenuTab(@NonNull @NotNull FragmentManager fm, Lifecycle lifecycle) {
        super(fm, lifecycle);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new Follow();
            case 2:
                return new PopularNews();
            default:
                return new Explorer();
        }
    }

}
