package com.lianyun.scan.util;

public class RandomUtil {

	public static int randomInt(int n) {

		return (int) (Math.random() * n);
	}

	public static String randomString(int n) {

		String s = "";
		for (int i = 0; i < n; i++) {
			char c = 'a';
			c += randomInt(26);
			s += c;
		}

		return s;
	}
	
	public static void main(String[] args) {
		System.out.println(randomString(1000));
	}

}
