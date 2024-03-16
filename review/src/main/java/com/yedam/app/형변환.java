package com.yedam.app;

/* 
 * byte	- Byte
 * char	- Character
 * int	- Integer
 * short
 * long
 * float
 * double
 * boolean
 * */

public class 형변환 {
	public static void main(String[] args) {

		// Wrapper Class
		Integer score = 100;
		String s = Integer.toString(score);

		double avg = 90.5;
		s = Double.toString(avg);

		// string ==> other type
		score = Integer.parseInt(s);
		avg = Double.parseDouble(s);
	}
}
