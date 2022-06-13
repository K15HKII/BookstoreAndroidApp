package k15hkii.se114.bookstore.ui.book.rating;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.RatingDetailBooksViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class RatingBooksDetailPage extends BaseFragment<RatingDetailBooksViewFragmentBinding, RateDetailViewModel> implements RatingBooksDetailPageNavigator {

    public RateDetailViewModel getViewModel() {
        return viewModel;
    }

    @Inject
    protected MediaViewAdapter adapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    private LifecycleObserve mObserver;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mObserver = new LifecycleObserve(requireActivity().getActivityResultRegistry());
        getLifecycle().addObserver(mObserver);
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
        RatingDetailBooksViewFragmentBinding binding = getViewDataBinding();

        adapter.setNavigator(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        binding.rvImages.setLayoutManager(gridLayoutManager);
        binding.rvImages.setAdapter(adapter);

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

    @Override
    public void selectImages() {
        mObserver.selectImage();
    }

}
