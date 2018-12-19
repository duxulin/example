package com.dxl.example.rabbit;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Program Person
 * @Description
 * @Author duxl
 * @Create 2018/11/20 9:37
 */
@Data
public class Person {
	@NotNull(message = "name can not be null")
	private String name;
	@Min(value = 18, message = "未满18，禁止入内")
	private int age;

	public static void main(String[] args) {
		double d = 0.9;
		System.out.println(new BigDecimal("2.445").setScale(2, RoundingMode.HALF_DOWN));
		System.out.println(new BigDecimal("2.445").setScale(2, RoundingMode.HALF_UP));
	}

}
