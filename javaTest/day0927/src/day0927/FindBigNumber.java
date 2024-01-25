package day0927;

import java.util.Scanner;

//사용자에게 두 개의 정수 입력받아 그 중에 큰 수를 찾아 출력
public class FindBigNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1, n2;
		
		System.out.print("정수1을 입력하세요==>");
		n1 = sc.nextInt();
		System.out.print("정수2을 입력하세요==>");
		n2 = sc.nextInt();
		if(n1 >= n2)
		{
			System.out.printf("큰 수는 %d입니다",n1);
		}
		else
		{
			System.out.printf("큰 수는 %d입니다",n2);
		}
		sc.close();
	}

}
