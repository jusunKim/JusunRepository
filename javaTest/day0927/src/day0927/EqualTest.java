package day0927;

import java.util.Scanner;

//관리자 나이와 직원 나이 입력받아 두 사람의 나이가 같은지 판별
public class EqualTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ageManager, ageEmp;
		
		System.out.print("관리자 나이 입력하세요:");
		ageManager = sc.nextInt();
		System.out.print("직원 나이 입력하세요:");
		ageEmp = sc.nextInt();
		if(ageManager == ageEmp)
		{
			System.out.println("나이가 같습니다");
		}
		else
		{
			System.out.println("나이가 다릅니다");
		}
		sc.close();
	}

}
