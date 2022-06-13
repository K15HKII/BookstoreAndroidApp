package k15hkii.se114.bookstore.ui.mainscreen.rentscreen;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.RentedViewPage;
import k15hkii.se114.bookstore.ui.mainscreen.rentscreen.menutab.RentingViewPage;
import org.jetbrains.annotations.NotNull;

public class RentBookMenuTabAdapter extends FragmentStateAdapter {


    public RentBookMenuTabAdapter(@NonNull @NotNull FragmentManager fm, Lifecycle lifecycle) {
        super(fm, lifecycle);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new RentingViewPage();
            case 1:
                return new RentedViewPage();
            default:
                return new RentingViewPage();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
