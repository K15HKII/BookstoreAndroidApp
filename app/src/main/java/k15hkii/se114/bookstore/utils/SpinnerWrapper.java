package k15hkii.se114.bookstore.utils;

import k15hkii.se114.bookstore.data.model.ISubEnum;
import lombok.Getter;

public abstract class SpinnerWrapper<T> {

    @Getter
    private final T item;

    public SpinnerWrapper(T item) {
        this.item = item;
    }

    public abstract String getDisplay();

    public static <T extends ISubEnum> SpinnerWrapper<T>[] toSpinner(T... items) {
        SpinnerWrapper<T>[] wrappers = new SpinnerWrapper[items.length];
        for (int i = 0; i < items.length; i++) {
            wrappers[i] = new SpinnerWrapper<T>(items[i]) {
                @Override
                public String getDisplay() {
                    return getItem().toDefaultLocale();
                }
            };
        }
        return wrappers;
    }

}
