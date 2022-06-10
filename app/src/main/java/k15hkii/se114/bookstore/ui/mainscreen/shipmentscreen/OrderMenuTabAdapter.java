package k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.cancleorder.CancleOrder;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.shipmentarrived.ShipmentArrivedViewPage;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.shippingview.ShippingViewPage;
import k15hkii.se114.bookstore.ui.mainscreen.shipmentscreen.waitingorderview.WaitingOrderViewPage;
import org.jetbrains.annotations.NotNull;

public class OrderMenuTabAdapter extends FragmentStateAdapter {

    public OrderMenuTabAdapter(@NonNull @NotNull FragmentManager fm, Lifecycle lifecycle) {
        super(fm, lifecycle);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 1:
                return new ShippingViewPage();
            case 2:
                return new ShipmentArrivedViewPage();
            case 3:
                return new CancleOrder();
            default:
                return new WaitingOrderViewPage();
        }
    }
}
