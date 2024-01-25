package day0927;

import java.util.Scanner;

/*40세이상 암검진 무료
 이름.출생연도 입력받아 대상자인치 판별하기
 
 이름 입력
 출생연도 입력
 나이 계산
 나이 40세 이상?
   true => 대상자
   false => 대상자 아님
 */
public class FreeCancerScreening {
	public static void main(String[] args) {
		String name;
		int year, age;
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하시오 ==>");
		name = sc.next();
		System.out.print("출생연도를 입력하시오 ==>");
		year = sc.nextInt();
		age = 2023 - year;
		if( age >=40 )
		{
			System.out.println(name+ "님은 무료검진 대상자입니다.");
		}
		else
		{
			System.out.println(name+ "님은 무료검진 대상자가 아닙니다.");
		}
		

	}

}
