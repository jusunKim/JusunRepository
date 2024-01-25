package day0926;

import java.util.Scanner;

public class BooleanTest03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age;
		System.out.print("나이 입력:");
		age = sc.nextInt();
		if( age >=20 ) //if조건식에는 boolean이 오도록해야함!!!!
		{
			System.out.println("20살이상입니다.");
		}
		else
		{
			System.out.println("20살미만임");
		}
	}

}
