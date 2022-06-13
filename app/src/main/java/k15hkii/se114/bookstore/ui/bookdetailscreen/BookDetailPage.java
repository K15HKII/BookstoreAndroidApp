package k15hkii.se114.bookstore.ui.bookdetailscreen;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.databinding.BookDetailViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.dialog.buynow.BuyNowDialog;
import k15hkii.se114.bookstore.ui.dialog.oncart.OnCartDialog;
import k15hkii.se114.bookstore.ui.dialog.soldout.SoldOutDialog;
import k15hkii.se114.bookstore.ui.ratingbookscreen.RatingBooksDetailPage;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class BookDetailPage extends BaseFragment<BookDetailViewFragmentBinding, BookDetailPageViewModel> implements BookDetailPageNavigator {
    @Inject protected CommentViewAdapter commentViewAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.book_detail_view_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        BookDetailViewFragmentBinding binding = getViewDataBinding();
        viewModel.setNavigator(this);
        binding.rcvBookDetailComments.setAdapter(commentViewAdapter);

        Bundle bundle = this.getArguments();
        Book book = (Book) bundle.getSerializable("book");
        viewModel.setBook(book);

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
    public void openBuyNowDialog(Book book) {
//
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("book", book);

        BuyNowDialog dialog = BuyNowDialog.newInstance(book);
        dialog.show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openOnCartDialog(Book book) {
        OnCartDialog dialog = OnCartDialog.newInstance(book);
        dialog.show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openSoldOutDialog() {
        SoldOutDialog dialog = SoldOutDialog.newInstance();
        dialog.show(getActivity().getSupportFragmentManager());
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                dialog.dismissDialog();
            }
        }, 500);
    }
}
