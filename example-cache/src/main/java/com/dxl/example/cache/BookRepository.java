package com.dxl.example.cache;

public interface BookRepository {
    Book getByIsbn(String isbn);
}
