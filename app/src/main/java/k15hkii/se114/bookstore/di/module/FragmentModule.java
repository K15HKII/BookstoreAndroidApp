package k15hkii.se114.bookstore.di.module;

import dagger.Module;
import k15hkii.se114.bookstore.viewmodel.base.BaseFragment;
import lombok.AllArgsConstructor;

@Module
@AllArgsConstructor
public class FragmentModule {

    private final BaseFragment<?, ?> fragment;

}
