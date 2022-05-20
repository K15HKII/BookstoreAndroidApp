package k15hkii.se114.bookstore.views.ratingbookscreen;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.RatingDetailBooksViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class RatingBooksDetailPage extends BaseFragment<RatingDetailBooksViewFragmentBinding, RatingBooksDetailPageViewModel> implements RatingBooksDetailPageNavigator {

    private RatingDetailBooksViewFragmentBinding ratingDetailBooksViewFragmentBinding;
    private RatingBooksDetailPageViewModel mViewModel;
    private RecyclerView rcvRatingReport;
    private RatingReportAdapter ratingReportAdapter;

    public static RatingBooksDetailPage newInstance() {
        return new RatingBooksDetailPage();
    }

    @Override
    public int getBindingVariable() {
        return BR.RatingDetailBookViewViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.rating_detail_books_view_fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ratingDetailBooksViewFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        rcvRatingReport = view.findViewById(R.id.rcvRatingReportViewBooks);

        List<RatingReport> lsratingrp = new ArrayList<>();
        lsratingrp.add(new RatingReport("Sách công nghệ"));
        lsratingrp.add(new RatingReport("Đắc Nhân Tâm"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RatingBooksDetailPage.this.getContext(),RecyclerView.VERTICAL,false);
        RatingReportAdapter ratingReportAdapter = new RatingReportAdapter(lsratingrp, RatingBooksDetailPage.this.getContext());

        rcvRatingReport.setLayoutManager(linearLayoutManager);
        rcvRatingReport.setAdapter(ratingReportAdapter);

        return view;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RatingBooksDetailPageViewModel.class);
        // TODO: Use the ViewModel
    }

}
