package k15hkii.se114.bookstore.ui.oncartscreen;

import android.util.Log;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.Book;
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

    public final ObservableField<Double> totalPrice = new ObservableField<>();

    @Inject
    protected ModelRemote remote;
    private UUID userId;
    private Book book;
    private double total;

    public void getData(UUID userId) {

        total = 0d;

        getCompositeDisposable().add(remote.getCarts(userId)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(cartItems -> {
                    List<OncartItemViewModel> list = new ArrayList<>();
                    List<OncartItemViewModel> selectedItemList = new ArrayList<>();
                    for (CartItem cartItem : cartItems) {
                        OncartItemViewModel model = new OncartItemViewModel(getSchedulerProvider(), remote);
                        model.setCartItem(cartItem);
                        list.add(model);

//                        if(cartItem.isSelected()) {
//                            OncartItemViewModel vm = new OncartItemViewModel(getSchedulerProvider(), remote);
//                            vm.setCartItem(cartItem);
//                            selectedItemList.add(vm);
//                            total += Double.parseDouble(vm.price.get());
//                        }
                    }
                    totalPrice.set(total);
                    items.set(list);
                }, throwable -> {
                    Log.d("OncartViewViewModel", "getData: " + throwable.getMessage(), throwable);
                }));
    }

    public OncartViewViewModel(SchedulerProvider schedulerProvider, ModelRemote remote, PreferencesHelper preferencesHelper) {
        super(schedulerProvider);
        this.remote = remote;
        this.userId = preferencesHelper.getCurrentUserId();
        totalPrice.set(0d);
        getData(userId);
    }

    public void onBackWardClick(){
        getNavigator().BackWard();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    // TODO: Implement the ViewModel
}
