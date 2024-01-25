package day0927;

import java.util.Scanner;

//임의의 정수 입력받아 짝수인지 홀수인지 판별
public class EvenOrOdds {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input;
		System.out.print("숫자를 입력하세요==>");
		input = sc.nextInt();
	
		if(input%2==0)
		{
			System.out.println(input+"은(는) 짝수입니다.");
		}
		else
		{
			System.out.println(input+"은(는) 홀수입니다.");
		}
		sc.close();
	}
}
