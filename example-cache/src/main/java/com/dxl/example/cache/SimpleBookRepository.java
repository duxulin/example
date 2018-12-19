package com.dxl.example.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @Program SimpleBookRepository
 * @Description
 * @Author duxl
 * @Create 2018/11/15 9:05
 */
@Component
public class SimpleBookRepository implements BookRepository {
	@Cacheable("books")
	@Override
	public Book getByIsbn(String isbn) {
		slowly();
		return new Book(isbn, "Some Book");
	}

	private void slowly() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
