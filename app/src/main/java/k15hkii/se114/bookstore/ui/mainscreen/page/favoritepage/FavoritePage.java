package k15hkii.se114.bookstore.ui.mainscreen.page.favoritepage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.FavoritePageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.mainscreen.navigator.BookViewAdapter;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class FavoritePage extends BaseFragment<FavoritePageFragmentBinding, FavoritePageViewModel> implements FavoritePageNavigator {

    @Inject
    protected BookViewAdapter bookViewAllAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.favorite_page_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        FavoritePageFragmentBinding favoritePageFragmentBinding = getViewDataBinding();

        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity(), 2);
        favoritePageFragmentBinding.lvLoveAllBook.setLayoutManager(gridLayoutManager2);
        favoritePageFragmentBinding.lvLoveAllBook.setAdapter(bookViewAllAdapter);
        viewModel.setNavigator(this);
        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }


    @Override
    public void BackWard() {
        getFragmentManager().popBackStack();
    }

}
