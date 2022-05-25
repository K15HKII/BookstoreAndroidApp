package k15hkii.se114.bookstore.ui.bankscreen.BankExpandableListView;

public class BankItems {
    private int _id;
    private String _BankName;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getBankName() {
        return _BankName;
    }

    public void setBankName(String bankName) {
        _BankName = bankName;
    }

    public BankItems(int _id, String bankName) {
        this._id = _id;
        _BankName = bankName;
    }
}
