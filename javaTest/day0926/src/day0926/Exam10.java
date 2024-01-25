package day0926;

import java.util.Scanner;

public class Exam10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start, end, distance, use, result;
		System.out.print("출발한 지점의 주행 거리계: ");
		start = sc.nextInt();
		System.out.print("도착한 지점의 주행 거리계: ");
		end = sc.nextInt();
		System.out.print("사용한 연료: ");
		use = sc.nextInt();
		
		distance = end - start;
		result = distance/use;
				
		System.out.printf("연비는 %dkm/l입니다.",result);
	}

}
