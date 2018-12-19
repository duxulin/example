package com.dxl.example.designpatten.simplefactory;

/**
 * @Program OperatorDiv
 * @Description
 * @Author duxl
 * @Create 2018/12/14 10:07
 */
public class OperatorDiv extends AbstractOperator {
	@Override
	double getResult() {
		if (num2 == 0)
			throw new IllegalArgumentException("被除数不能为零");
		return num1 / num2;
	}
}
