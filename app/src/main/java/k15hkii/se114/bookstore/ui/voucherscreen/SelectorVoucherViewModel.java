package k15hkii.se114.bookstore.ui.voucherscreen;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.ui.ViewModelMapper;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.voucherscreen.adapterSelect.VoucherItemAdapterViewModel;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import java.util.UUID;

public class SelectorVoucherViewModel extends BaseViewModel<SelectorVoucherNavigator> {

    public final ObservableList<VoucherItemAdapterViewModel> items = new ObservableArrayList<VoucherItemAdapterViewModel>() {{

        addOnListChangedCallback(new OnListChangedCallback() {
            @Override
            public void onChanged(ObservableList sender) {

            }

            @Override
            public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {

            }

            @Override
            public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
                for (int i = positionStart; i < positionStart + itemCount; i++) {
                    VoucherItemAdapterViewModel item = get(i);
                    item.isSelected.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
                        @Override
                        public void onPropertyChanged(Observable sender, int propertyId) {
                            if (item.isSelected.get()) {
                                for (VoucherItemAdapterViewModel vm : items) {
                                    if (vm == item)
                                        continue;
                                    vm.isSelected.set(false);
                                }
                            }
                        }
                    });
                }
            }

            @Override
            public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {

            }

            @Override
            public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {

            }
        });

    }};

    @Inject
    protected ViewModelMapper mapper;

    private final UUID userId;

    public void getData() {
        dispose(mapper.getSelectVouchers(userId),
                items -> {
                    this.items.addAll(items);
                    if (this.items.size() > 0)
                        this.items.get(0).isSelected.set(true);
                },
                throwable -> Log.d("SelectVoucherViewModel", "getData: " + throwable.getMessage(), throwable));
    }

    public SelectorVoucherViewModel(SchedulerProvider schedulerProvider, ViewModelMapper mapper, PreferencesHelper helper) {
        super(schedulerProvider);
        this.mapper = mapper;
        this.userId = helper.getCurrentUserId();
        getData();
    }

    public VoucherItemAdapterViewModel getSelectedVoucher() {
        for (VoucherItemAdapterViewModel vm : items) {
            if (vm.isSelected.get())
                return vm;
        }
        return null;
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void acceptClick() {
        getNavigator().accept();
    }

}
