package k15hkii.se114.bookstore.utils;

import lombok.Getter;

public abstract class SpinnerWrapper<T> {

    @Getter private final T item;

    public SpinnerWrapper(T item) {
        this.item = item;
    }

    public abstract String getDisplay();

}
