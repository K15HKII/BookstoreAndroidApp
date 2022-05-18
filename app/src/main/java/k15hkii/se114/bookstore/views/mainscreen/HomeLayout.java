package k15hkii.se114.bookstore.views.mainscreen;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import k15hkii.se114.bookstore.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeLayout extends Fragment {

    private HomeLayoutViewModel mViewModel;

    public static HomeLayout newInstance() {
        return new HomeLayout();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_navigation_layout, container, false);

        View navView = view.findViewById(R.id.navView);

        BottomNavigationView navBottomNavigation = view.findViewById(R.id.BotNavi);
        NavController ctrl = Navigation.findNavController(navView);
        NavigationUI.setupWithNavController(navBottomNavigation, ctrl);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeLayoutViewModel.class);
        // TODO: Use the ViewModel
    }

}
