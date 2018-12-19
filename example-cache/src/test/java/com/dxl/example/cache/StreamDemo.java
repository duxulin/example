package com.dxl.example.cache;

import org.junit.Test;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Program StreamDemo
 * @Description
 * @Author duxl
 * @Create 2018/11/15 10:35
 */
public class StreamDemo {

	@Test
	public void a() {
		IntStream.range(1, 10).filter(a -> a % 2 == 0).peek(System.out::println).forEach(System.out::println);
	}

	@Test
	public void b() {
		Stream.of("apple", "banana", "orange", "apple")
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.forEach(e -> System.out.println(e));
	}
}
