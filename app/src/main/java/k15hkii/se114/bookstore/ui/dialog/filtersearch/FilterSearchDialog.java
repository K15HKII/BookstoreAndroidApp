package k15hkii.se114.bookstore.ui.dialog.filtersearch;

import android.app.Dialog;
import android.os.Bundle;
import android.view.*;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.databinding.FilterSearchDialogBinding;
import k15hkii.se114.bookstore.di.component.DialogComponent;
import k15hkii.se114.bookstore.ui.base.BaseDialog;
import k15hkii.se114.bookstore.ui.book.search.SearchBookViewResult;

import javax.inject.Inject;

public class FilterSearchDialog extends BaseDialog implements FilterSearchCallBack {

    private static final String TAG = "FilterSearchDialog";

    @Inject
    FilterSearchViewModel filterSearchViewModel;

    public static FilterSearchDialog newInstance() {
        FilterSearchDialog fragment = new FilterSearchDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FilterSearchDialogBinding binding = DataBindingUtil.inflate(inflater, R.layout.filter_search_dialog, container, false);
        View view = binding.getRoot();

        binding.setViewModel(filterSearchViewModel);
        filterSearchViewModel.setNavigator(this);

//        this.getDialog().setCanceledOnTouchOutside(true);

        Dialog dlg = this.getDialog();
        Window window = dlg.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.TOP;

        SeekBar skPrice = binding.skbarFilterSearchPrice;
        TextView tvPrice = binding.tvFilterSearchPrice;
        skPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvPrice.setText("" + String.format("%,.0f", (double) i) + "đ - 2.000.000đ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

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

    @Override
    public void openSearchResult() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, SearchBookViewResult.class, null).setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).addToBackStack(null).commit();
        dismissDialog(TAG);
    }

}
