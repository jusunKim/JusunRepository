package day0926;

import java.util.Scanner;

public class Exam08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double input, inch, ft;
		System.out.println("키를 입력하시오.:");
		input = sc.nextDouble();
		inch =input /2.54;
		ft = inch /12;
		inch = inch % 12;
		System.out.printf((int)input+"cm는" + (int)ft+"피트 %.5f인치입니다",inch);
	}

}
