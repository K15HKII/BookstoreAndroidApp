package com.example.libraryapp.mainscreen.RentScreen.RentBooksRecycleView;

import com.example.libraryapp.mainscreen.ShipmentScreen.OrderShipmentAdapter.OrderItemsRecycleView.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class RentView {
    String price;
    String note;
    List<RentBookItem> lsRentItem;
}
