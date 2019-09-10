package com.dxl.example.common.test;

import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RemoveMostCharTest {


	@Test
	public void test1() {
		String source = "ABCCDEER";
		System.out.println(removeMostChar(source));


	}

	/**
	 * 要求：删除一个字符串中出现次数最多的字符，如果多个字符出现次数一样，则都删除。要求字符顺序不变
	 * @param str
	 * @return
	 */
	public static String removeMostChar(String str) {
		if (str == null) {
			return null;
		}
		if (str == "" || str.length() == 1) {
			return "";
		}

		Map<Character, Integer> map = new HashMap<>();
//		int maxCount=0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (map.containsKey(c)) {
				Integer count = map.get(c) + 1;
//				maxCount = maxCount>count?maxCount:count;
				map.put(c, count);
			} else {
				map.put(c, 1);
//				maxCount = maxCount>1?maxCount:1;
			}
		}
		Integer max = Collections.max(map.values());
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue().intValue() == max.intValue()) {
				str = str.replace(entry.getKey().toString(), "");
			}
		}
		return str;

	}
}
