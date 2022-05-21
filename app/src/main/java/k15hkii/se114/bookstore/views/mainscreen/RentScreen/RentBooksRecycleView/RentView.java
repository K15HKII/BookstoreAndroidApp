package k15hkii.se114.bookstore.views.mainscreen.RentScreen.RentBooksRecycleView;

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
