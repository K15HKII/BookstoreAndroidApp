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
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.viewmodel.RatingBooksViewViewModel;

import java.util.ArrayList;
import java.util.List;

public class RatingBooksDetailPage extends Fragment {

    private RatingBooksViewViewModel mViewModel;
    private RecyclerView rcvRatingReport;
    private RatingReportAdapter ratingReportAdapter;

    public static RatingBooksDetailPage newInstance() {
        return new RatingBooksDetailPage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rating_detail_books_view_fragment, container, false);
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RatingBooksViewViewModel.class);
        // TODO: Use the ViewModel
    }

}