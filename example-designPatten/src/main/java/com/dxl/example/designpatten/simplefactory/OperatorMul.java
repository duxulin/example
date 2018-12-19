package com.dxl.example.designpatten.simplefactory;

/**
 * @Program OperatorMul
 * @Description
 * @Author duxl
 * @Create 2018/12/14 9:41
 */
public class OperatorMul extends AbstractOperator {
	@Override
	double getResult() {
		return num1 * num2;
	}
}
