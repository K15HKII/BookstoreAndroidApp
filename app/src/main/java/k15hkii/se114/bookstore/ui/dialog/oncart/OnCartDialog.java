package k15hkii.se114.bookstore.ui.dialog.oncart;

import android.app.Dialog;
import android.os.Bundle;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.databinding.OncartSelectorDialogBinding;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.ui.base.BaseDialog;

import javax.inject.Inject;

public class OnCartDialog extends BaseDialog implements OnCartCallBack {

    private static final String TAG = "OnCartDialog";

    @Inject
    OnCartViewModel onCartViewModel;

    private Book book;

    public static OnCartDialog newInstance(Book book) {
        OnCartDialog fragment = new OnCartDialog();
        fragment.book = book;
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        OncartSelectorDialogBinding binding = DataBindingUtil.inflate(inflater, R.layout.oncart_selector_dialog, container, false);
        View view = binding.getRoot();

        binding.setViewModel(onCartViewModel);
        onCartViewModel.setNavigator(this);

        this.getDialog().setCanceledOnTouchOutside(true);

        Dialog dlg = this.getDialog();
        Window window = dlg.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.BOTTOM;

        onCartViewModel.setData(book);

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    public void performDependencyInjection(DialogComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void dismissDialog() {
        dismissDialog(TAG);
    }

}
