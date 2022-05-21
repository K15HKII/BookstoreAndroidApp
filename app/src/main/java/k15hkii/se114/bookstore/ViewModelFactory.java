package k15hkii.se114.bookstore;

import androidx.annotation.NonNull;
import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory<T extends ViewModel> extends ViewModelProvider.NewInstanceFactory {

    private final Class<T> viewModelClass;
    private final Supplier<T> viewModelSupplier;

    public ViewModelFactory(@NonNull Class<T> viewModelClass, @NonNull Supplier<T> viewModelSupplier) {
        this.viewModelClass = viewModelClass;
        this.viewModelSupplier = viewModelSupplier;
    }

    @NonNull
    public <V extends ViewModel> V create(@NonNull Class<V> modelClass) {
        if (modelClass.isAssignableFrom(viewModelClass)) {
            return modelClass.cast(viewModelSupplier.get());
        } else {
            throw new IllegalArgumentException("Unknown Class name " + viewModelClass.getName());
        }
    }

}
