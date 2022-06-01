package k15hkii.se114.bookstore.ui.oncartscreen;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.CartItem;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class OncartViewViewModel extends BaseViewModel<OncartViewPageNavigator> implements Observable {

    public final ObservableField<List<OncartItemViewModel>> listOncart = new ObservableField<>(
            Arrays.asList(new OncartItemViewModel("Sách Đắc Nhân Tâm"),
                          new OncartItemViewModel("Sách Công Nghệ"))
    );

    @Inject
    protected ModelRemote remote;

    private List<CartItem> cartItems;

    public void getCardItems(String userId) {

        remote.getCartitems(userId).doOnSuccess(cartItemList -> {
            cartItems = cartItemList;
        }).subscribe();
    }

    public OncartViewViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
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
