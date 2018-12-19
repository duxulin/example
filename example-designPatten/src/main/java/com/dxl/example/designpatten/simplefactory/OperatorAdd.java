package com.dxl.example.designpatten.simplefactory;

/**
 * @Program OperatorAdd
 * @Description
 * @Author duxl
 * @Create 2018/12/14 9:37
 */
public class OperatorAdd extends AbstractOperator {

	@Override
	double getResult() {
		return num1 + num2;
	}
}
