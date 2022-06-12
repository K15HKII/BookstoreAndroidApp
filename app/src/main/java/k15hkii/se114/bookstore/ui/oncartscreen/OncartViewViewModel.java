package k15hkii.se114.bookstore.ui.oncartscreen;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableDouble;
import androidx.databinding.ObservableField;
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

    List<OncartItemViewModel> selectedItemList = new ArrayList<>();
    public List<OncartItemViewModel> list = new ArrayList<>();

    public void getData() {
        dispose(remote.getCarts(userId),
                cartItems -> {
                    totalPrice.set(0d);
                    OncartItemViewModel.resetCounter();
                    list.clear();
                    for (CartItem cartItem : cartItems) {
                        OncartItemViewModel vm = new OncartItemViewModel(getSchedulerProvider(), remote);
                        vm.setCartItem(cartItem);
                        list.add(vm);

                        if (cartItem.isSelected()) {
                            selectedItemList.add(vm);
                            dispose(remote.getBook(cartItem.getBookId()),
                                    book -> {
                                        totalPrice.set((book.getPrice() * cartItem.getQuantity()) + totalPrice.get());
                                    },
                                    throwable -> {
                                    });
                        }
                    }
                    items.set(list);
                },
                throwable -> { });
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
        getNavigator().OrderPageNavigator(this);
    }

}
