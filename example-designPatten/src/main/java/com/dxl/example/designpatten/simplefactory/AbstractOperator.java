package com.dxl.example.designpatten.simplefactory;

/**
 * @Program AbstractOperator
 * @Description
 * @Author duxl
 * @Create 2018/12/14 9:36
 */
public abstract class AbstractOperator {

	double num1;
	double num2;

	abstract double getResult();

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}
}
