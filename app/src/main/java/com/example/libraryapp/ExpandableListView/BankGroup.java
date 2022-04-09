package com.example.libraryapp.ExpandableListView;

public class BankGroup {
    private int _id;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_BankGroupName() {
        return _BankGroupName;
    }

    public void set_BankGroupName(String _BankGroupName) {
        this._BankGroupName = _BankGroupName;
    }

    public BankGroup(int _id, String _BankGroupName) {
        this._id = _id;
        this._BankGroupName = _BankGroupName;
    }

    private String _BankGroupName;
}
