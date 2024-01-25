package day0926;

import java.util.Scanner;

public class Exam05_A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input, hours, minutes, seconds;
		System.out.print("시간을 초 단위로 입력==>");
		input = sc.nextInt();
		
		//입력값이 62라면
		//60으로 나눈 몫은 분, 나머지는 초
		
		hours = input /(60*60);
		input = input %(60*60);
		minutes = input / 60;
		seconds = input % 60;
		System.out.println(hours+ "시간 "+ minutes + "분 " + seconds + "초");

	}

}
