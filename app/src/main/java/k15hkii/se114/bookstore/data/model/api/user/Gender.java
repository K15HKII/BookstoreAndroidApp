package k15hkii.se114.bookstore.data.model.api.user;

import k15hkii.se114.bookstore.data.model.ISubEnum;

import java.util.Locale;

public enum Gender implements ISubEnum {

    MALE("Nam"), FEMALE("Nữ"), OTHER("Khác");

    private final String sub;

    Gender(String sub) {
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
