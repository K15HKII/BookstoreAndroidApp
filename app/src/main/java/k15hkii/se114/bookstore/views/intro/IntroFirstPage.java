package k15hkii.se114.bookstore.views.intro;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.viewmodel.IntroFirstPageViewModel;

public class IntroFirstPage extends Fragment {

    private IntroFirstPageViewModel mViewModel;

    public static IntroFirstPage newInstance() {
        return new IntroFirstPage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intro_first_page_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(IntroFirstPageViewModel.class);
        // TODO: Use the ViewModel
    }

}
