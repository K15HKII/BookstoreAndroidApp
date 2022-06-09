package k15hkii.se114.bookstore.ui.dialog.buynow;

import android.app.Dialog;
import android.os.Bundle;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import k15hkii.se114.bookstore.BookstoreApp;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.BuynowSelectorDialogBinding;
import k15hkii.se114.bookstore.di.component.DaggerDialogComponent;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.di.module.DialogModule;
import k15hkii.se114.bookstore.ui.base.BaseDialog;

import javax.inject.Inject;

public class BuyNowDialog extends BaseDialog implements BuyNowCallBack{
    private static final String TAG = "BuyNowDialog";
    private int amount = 0;

    @Inject
    BuyNowViewModel buyNowViewModel;

    public static BuyNowDialog newInstance() {
        BuyNowDialog fragment = new BuyNowDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        BuynowSelectorDialogBinding binding = DataBindingUtil.inflate( inflater, R.layout.buynow_selector_dialog, container, false);
        View view =binding.getRoot();

        performDependencyInjection(getBuildComponent());

        binding.setViewModel(buyNowViewModel);
        buyNowViewModel.setNavigator(this);

        this.getDialog().setCanceledOnTouchOutside(true);

        Dialog dlg = this.getDialog();
        Window window = dlg.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.BOTTOM;

        binding.btnBuyNowPlusAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(amount == 0){
                    return;
                }
                else{
                    amount++;
                    binding.tvBuyNowAmount.setText(amount+"");
                }
            }
        });

        binding.btnBuyNowMinusAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(amount == 0){
                    return;
                }
                else {
                    amount--;
                    binding.tvBuyNowAmount.setText(amount + "");
                }
            }
        });

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
