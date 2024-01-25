package day0927;

import java.util.Scanner;

//나이와 키를 입력받아 나이가 30세 이상이고,키는 170이하이면 "입장가능" 아니면 "입장불가"를 출력
public class EnterClub02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age;
		double height;
		String result="입장 불가";  
				
		System.out.print("나이를 입력하세요: ");
		age = sc.nextInt();
		System.out.print("키를 입력하세요: ");
		height = sc.nextDouble();
		if(age>=30 && height <=170)
		{
			result = "입장 가능";
		}
		System.out.println(result);
		sc.close();
	}
}
