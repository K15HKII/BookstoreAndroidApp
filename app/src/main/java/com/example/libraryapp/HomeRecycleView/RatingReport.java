package com.example.libraryapp.HomeRecycleView;

public class RatingReport {
    String bookname;

    public RatingReport(String bookname) {
        this.bookname = bookname;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}