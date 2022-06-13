package k15hkii.se114.bookstore.ui.mainscreen.page.homepage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.all.AllBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.familiar.FamiliarBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.foryou.ForYouBooksPage;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.popular.PopularBooksPage;
import org.jetbrains.annotations.NotNull;

public class HomeMenuTab extends FragmentStateAdapter {

    public HomeMenuTab(@NonNull @NotNull FragmentManager fm, Lifecycle lifecycle) {
        super(fm, lifecycle);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new PopularBooksPage();
            case 2:
                return new FamiliarBooksPage();
            case 3:
                return new ForYouBooksPage();
            default:
                return new AllBooksPage();
        }
    }

}
