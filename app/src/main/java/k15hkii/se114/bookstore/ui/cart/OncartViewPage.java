package k15hkii.se114.bookstore.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.OncartViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.book.detail.BookDetailPage;
import k15hkii.se114.bookstore.ui.dialog.emptycart.EmptyCartDialog;
import k15hkii.se114.bookstore.ui.order.confirm.OrderInfoPage;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class OncartViewPage extends BaseFragment<OncartViewFragmentBinding, OncartViewViewModel> implements OncartViewPageNavigator, OncartItemNavigator {

    @Inject
    protected OncartItemAdapter oncartItemAdapter;

    @Inject
    protected OncartViewViewModel viewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.oncart_view_fragment;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        OncartViewFragmentBinding binding = getViewDataBinding();
        viewModel.setNavigator(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        binding.lvOnCartViewListItems.setLayoutManager(linearLayoutManager);
        binding.lvOnCartViewListItems.setAdapter(oncartItemAdapter);

        oncartItemAdapter.setOncartItemNavigator(this);

//        oncartViewFragmentBinding.lvOnCartViewListItems.post(() -> oncartItemAdapter.notifyDataSetChanged());

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
    public void openBookDetailNavigator(OncartItemViewModel vm) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("book", vm.getBook());
        createTransaction(R.id.fragmentContainerView, BookDetailPage.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void OrderPageNavigator(OncartViewViewModel viewModel, List<OncartItemViewModel> selecteds) {

        Bundle bundle = new Bundle();
        ArrayList<OncartItemViewModel> temp = new ArrayList<>(selecteds);
        bundle.putSerializable("orderList", temp);
        bundle.putSerializable("userId", viewModel.userId);

        createTransaction(R.id.fragmentContainerView, OrderInfoPage.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void openEmptyCart(String error) {
        Bundle bundle = new Bundle();
        bundle.putString("error", error);
        EmptyCartDialog.newInstance(getActivity().getSupportFragmentManager(), bundle).
                show(getActivity().getSupportFragmentManager());
    }

}
