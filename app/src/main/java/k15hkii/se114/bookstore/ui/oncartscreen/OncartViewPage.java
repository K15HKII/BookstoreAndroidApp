package k15hkii.se114.bookstore.ui.oncartscreen;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.OncartViewFragmentBinding;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.ui.base.BaseFragment;
import k15hkii.se114.bookstore.ui.bookdetailscreen.BookDetailPage;
import k15hkii.se114.bookstore.ui.orderinfoscreen.orderConfirm.OrderInfoPage;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class OncartViewPage extends BaseFragment<OncartViewFragmentBinding, OncartViewViewModel> implements OncartViewPageNavigator, OncartItemNavigator {
    @Inject
    protected OncartItemAdapter oncartItemAdapter;

    OncartViewFragmentBinding oncartViewFragmentBinding;

    @Inject protected OncartViewViewModel viewModel;

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

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        oncartViewFragmentBinding = getViewDataBinding();
        viewModel.setNavigator(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        oncartViewFragmentBinding.lvOnCartViewListItems.setLayoutManager(linearLayoutManager);
        oncartViewFragmentBinding.lvOnCartViewListItems.setAdapter(oncartItemAdapter);
//        oncartItemAdapter.notifyDataSetChanged();

        oncartViewFragmentBinding.lvOnCartViewListItems.post(() -> oncartItemAdapter.notifyDataSetChanged());

        oncartItemAdapter.setOncartItemNavigator(this);

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
        bundle.putSerializable("book",vm.getBook());
        createTransaction(R.id.fragmentContainerView, BookDetailPage.class, bundle)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @Override
    public void OrderPageNavigate() {
        createTransaction(R.id.fragmentContainerView, OrderInfoPage.class, null)
                .setCustomAnimations(
                        R.anim.slide_in,  // enter
                        R.anim.fade_out,  // exit
                        R.anim.fade_in,   // popEnter
                        R.anim.slide_out  // popExit
                ).commit();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void checkItemHandle() {
//        oncartViewFragmentBinding.lvOnCartViewListItems.post(() -> oncartItemAdapter.notifyDataSetChanged());
    }

    //    @Override
//    public void resetView() {
//        oncartItemAdapter.notifyDataSetChanged();
//    }

    //    @Override
//    public void deleteItem(int index) {
//        oncartViewFragmentBinding.lvOnCartViewListItems.removeViewAt(index);
//        oncartItemAdapter.notifyItemRemoved(index);
//    }
}
