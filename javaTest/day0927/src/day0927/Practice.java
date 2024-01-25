package day0927;

import java.util.Scanner;

//사용자한테 임의의 수 n을 입력받아 그게 1-100사이의 범위 밖에 있는지 판별
public class Practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.print("수를 입력하세요==>");
		n = sc.nextInt();
		
		if(n>100 || n<1)
		{
			System.out.println("1-100범위 밖에 있는 수가 맞습니다.");
		}
		else
		{
			System.out.println("1-100범위 밖에 있는 수가 아닙니다.");
		}
		sc.close();
	}

}
