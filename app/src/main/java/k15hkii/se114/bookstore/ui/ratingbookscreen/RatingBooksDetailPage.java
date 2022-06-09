package k15hkii.se114.bookstore.ui.ratingbookscreen;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.RatingDetailBooksViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.utils.Consumer;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.LinkedList;

public class RatingBooksDetailPage extends BaseFragment<RatingDetailBooksViewFragmentBinding, RateDetailViewModel> implements RatingBooksDetailPageNavigator {

    private final LinkedList<Consumer<Uri>> callbacks = new LinkedList<>();
    private final ActivityResultLauncher<String> GetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            uri -> {
                while (!callbacks.isEmpty())
                    callbacks.remove().accept(uri);
            });

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.rating_detail_books_view_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        RatingDetailBooksViewFragmentBinding ratingDetailBooksViewFragmentBinding = getViewDataBinding();
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
