package day0927;

import java.util.Scanner;

//사용자에 두개의 정수 입력받아 그중에 큰수 찾는 프로그램을 삼항연산자 이용해 작성하기
public class FindBigNumber_Conditional {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1,n2;
		
		System.out.print("정수1을 입력하세요==>");
		n1 = sc.nextInt();
		System.out.print("정수2를 입력하세요==>");
		n2 = sc.nextInt();
		
		int result = (n1>=n2)?n1:n2;
		System.out.println(result);
		
		sc.close();

	}

}
