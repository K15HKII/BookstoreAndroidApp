package k15hkii.se114.bookstore.ui.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.databinding.NotificationPageFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.book.rating.RatingBooksDetailPage;
import k15hkii.se114.bookstore.ui.notification.adapter.NotificationViewAdapter;
import k15hkii.se114.bookstore.ui.voucher.VoucherPage;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class NotificationPage extends BaseFragment<NotificationPageFragmentBinding, NotificationPageViewModel> implements NotificationPageNavigator {

    @Inject
    protected NotificationViewAdapter notificationAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.notification_page_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        NotificationPageFragmentBinding notificationPageFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);
        notificationAdapter.setPageNavigator(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NotificationPage.this.getContext());
        notificationPageFragmentBinding.rcvNotificationView.setLayoutManager(linearLayoutManager);
        notificationPageFragmentBinding.rcvNotificationView.setAdapter(notificationAdapter);
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
    public void openVoucherPage() {
        createTransaction(R.id.fragmentContainerView, VoucherPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void childNavigate(Object object) {
        if (object instanceof Book) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("book", (Book) object);
            createTransaction(R.id.fragmentContainerView, RatingBooksDetailPage.class, bundle)
                    .setCustomAnimations(
                            R.anim.slide_in,  // enter
                            R.anim.fade_out,  // exit
                            R.anim.fade_in,   // popEnter
                            R.anim.slide_out  // popExit
                    ).commit();
        }
    }

}
