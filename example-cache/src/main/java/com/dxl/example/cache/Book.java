package com.dxl.example.cache;

import lombok.Data;

import java.io.Serializable;

/**
 * @Program Book
 * @Description
 * @Author duxl
 * @Create 2018/11/15 9:03
 */
@Data
public class Book implements Serializable {
    private String isbn;

    private String title;

    public Book() {
    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    /*public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }*/
}
