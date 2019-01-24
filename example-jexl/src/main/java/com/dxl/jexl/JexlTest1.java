package com.dxl.jexl;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

import java.util.concurrent.*;

/**
 * @Program JexlTest1
 * @Description
 * @Author duxl
 * @Create 2019/1/11 9:06
 */
public class JexlTest1 {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 200, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

		MapContext context = new MapContext();
		JexlEngine jexlEngine = new JexlEngine();
		Expression expression = jexlEngine.createExpression("3*(2+8)");
		Object result = expression.evaluate(context);
		System.out.println(result);

	}
}
