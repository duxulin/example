package com.dxl.example.designpatten.simplefactory;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;

/**
 * @Program SimpleFactoryTest
 * @Description
 * @Author duxl
 * @Create 2018/12/14 10:15
 */
public class SimpleFactoryTest {

	public SimpleFactoryTest() {

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个参数：");
		String num1 = sc.nextLine();
		System.out.println("请输入第二个参数：");
		String num2 = sc.nextLine();
		System.out.println("请输入运算符(+-*/)：");
		String oper = sc.nextLine();
		AbstractOperator operator = SimpleFactory.getOperator(oper);
		operator.setNum1(Double.parseDouble(num1));
		operator.setNum2(Double.parseDouble(num2));
		System.out.println("结果是：" + operator.getResult());

	}


	@Test
	public void test() {
		for (char c = 0; c < 128; c++) {
			System.out.println(c + 0 + ":" + c);
		}

	}

	static void pBinInt(String s, int i) {
		System.out.println(
				s + ", int: " + i + ", binary: ");
		System.out.print(" ");
		for (int j = 31; j >= 0; j--)
			if (((1 << j) & i) != 0)
				System.out.print("1");
			else
				System.out.print("0");
		System.out.println();
	}

	static void pBinLong(String s, long l) {
		System.out.println(
				s + ", long: " + l + ", binary: ");
		System.out.print(" ");
		for (int i = 63; i >= 0; i--)
			if (((1L << i) & l) != 0)
				System.out.print("1");
			else
				System.out.print("0");
		System.out.println();
	}

	static void aprt(int a) {

	}

	static void aprt(int a, int b) {
	}

}
