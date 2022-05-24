package k15hkii.se114.bookstore.views.dialog.oncart;

import android.app.Dialog;
import android.os.Bundle;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.BookstoreApp;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.BuynowSelectorDialogBinding;
import k15hkii.se114.bookstore.databinding.OncartSelectorDialogBinding;
import k15hkii.se114.bookstore.di.component.DaggerDialogComponent;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.di.module.DialogModule;
import k15hkii.se114.bookstore.viewmodel.base.BaseDialog;
import k15hkii.se114.bookstore.views.dialog.buynow.BuyNowDialog;
import k15hkii.se114.bookstore.views.dialog.buynow.BuyNowViewModel;

import javax.inject.Inject;

public class OnCartDialog extends BaseDialog implements OnCartCallBack {
    private static final String TAG = "OnCartDialog";

    @Inject
    OnCartViewModel onCartViewModel;

    public static OnCartDialog newInstance() {
        OnCartDialog fragment = new OnCartDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        OncartSelectorDialogBinding binding = DataBindingUtil.inflate( inflater, R.layout.oncart_selector_dialog, container, false);
        View view =binding.getRoot();

        performDependencyInjection(getBuildComponent());

        binding.setViewModel(onCartViewModel);
        onCartViewModel.setNavigator(this);

        this.getDialog().setCanceledOnTouchOutside(true);

        Dialog dlg = this.getDialog();
        Window window = dlg.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.BOTTOM;

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    private DialogComponent getBuildComponent(){
        return DaggerDialogComponent.builder()
                .appComponent(((BookstoreApp)(getContext().getApplicationContext())).getAppComponent())
                .dialogModule(new DialogModule(this))
                .build();
    }

    private void performDependencyInjection(DialogComponent buildComponent){
        buildComponent.inject(this);
    }

    @Override
    public void dismissDialog() {
        dismissDialog(TAG);
    }
}
