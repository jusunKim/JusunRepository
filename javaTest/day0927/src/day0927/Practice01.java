package day0927;

import java.util.Scanner;

//나이 입력받아 30세 이상이면 입장가능
public class Practice01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age;
		
		System.out.print("나이를 입력하세요ㅣ");
		age = sc.nextInt();
		
		if(age >= 30)
		{
			System.out.println("입장 가능");
		}
		else
		{
			System.out.println("입장 불가");
		}
		sc.close();
	}

}
