package k15hkii.se114.bookstore.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import k15hkii.se114.bookstore.BookstoreApp;
import k15hkii.se114.bookstore.di.component.DaggerFragmentComponent;
import k15hkii.se114.bookstore.di.component.FragmentComponent;
import k15hkii.se114.bookstore.di.module.FragmentModule;
import k15hkii.se114.bookstore.ui.components.CloseReturnCallback;
import lombok.Setter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {

    private BaseActivity mActivity;
    private View mRootView;
    private T viewDataBinding;


    @Inject
    protected V viewModel;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection(getBuildComponent());
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mRootView = viewDataBinding.getRoot();
        if (getArguments() != null)
            viewModel.initializeFromBundle(getArguments());
        return mRootView;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding.setVariable(getBindingVariable(), viewModel);
        //viewDataBinding.setLifecycleOwner(this);
        viewDataBinding.executePendingBindings();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewDataBinding.unbind();
        viewDataBinding = null;

        if (closeReturnCallbacks != null) {
            Object data = closeCallbackData;
            for (CloseReturnCallback callback : closeReturnCallbacks) {
                callback.onClose(data);
            }
            closeReturnCallbacks = null;
        }
    }

    @Setter private Object closeCallbackData;

    private List<CloseReturnCallback> closeReturnCallbacks;

    public void addCloseCallback(CloseReturnCallback callback) {
        if (closeReturnCallbacks == null) {
            closeReturnCallbacks = new ArrayList<>();
        }
        closeReturnCallbacks.add(callback);
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public T getViewDataBinding() {
        return viewDataBinding;
    }

    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    public boolean isNetworkConnected() {
        return mActivity != null && mActivity.isNetworkConnected();
    }

    public void openActivityOnTokenExpire() {
        if (mActivity != null) {
            mActivity.openActivityOnTokenExpire();
        }
    }

    public abstract void performDependencyInjection(FragmentComponent buildComponent);


    private FragmentComponent getBuildComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(((BookstoreApp) (getContext().getApplicationContext())).getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    public FragmentTransaction createTransaction(@IdRes int containerId, Class<? extends Fragment> clazz, @Nullable Bundle bundle) {
        return this.getActivity().getSupportFragmentManager().beginTransaction()
                .replace(containerId, clazz, bundle)
                .addToBackStack(null);
    }

    public FragmentTransaction createTransaction(@IdRes int containerId, Fragment fragment, @Nullable Bundle bundle) {
        fragment.setArguments(bundle);
        return this.getActivity().getSupportFragmentManager().beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(null);
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
