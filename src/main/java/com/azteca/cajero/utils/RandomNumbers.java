package com.azteca.cajero.utils;

import java.util.Random;

public class RandomNumbers {
	
	private static final int MIN = 1;
	private static final int MAX = 9999;
	private static final Random random = new Random();
	
	public static String numberCard() {
		return fillNumber(String.valueOf(random.nextInt(MAX + MIN) + MIN)) + "-"
			+ fillNumber(String.valueOf(random.nextInt(MAX + MIN) + MIN)) + "-"
			+ fillNumber(String.valueOf(random.nextInt(MAX + MIN) + MIN)) + "-"
			+ fillNumber(String.valueOf(random.nextInt(MAX + MIN) + MIN));
	}
	
	private static String fillNumber(String number) {
		while (true) {
			if (number.length() < 4) number = "0" + number;
			else return number;
		}
	}

}
