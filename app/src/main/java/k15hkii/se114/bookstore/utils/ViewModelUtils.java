package k15hkii.se114.bookstore.utils;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import k15hkii.se114.bookstore.ViewModelFactory;
import k15hkii.se114.bookstore.ui.base.BaseViewModel;

public class ViewModelUtils {

    public static <VM extends BaseViewModel> VM createViewModel(ViewModelStoreOwner owner, Class<VM> clazz, Supplier<VM> supplier) {
        return new ViewModelProvider(owner, new ViewModelFactory<>(clazz, supplier)).get(clazz);
    }

}
