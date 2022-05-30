package k15hkii.se114.bookstore.ui.bookdetailscreen;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.BookDetailViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.dialog.buynow.BuyNowDialog;
import k15hkii.se114.bookstore.ui.dialog.oncart.OnCartDialog;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class BookDetailPage extends BaseFragment<BookDetailViewFragmentBinding, BookDetailPageViewModel> implements BookDetailPageNavigator {
    @Inject protected CommentViewAdapter commentViewAdapter;

    public static BookDetailPage newInstance() {
        return new BookDetailPage();
    }

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
        BookDetailViewFragmentBinding bookDetailViewFragmentBinding = getViewDataBinding();
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
    public void openBuyNowDialog() {
        BuyNowDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }

    @Override
    public void openOnCartDialog() {
        OnCartDialog.newInstance().show(getActivity().getSupportFragmentManager());
    }
}