package k15hkii.se114.bookstore.data.model.api.voucher;

import k15hkii.se114.bookstore.data.model.ISubEnum;

import java.util.Locale;

public enum DiscountType implements ISubEnum {
    PERCENTAGE("Phần trăm"),AMOUNT("Giảm ngay");

    private final String sub;

    DiscountType(String sub) {
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
