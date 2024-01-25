package day0927;

import java.util.Scanner;

public class FourBasicOperations {
//사용자에게 두 개의 정수를 입력받아 사칙연산의 결과 출력
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, add, sub, multi, div;
		System.out.print("첫번째 수 입력하시오==>");
		a = sc.nextInt();
		System.out.print("두번째 수 입력하시오==>");
		b = sc.nextInt();
		add= a+b;
		sub = a-b;
		multi = a*b;
		div = a/b;
		System.out.println("더하기:"+add);
		System.out.println("빼기:"+sub);
		System.out.println("곱하기:"+multi);
		System.out.println("나누기:"+div);

	}

}
