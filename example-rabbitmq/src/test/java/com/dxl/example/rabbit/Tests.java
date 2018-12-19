package com.dxl.example.rabbit;

import org.junit.Test;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Program Tests
 * @Description
 * @Author duxl
 * @Create 2018/11/16 9:37
 */

public class Tests {
	//a 分支作了修改


	//test修改2
	@Test
	public void spelTest() throws Exception {

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str3 = "1927-12-31 23:54:07";
		String str4 = "1927-12-31 23:54:08";
		Date sDt3 = sf.parse(str3);
		Date sDt4 = sf.parse(str4);
		long ld3 = sDt3.getTime() / 1000;
		long ld4 = sDt4.getTime() / 1000;
		System.out.println(ld4 - ld3);

	}

	public static void main(String[] args) {
		String result = helloWorld();
		result.trim();
		System.out.println(result);

		change(null);
	}

	@NotNull(message = "not be null")
	public static String helloWorld() {
		//return "Hello World";
		return null;
	}

	public static void change(@NotNull Person person) {

		System.out.println("a");
	}
}
