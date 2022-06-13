package k15hkii.se114.bookstore.ui.dialog.emptycart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.EmptyCartDialogBinding;
import k15hkii.se114.bookstore.databinding.ErrorDataDialogBinding;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.ui.base.BaseDialog;
import k15hkii.se114.bookstore.ui.dialog.errordata.ErrorDataDialog;

import javax.inject.Inject;

public class EmptyCartDialog extends BaseDialog implements EmptyCartNavigator {

    private static final String TAG = "EmptyCartDialog";

    @Inject protected EmptyCartViewModel emptyCartViewModel;

    public static EmptyCartDialog newInstance() {
        EmptyCartDialog fragment = new EmptyCartDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    public static EmptyCartDialog newInstance(FragmentManager supportFragmentManager, Bundle bundle) {
        EmptyCartDialog fragment = new EmptyCartDialog();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EmptyCartDialogBinding binding = DataBindingUtil.inflate(inflater, R.layout.empty_cart_dialog, container, false);
        View view = binding.getRoot();
        binding.setViewModel(emptyCartViewModel);
        emptyCartViewModel.setNavigator(this);
        this.getDialog().setCanceledOnTouchOutside(true);
        return view;
    }

    @Override
    public void performDependencyInjection(DialogComponent buildComponent) {
        buildComponent.inject(this);
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    @Override
    public void dismissDialog() {
        dismissDialog(TAG);
    }
}
