package day0927;

import java.util.Scanner;

//사용자한테 0-9사이의 정수 입력받아 한글표기식 출력하는 프로그램
public class Practice002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.print("0-9 사이정수를 입력하쇼==>");
		n = sc.nextInt();
		String number;
		
		if(n==0) {
			number = "영";
		}
		else if(n==1) {
			number = "일";
		}
		else if(n==2) {
			number = "일";
		}
		else if(n==3) {
			number = "삼";
		}
		else if(n==4) {
			number = "사";
		}
		else if(n==5) {
			number = "오";
		}
		else if(n==6) {
			number = "육";
		}
		else if(n==7) {
			number = "칠";
		}
		else if(n==8) {
			number = "팔";
		}
		else if(n==9) {
			number = "구";
		}
		else {
			number = "잘못 입력했습니다. 0-9 사이의 수를 입력하시오";
		}
		
		System.out.println(number);
		sc.close();
	}
}
