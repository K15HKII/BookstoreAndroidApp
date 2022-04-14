package com.example.libraryapp.HomeRecycleView;

import java.util.List;

public class OrderView {
    String price;
    String note;
    List<BookView> lsBooks;

    public OrderView(String price, String note, List<BookView> lsBooks) {
        this.price = price;
        this.note = note;
        this.lsBooks = lsBooks;
    }

    public List<BookView> getLsBooks() {
        return lsBooks;
    }

    public void setLsBooks(List<BookView> lsBooks) {
        this.lsBooks = lsBooks;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
