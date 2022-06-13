package k15hkii.se114.bookstore.ui.oncartscreen;

import android.util.Log;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableDouble;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.BR;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItem;
import k15hkii.se114.bookstore.data.prefs.PreferencesHelper;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OncartViewViewModel extends BaseViewModel<OncartViewPageNavigator> implements Observable {

    public final ObservableField<List<OncartItemViewModel>> items = new ObservableField<>();

    public final ObservableDouble totalPrice = new ObservableDouble();

    @Inject
    protected ModelRemote remote;
    public UUID userId;

    private boolean selectAll = false;

    @Bindable
    public boolean isSelectAll() {
        return selectAll;
    }

    public void setSelectAll(boolean selectAll) {
        if (selectAll == this.selectAll) {
            return;
        }
        this.selectAll = selectAll;
        for (OncartItemViewModel vm : items.get()) {
            vm.isSelectedItem.set(selectAll);
        }
    }

    public void getData() {
        dispose(remote.getCarts(userId),
                cartItems -> {
                    totalPrice.set(0d);
                    List<OncartItemViewModel> list = new ArrayList<>();
                    int selectCount = 0;
                    for (CartItem cartItem : cartItems) {
                        OncartItemViewModel vm = new OncartItemViewModel(getSchedulerProvider(), remote);
                        vm.setCartItem(cartItem);
                        vm.getDeleteCallbacks().add(this::getData);
                        vm.getUpdateCallbacks().add(() -> {
                            totalPrice.set(0);
                            int selectCount2 = 0;
                            for (OncartItemViewModel temp : items.get()) {
                                if (temp.isSelectedItem.get()) {
                                    totalPrice.set(totalPrice.get() + temp.price.get());
                                    selectCount2++;
                                }
                            }
                            if (selectCount2 == this.items.get().size()) {
                                selectAll = true;
                            } else {
                                selectAll = false;
                            }
                            notifyPropertyChanged(BR.selectAll);
                        });
                        list.add(vm);


                        if (cartItem.isSelected()) {
                            selectCount++;
                            dispose(remote.getBook(cartItem.getBookId()),
                                    book -> {
                                        totalPrice.set((book.getPrice() * cartItem.getQuantity()) + totalPrice.get());
                                    },
                                    throwable -> {
                                    });
                        }
                    }
                    if (selectCount == list.size()) {
                        selectAll = true;
                    } else {
                        selectAll = false;
                    }
                    notifyPropertyChanged(BR.selectAll);
                    items.set(list);
                },
                throwable -> {
                });
    }

    public OncartViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote,
                               PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.remote = remote;
        this.userId = preferencesHelper.getCurrentUserId();
        totalPrice.set(0d);
        getData();
    }

    public void onBackWardClick() {
        getNavigator().BackWard();
    }

    public void openOrderPage() {
        if(totalPrice.get() == 0){
            getNavigator().openMissingDialog("Vui lòng chọn sách trước khi đặt hàng");
            return;
        }
        List<OncartItemViewModel> selected = new ArrayList<>();
        for (OncartItemViewModel vm : items.get()) {
            if (vm.isSelectedItem.get()) {
                selected.add(vm);
            }
        }
        getNavigator().OrderPageNavigator(this, selected);
    }

}
