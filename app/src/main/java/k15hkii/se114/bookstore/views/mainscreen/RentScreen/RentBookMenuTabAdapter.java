package k15hkii.se114.bookstore.views.mainscreen.RentScreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import k15hkii.se114.bookstore.views.mainscreen.RentScreen.menutab.RentedViewPage;
import k15hkii.se114.bookstore.views.mainscreen.RentScreen.menutab.RentingViewPage;
import org.jetbrains.annotations.NotNull;

public class RentBookMenuTabAdapter extends FragmentStatePagerAdapter {


    public RentBookMenuTabAdapter(@NonNull @NotNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new RentingViewPage();
            case 1:
                return new RentedViewPage();
            default:
                return new RentingViewPage();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Đang thuê";
                break;
            case 1:
                title = "Đã thuê";
                break;
        }
        return title;
    }
}
