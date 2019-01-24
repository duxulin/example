package com.dxl.example.thread;

import java.io.*;

/**
 * @Program ObjectOutputStreamTest
 * @Description
 * @Author duxl
 * @Create 2019/1/9 15:17
 */
public class ObjectOutputStreamTest implements Serializable {

	private int i = 2;
	private String name = "test";

	static ObjectOutputStream oops ;
	static ObjectInputStream oips;

	public static void main(String[] args) throws Exception {
		ObjectOutputStreamTest test = new ObjectOutputStreamTest();
		FileOutputStream fops = new FileOutputStream("c:/a.txt");
		FileInputStream fips = new FileInputStream("c:/a.txt");
		try {
			oops = new ObjectOutputStream(fops);
			oops.writeObject(test);

			oips = new ObjectInputStream(fips);
			Object o = oips.readObject();
			if(o instanceof ObjectOutputStreamTest){
				System.out.println("done");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oops.close();
				oips.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
