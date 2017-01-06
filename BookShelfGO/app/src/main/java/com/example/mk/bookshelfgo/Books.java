package com.example.mk.bookshelfgo;

public class Books {

    int code;
    String bname, author, price;

    static int flag = 0;

    /* Setters */
    public void setCode(int code) {
        this.code = flag;
        flag = flag + 1;
    }

    public void setName(String bname) {
        this.bname = bname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    /* Getters */
    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.bname;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPrice() {
        return this.price;
    }
}
