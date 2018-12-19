package com.dxl.example.designpatten.simplefactory;

/**
 * @Program SimpleFactory
 * @Description
 * @Author duxl
 * @Create 2018/12/14 9:17
 */
public class SimpleFactory {

	public static AbstractOperator getOperator(String operator) {
		AbstractOperator result;
		switch (operator) {
			case "+":
				result = new OperatorAdd();
				break;
			case "-":
				result = new OperatorSub();
				break;
			case "*":
				result = new OperatorMul();
				break;
			case "/":
				result = new OperatorDiv();
				break;
			default:
				throw new IllegalArgumentException("不支持的计算符号：" + operator);
		}
		return result;
	}


}
