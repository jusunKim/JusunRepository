package day0927;

import java.util.Scanner;

//사용자에 임의의 수 n 입력받아 그 수가 100사이의 수인지 판별하는 프로그램
public class OutRange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.print("1에서 100사이의 수를 입력하세요==>");
		n = sc.nextInt();
		System.out.printf("%s은(는) ",n);
		if(n <1 || n>100)
		{
			System.out.println("1-100밖의 수입니다");
		}
		else
		{
			System.out.println("1-100밖의 수가 아닙니다");
		}
		sc.close();
	}
	
}
