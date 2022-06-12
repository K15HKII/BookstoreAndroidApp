package k15hkii.se114.bookstore.ui.bankscreen;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import k15hkii.se114.bookstore.data.model.api.user.UserBankCRUDRequest;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;
import k15hkii.se114.bookstore.ui.base.INavigator;
import k15hkii.se114.bookstore.utils.rx.SchedulerProvider;

import java.util.Arrays;
import java.util.List;

public class BaseBankUpdateViewModel<N extends INavigator> extends BaseViewModel<N> {

    public final ObservableField<List<String>> bankDb = new ObservableField<>(Arrays.asList(
            "Vietcombank",
            "Techcombank",
            "BIDV",
            "VietinBank",
            "Agribank",
            "DongA",
            "MaritimeBank",
            "BaoVietBank"
    ));

    public final ObservableField<String> bankName = new ObservableField<>();
    public final ObservableField<String> iban = new ObservableField<>();
    public final ObservableField<String> bic = new ObservableField<>();

    public final ObservableBoolean isPrimary = new ObservableBoolean(false);

    public UserBankCRUDRequest toRequest() {
        UserBankCRUDRequest requset = new UserBankCRUDRequest();

        requset.setBankName(bankName.get());
        requset.setIban(iban.get());
        requset.setBic(bic.get());
        requset.setPrimary(isPrimary.get());

        return requset;
    }

    public BaseBankUpdateViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

}
