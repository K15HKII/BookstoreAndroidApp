package k15hkii.se114.bookstore.data.model.api.lend;

import k15hkii.se114.bookstore.data.model.ISubEnum;

import java.util.Locale;

public enum LendStatus implements ISubEnum {
    RENTING("Đang thuê"),RENTED("Đã thuê");

    private final String sub;

    LendStatus(String sub) {
        this.sub = sub;
    }

    @Override
    public String toDefaultLocale() {
        return null;
    }

    @Override
    public String toLocale(Locale locale) {
        return null;
    }
}
