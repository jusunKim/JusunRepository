package day0926;

import java.util.Scanner;

public class practice01 {
//40세 이상 암검진. 이름과 출생연도 입력
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int year, age;

		
		System.out.print("이름을 입력하세요:");
		name = sc.next();
		System.out.print("출생연도를 입력하세요:");
		year = sc.nextInt();
		
		age = 2023-year;	
		
		if(age>=40)
		{
			System.out.println(name+"님은 무료 검진 대상자입니다.");
		}
		else
		{
			System.out.println(name+"님은 무료 검진 대상자가 아닙니다.");
		}
		
		
	}

}
