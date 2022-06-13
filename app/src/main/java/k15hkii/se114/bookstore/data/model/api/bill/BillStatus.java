package k15hkii.se114.bookstore.data.model.api.bill;

import k15hkii.se114.bookstore.data.model.ISubEnum;

import java.util.Locale;

public enum BillStatus implements ISubEnum {

    WAITING("Chờ xác nhận")
    ,TRANSPORTING("Đang vận chuyển")
    ,COMPLETED("Đã vận chuyển")
    ,CANCELED("Đã hủy");

    private final String sub;

    BillStatus(String sub) {
        this.sub = sub;
    }

    @Override
    public String toDefaultLocale() {
        return sub;
    }

    @Override
    public String toLocale(Locale locale) {
        return sub;
    }
}
