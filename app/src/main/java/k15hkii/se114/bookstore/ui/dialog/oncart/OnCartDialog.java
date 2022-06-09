package k15hkii.se114.bookstore.ui.dialog.oncart;

import android.app.Dialog;
import android.os.Bundle;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.BookstoreApp;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.OncartSelectorDialogBinding;
import k15hkii.se114.bookstore.di.component.DaggerDialogComponent;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.di.module.DialogModule;
import k15hkii.se114.bookstore.ui.base.BaseDialog;

import javax.inject.Inject;

public class OnCartDialog extends BaseDialog implements OnCartCallBack {
    private static final String TAG = "OnCartDialog";
    private int amount = 0;

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

        binding.setViewModel(onCartViewModel);
        onCartViewModel.setNavigator(this);

        this.getDialog().setCanceledOnTouchOutside(true);

        Dialog dlg = this.getDialog();
        Window window = dlg.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.BOTTOM;

        binding.btnPutToCartDialogPlusAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(amount == 0){
                    return;
                }
                else{
                    amount++;
                    binding.tvPutToCartDialogAmount.setText(amount+"");
                }
            }
        });

        binding.btnPutToCartDialogMinusAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(amount == 0){
                    return;
                }
                else {
                    amount--;
                    binding.tvPutToCartDialogAmount.setText(amount + "");
                }
            }
        });

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
        dismissDialog(TAG);
    }
}
