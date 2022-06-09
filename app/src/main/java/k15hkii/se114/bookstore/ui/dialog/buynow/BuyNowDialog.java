package k15hkii.se114.bookstore.ui.dialog.buynow;

import android.app.Dialog;
import android.os.Bundle;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.databinding.BuynowSelectorDialogBinding;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.ui.base.BaseDialog;
import k15hkii.se114.bookstore.ui.oncartscreen.OncartViewPage;

import javax.inject.Inject;

public class BuyNowDialog extends BaseDialog implements BuyNowCallBack{
    private static final String TAG = "BuyNowDialog";

    @Inject
    protected BuyNowViewModel buyNowViewModel;

    private Book book;

    public static BuyNowDialog newInstance(Book book) {
        BuyNowDialog fragment = new BuyNowDialog();
        fragment.book = book;
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BuynowSelectorDialogBinding binding = DataBindingUtil.inflate( inflater, R.layout.buynow_selector_dialog, container, false);
        View view =binding.getRoot();

        binding.setViewModel(buyNowViewModel);
        buyNowViewModel.setNavigator(this);

        this.getDialog().setCanceledOnTouchOutside(true);

        Dialog dlg = this.getDialog();
        Window window = dlg.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.BOTTOM;

        //get bundle
//        Bundle bundle = this.getArguments();
//        Book book = (Book) bundle.getSerializable("book");
        buyNowViewModel.setData(book);

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    public void performDependencyInjection(DialogComponent buildComponent){
        buildComponent.inject(this);
    }

    @Override
    public void dismissDialog() {
        dismissOnlyDialog();
    }

    @Override
    public void openCartPage() {
        //todo: truyen book

//        Bundle bundle = new Bundle();
//        bundle.putSerializable("book", book);
//        bundle.putInt("quantity", amount);

        getParentFragmentManager().beginTransaction()
                                  .replace(R.id.fragmentContainerView, OncartViewPage.class, null)
                                  .addToBackStack(null)
                                  .setCustomAnimations(
                                          R.anim.slide_in,  // enter
                                          R.anim.fade_out,  // exit
                                          R.anim.fade_in,   // popEnter
                                          R.anim.slide_out  // popExit
                                  ).commit();
    }
}
