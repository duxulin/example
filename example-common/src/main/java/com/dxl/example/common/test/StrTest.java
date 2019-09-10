package com.dxl.example.common.test;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 写字符串的分析函数，分析一个由字母和数字组成的字符串，例如aBc12D9
 * 1、输出字符串中字符和数字的个数。
 * 2、相连的数字不能分为2个，即12是作为一个数字统计，输出字符串中字符和数字的个数。
 * 3、字符大小写不区分，统计字符的个数及出现次数。
 * 4、统计出现次数最多的字符和数字。
 * 按照上面的要求，写4个函数
 * @author duxl
 */
public class StrTest {
	/**
	 * 1、输出字符串中字符和数字的个数。
	 * @param s
	 */
	public static void countCharAndNum(String s){
		if(s == null){
			return ;
		}

		int charCount=0;
		int numCount=0;
		for(char c:s.toCharArray()){
			if(c>='0' && c<='9'){
				numCount++;
			}else{
				charCount++;
			}

		}
		System.out.println("charCount:"+charCount);
		System.out.println("numCount:"+numCount);
	}

	/**
	 * 2、相连的数字不能分为2个，即12是作为一个数字统计，输出字符串中字符和数字的个数。
	 */
	public static  void countCharAndNum2(String s){
		if(s == null){
			return ;
		}
		int charCount=0;
		int numCount=0;
		boolean flag = false;
		for(int i = 0;i<s.length();i++){
			char c = s.charAt(i);
			if(c>='0' && c<='9'){
				flag = true;
			}else{
				charCount++;
				if(flag){
					numCount++;
					flag = false;
				}
			}
			if((i== s.length()-1) && flag){
				numCount++;
			}
		}
		System.out.println("charCount:"+charCount);
		System.out.println("numCount:"+numCount);


	}
	/**
	 * 3、字符大小写不区分，统计字符的个数及出现次数。
	 */
	public static void countCharAndNumIgnoreCase(String s){
		if(s == null){
			return;
		}

		Map<Character,Integer> map = new HashMap<>();
		s = s.toLowerCase();
		for(char c:s.toCharArray()){
			if(map.containsKey(c)){
				map.put(c,map.get(c)+1);
			}else{
				map.put(c,1);
			}
		}
		for(Map.Entry<Character,Integer> entry:map.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}

	}
	/**
	 * 4、统计出现次数最多的字符和数字。
	 */
	public static void countMostCharAndMostNum(String s){
		if(s == null){
			return;

		}
		Map<Character,Integer> charMap = new HashMap<>();
		Map<Character,Integer> numMap = new HashMap<>();
		for(char c:s.toCharArray()){
			if(c>='0' && c<='9'){
				if(numMap.containsKey(c)){
					numMap.put(c,numMap.get(c)+1);
				}else{
					numMap.put(c,1);
				}
			}else{
				if(charMap.containsKey(c)){
					charMap.put(c,charMap.get(c)+1);
				}else{
					charMap.put(c,1);
				}
			}

		}

		Integer charMaxCount = Collections.max(charMap.values());
		Integer numMaxCount = Collections.max(numMap.values());
		System.out.print("同一字符出现最多的有"+charMaxCount+"次，这些字符有：");
		for(Map.Entry<Character,Integer> entry:charMap.entrySet()){
			if(entry.getValue().intValue() ==  charMaxCount){
				System.out.print(entry.getKey()+" ");
			}
		}
		System.out.println();
		System.out.print("同一数字出现最多的有"+numMaxCount+"次，这些数字有：");
		for(Map.Entry<Character,Integer> entry:numMap.entrySet()){
			if(entry.getValue().intValue() ==  numMaxCount){
				System.out.print(entry.getKey()+" ");
			}
		}
		System.out.println();
	}



	@Test
	public void test(){
		String s = "abB45caad2D3193bb3444555";
		countCharAndNumIgnoreCase(s);

	}
}
